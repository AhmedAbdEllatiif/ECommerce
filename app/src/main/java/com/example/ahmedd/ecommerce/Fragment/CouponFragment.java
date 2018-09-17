package com.example.ahmedd.ecommerce.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmedd.ecommerce.Adapters.DiscountAdapter;
import com.example.ahmedd.ecommerce.Model.ItemView;
import com.example.ahmedd.ecommerce.R;

import java.util.ArrayList;

public class CouponFragment extends BaseFragment {


    public CouponFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_coupon, container, false);


         ArrayList<ItemView> itemViews = new ArrayList<>();
         DiscountAdapter adapter ;
         RecyclerView recyclerView = view.findViewById(R.id.discount_Rc);
         recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        for (int i=0; i<50; i++){
            ItemView itemView = new ItemView(R.drawable.car);

            itemViews.add(itemView);
        }

        adapter = new DiscountAdapter(itemViews,activity);
        recyclerView.setAdapter(adapter);
         return view;
    }

}
