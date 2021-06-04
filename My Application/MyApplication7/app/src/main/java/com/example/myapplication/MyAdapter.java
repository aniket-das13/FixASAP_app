package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<ListData> listData;

    public MyAdapter(List<ListData> listData) {
        this.listData = listData;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lidt_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListData ld=listData.get(position);
        holder.rname.setText(ld.getName());
        holder.remail.setText(ld.getEmail());
        holder.rpin.setText(ld.getPin());
        holder.rphno.setText(ld.getContactno());


        holder.rcost.setText(ld.getRepaircost());
        holder.rtime.setText(ld.getDuration());

        holder.rdt.setText(ld.getDeliveryType());
        holder.rexp.setText(ld.getExp());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private EditText rname,rphno,remail,rpin,rcost,rtime;
        private TextView rexp,rdt;
        public ViewHolder(View itemView) {
            super(itemView);
            rname=(EditText) itemView.findViewById(R.id.resname);
            rphno=(EditText) itemView.findViewById(R.id.resphno);
            remail=(EditText) itemView.findViewById(R.id.resemail);
            rpin=(EditText) itemView.findViewById(R.id.respin);
            rexp=(TextView) itemView.findViewById(R.id.resexptype);
            rcost=(EditText) itemView.findViewById(R.id.rescost);
            rtime=(EditText) itemView.findViewById(R.id.resduration);
            rdt=(TextView) itemView.findViewById(R.id.resdeltype);
            }
    }
}
