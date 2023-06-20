package com.example.vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    //4. Handling the click Events
    private static ItemClickListener clickListener;

    //1. Data Source
    private VaccineModel[] listdata;

    public MyAdapter(VaccineModel[] listdata) {
        this.listdata = listdata;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    //2. View Holder Class
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView=itemView.findViewById(R.id.imageView);
            this.textView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    //3. Implementing the methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View listitem=inflater.inflate(R.layout.recyclerview_item,parent, false);
        MyViewHolder viewHolder=new MyViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final VaccineModel mylistData=listdata[position];
        holder.textView.setText(listdata[position].getTitle());
        holder.imageView.setImageResource(listdata[position].getImage());

    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

}
