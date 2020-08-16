package com.goteam.testrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements View.OnClickListener {

    private ArrayList<CPersonage> personages;
    View.OnClickListener onClickListener;

    public CustomAdapter(ArrayList<CPersonage> data) {
        this.personages = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_country;
        ImageView iv_photo;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tv_name = itemView.findViewById(R.id.textView_name);
            this.tv_country = itemView.findViewById(R.id.textView_country);
            this.iv_photo = itemView.findViewById(R.id.imageView_photo);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Change for vertical o horizontal design
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_items, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_items, parent, false);

        // view.setOnClickListener(MainActivity.myOnClickListener);
        view.setOnClickListener(this);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_name.setText(personages.get(position).getName());
        holder.tv_country.setText(personages.get(position).getCountry());
        holder.iv_photo.setImageResource(personages.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return personages.size();
    }

    @Override
    public void onClick(View v) {
        if (onClickListener != null) {
            onClickListener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}