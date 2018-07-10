package com.example.android.group;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder>  {

    private List<Vehicle> vehicleList;
    private Context context;


    public VehicleAdapter(Context context, List vehicleList) {
        this.context = context;
        this.vehicleList = vehicleList;
    }

    @NonNull
    @Override
    public VehicleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vehicleslist, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);

        return viewHolder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView fine,Offence,rule,type;

        public MyViewHolder(View view) {
            super(view);
            fine = (TextView) view.findViewById(R.id.fine);
            Offence = (TextView) view.findViewById(R.id.offence);
            rule = (TextView) view.findViewById(R.id.rule);
            type = (TextView) view.findViewById(R.id.type);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleAdapter.MyViewHolder holder, int position) {

        Vehicle v  = vehicleList.get(position);
        holder.itemView.setTag(vehicleList.get(position));

        holder.fine.setText(v.getFine());
        holder.Offence.setText(v.getOffence());
        holder.rule.setText(v.getRule());
        holder.type.setText(v.getType());

    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }
}
