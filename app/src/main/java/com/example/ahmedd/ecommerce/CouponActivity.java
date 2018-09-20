package com.example.ahmedd.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedd.ecommerce.Adapters.PageAdapter;
import com.example.ahmedd.ecommerce.Fragment.ActivityFragment;
import com.example.ahmedd.ecommerce.Fragment.AutoFragment;
import com.example.ahmedd.ecommerce.Fragment.BeautyFragment;
import com.example.ahmedd.ecommerce.Fragment.NewFragment;
import com.example.ahmedd.ecommerce.Fragment.FoodFragmnet;

public class CouponActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private TextView my_title_coupon;
    private Toolbar toolbar;
    private  ImageView home_toolbar;
    private  NavigationView navigationView;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private void findViewByItsID(){

        frameLayout = (FrameLayout) findViewById(R.id.fragment_container_coupon);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar_coupon);
        viewPager = (ViewPager) findViewById(R.id.view_pager_coupon);
        toolbar = (Toolbar) findViewById(R.id.toolbar_coupon);
       // my_title_coupon = (TextView) findViewById(R.id.my_title_coupon);
        home_toolbar = (ImageView) findViewById(R.id.home_toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view_coupon);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navbottom_coupon);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);



        findViewByItsID();

        //setup the ViewPager and TabLayout
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        collapsingToolbarLayout.setTitle("Discount Coupons");

        //setupToolBar
        setSupportActionBar(toolbar);
       // my_title_coupon.setText(R.string.discount_coupons);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_coupon);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //setup Navigations
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("Coupons")){
                    my_title_coupon.setText("Coupons");


                }

                else if (tab.getText().equals("Home")){
                    my_title_coupon.setText("Home");


                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        home_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CouponActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_coupon);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //Listeners for the drawer
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home_coupon) {
            Intent intent = new Intent(CouponActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_gallery_coupon) {

        } else if (id == R.id.nav_slideshow_coupon) {

        } else if (id == R.id.nav_manage_coupon) {

        } else if (id == R.id.nav_share_coupon) {

        } else if (id == R.id.nav_send_coupon) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_coupon);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //listener of Bottom Navigation bar
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        Fragment fragment;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            return true;
        }
    };


    public void setupViewPager(ViewPager viewPager){
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.AddFragmentPage(new NewFragment(), "New");
        adapter.AddFragmentPage(new FoodFragmnet(), "Food");
        adapter.AddFragmentPage(new BeautyFragment(), "Beauty");
        adapter.AddFragmentPage(new ActivityFragment(), "Activity");
        adapter.AddFragmentPage(new AutoFragment(), "Auto");
        viewPager.setAdapter(adapter);
    }


}
