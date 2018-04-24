package com.rasyidk.fa.infokajian;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rasyidk.fa.infokajian.model.Kajian;
import com.rasyidk.fa.infokajian.model.RecyclerViewAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private ArrayList<Kajian> kajians = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public DashboardFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_kajian);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("sedang mengambil data");
        progressDialog.show();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("kajian").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Kajian kajian = noteDataSnapshot.getValue(Kajian.class);
                    kajian.setKey(noteDataSnapshot.getKey());

                    kajians.add(kajian);
                }

                adapter = new RecyclerViewAdapter(kajians, getContext());
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getDetails());
            }
        });

        return view;
    }
}
