package com.example.ahmedd.ecommerce.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmedd.ecommerce.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeautyFragment extends Fragment {


    public BeautyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beauty, container, false);
    }

}
