package com.example.ahmedd.ecommerce.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedd.ecommerce.Model.ItemView;
import com.example.ahmedd.ecommerce.R;

import java.util.ArrayList;

public class DicountCouponAdapter extends RecyclerView.Adapter<DicountCouponAdapter.ViewHolder> {

    ArrayList<ItemView> itemViews;
    Context context;

    public DicountCouponAdapter(ArrayList<ItemView> itemViews, Context context) {
        this.itemViews = itemViews;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtSummerNights;
        ImageView summerImg;

        public ViewHolder(View itemView) {
            super(itemView);
            txtSummerNights = itemView.findViewById(R.id.txtSummerNights);
            summerImg = itemView.findViewById(R.id.summerImg);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.discountcoupon_cv,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemView itemView = itemViews.get(position);

        holder.txtSummerNights.setText(itemView.getHotSummer());
        holder.summerImg.setImageResource(itemView.getSummerImg());
    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }
}
