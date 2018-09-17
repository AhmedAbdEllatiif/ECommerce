package com.example.ahmedd.ecommerce.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ahmedd.ecommerce.Adapters.HomeAdapter;
import com.example.ahmedd.ecommerce.Model.ItemView;
import com.example.ahmedd.ecommerce.R;
import java.util.ArrayList;

public class HomeFragment extends BaseFragment {

    private View view;
    private RecyclerView discountCoupon_RC;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      view =  inflater.inflate(R.layout.fragment_home, container, false);

        setupAllViews();
        setupRecyclerViewDiscountCoupon();

        return view;
    }


    private void setupAllViews(){
        ImageView discountBook_img = view.findViewById(R.id.discountBook_img);
        TextView txtDiscountCoupon  = view.findViewById(R.id.txtDiscountCoupon);
        discountCoupon_RC = view.findViewById(R.id.discountCoupon_RC);
    }



    private void setupRecyclerViewDiscountCoupon(){

        ArrayList<ItemView> itemViews = new ArrayList<>();
        discountCoupon_RC.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));

        for (int i=0; i<50; i++){
            ItemView itemView = new ItemView("Hot Summer Nights",R.drawable.summer_image);
            itemViews.add(itemView);
        }


        HomeAdapter adapter = new HomeAdapter(itemViews, activity);
        discountCoupon_RC.setAdapter(adapter);
    }

}
