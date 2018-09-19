package com.example.ahmedd.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.ahmedd.ecommerce.Adapters.HomeAdapter;
import com.example.ahmedd.ecommerce.Model.ItemView;
import java.util.ArrayList;


public class MainActivity extends BaseActivity {


    private AppBarLayout appBarLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView my_title;
    private RecyclerView discountCoupon_RC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountCoupon_RC = (RecyclerView) findViewById(R.id.discountCoupon_RC);
        setupRecyclerViewDiscountCoupon();
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);

        //setupToolBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        my_title = (TextView) findViewById(R.id.my_title);
        setSupportActionBar(toolbar);
        my_title.setText(R.string.home);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //setupDrawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //setupNavigation //navigation inside drawer
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(listenerNavigation);
        navigationView.setCheckedItem(R.id.nav_home);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    //Listener of Navigation view inside drawer
    private NavigationView.OnNavigationItemSelectedListener listenerNavigation
            = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Intent intent = new Intent(MainActivity.this,CouponActivity.class);
                startActivity(intent);
                finish();

            } else if (id == R.id.nav_coupons) {
                my_title.setText("Coupons");


            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_send) {

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    //setup the Recyecler view of discount coupons in the MainActivity
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
