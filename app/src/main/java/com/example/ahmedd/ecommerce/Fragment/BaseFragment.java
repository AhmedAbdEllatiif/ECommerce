package com.example.ahmedd.ecommerce.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.ahmedd.ecommerce.BaseActivity;

public class BaseFragment extends Fragment {

   protected BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) context;
    }
}
