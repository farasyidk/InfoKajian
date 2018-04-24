package com.rasyidk.fa.infokajian.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rasyidk.fa.infokajian.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Kajian> kajians;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Kajian> kajians, Context ctx) {
        this.kajians = kajians;
        this.context = ctx;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.txtNamaKajian.setText(kajians.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return kajians.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNamaKajian;
        public ViewHolder(View itemView) {
            super(itemView);
            txtNamaKajian = (TextView)itemView.findViewById(R.id.txtNamaKajian);
        }
    }
}
