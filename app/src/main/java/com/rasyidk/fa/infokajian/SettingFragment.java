package com.rasyidk.fa.infokajian;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rasyidk.fa.infokajian.model.Kajian;

import java.util.concurrent.Executor;

import static android.text.TextUtils.isEmpty;

public class SettingFragment extends Fragment {

    Button btnPublish;
    EditText txtNama, txtWaktu, txtDate, txtLokasi, txtDeskripsi;
    private DatabaseReference database;
    public SettingFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_settings, container, false);

        database = FirebaseDatabase.getInstance().getReference();

        txtNama = (EditText) view.findViewById(R.id.txtNamaKajian);
        txtWaktu = (EditText) view.findViewById(R.id.txtTime);
        txtDate = (EditText)view.findViewById(R.id.txtTanggal);
        txtLokasi = (EditText) view.findViewById(R.id.txtLokasi);
        txtDeskripsi = (EditText) view.findViewById(R.id.txtDeskripsi);
        btnPublish = (Button)view.findViewById(R.id.btnPublish);

        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(txtNama.getText().toString()) && !isEmpty(txtWaktu.getText().toString()) && !isEmpty(txtDate.getText().toString())
                        && !isEmpty(txtLokasi.getText().toString()) && !isEmpty(txtDeskripsi.getText().toString())) {
                    submitKajian(new Kajian(txtNama.getText().toString(), txtWaktu.getText().toString(), txtDate.getText().toString(),
                            txtLokasi.getText().toString(), txtDeskripsi.getText().toString()));
                } else {
                    Toast.makeText(getContext(), "Data gagal update", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void submitKajian(Kajian kajian) {
        database.child("kajian").push().setValue(kajian).addOnSuccessListener((Activity) getContext(), new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                txtNama.setText("");
                txtDate.setText("");
                txtDeskripsi.setText("");
                txtLokasi.setText("");
                txtWaktu.setText("");
                Toast.makeText(getContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
