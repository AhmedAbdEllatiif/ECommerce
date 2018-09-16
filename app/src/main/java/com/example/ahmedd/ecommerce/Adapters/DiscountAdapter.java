package com.example.ahmedd.ecommerce.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ahmedd.ecommerce.Model.ItemView;
import com.example.ahmedd.ecommerce.R;

import java.util.ArrayList;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.ViewHolder> {

    ArrayList<ItemView> itemViews;
    Context context;

    public DiscountAdapter (ArrayList<ItemView> itemViews, Context context) {
        this.itemViews = itemViews;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView carImg;
        public ViewHolder(View itemView) {
            super(itemView);

            carImg = itemView.findViewById(R.id.carImg);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.discount_cv,parent,false);

        return new ViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemView itemView = itemViews.get(position);
        holder.carImg.setImageResource(itemView.getSummerImg());
    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }
}
