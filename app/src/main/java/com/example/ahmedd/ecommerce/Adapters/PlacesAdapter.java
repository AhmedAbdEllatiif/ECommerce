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

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    ArrayList<ItemView> itemViews;
    Context context;

    public PlacesAdapter(ArrayList<ItemView> itemViews, Context context) {
        this.itemViews = itemViews;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_cv, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemView itemView = itemViews.get(position);

        holder.placeImg.setImageResource(itemView.getPlaceImg());
        holder.placeText.setText(itemView.getPlaceText());

    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView placeText;
        ImageView placeImg;

        public ViewHolder(View itemView) {
            super(itemView);
            placeText = itemView.findViewById(R.id.place_name_id);
            placeImg = itemView.findViewById(R.id.imag_place_ava);


        }
    }
}
