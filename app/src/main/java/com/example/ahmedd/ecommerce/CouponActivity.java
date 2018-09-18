package com.example.ahmedd.ecommerce;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ahmedd.ecommerce.Adapters.PageAdapter;
import com.example.ahmedd.ecommerce.Fragment.CouponFragment;
import com.example.ahmedd.ecommerce.Fragment.NotificationsFragmnet;

public class CouponActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private TextView my_title_coupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_coupon);
        setSupportActionBar(toolbar);

         frameLayout = (FrameLayout) findViewById(R.id.fragment_container_coupon);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

       /* tab_home = (TabItem) findViewById(R.id.tab_home);
        tab_coupons = (TabItem) findViewById(R.id.tab_coupons);
        tab_noti = (TabItem) findViewById(R.id.tab_notifiactions);*/
        viewPager = (ViewPager) findViewById(R.id.view_pager_coupon);
        tabLayout.setupWithViewPager(viewPager);

        setupViewPager(viewPager);

        //setupToolBar
        toolbar = (Toolbar) findViewById(R.id.toolbar_coupon);
        my_title_coupon = (TextView) findViewById(R.id.my_title_coupon);
        setSupportActionBar(toolbar);
        my_title_coupon.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_coupon);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_coupon);
        navigationView.setNavigationItemSelectedListener(this);

        //setupBottomNav.
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navbottom_coupon);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.home);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.coupon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_coupon) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera_coupon) {
            // Handle the camera action
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
        adapter.AddFragmentPage(new CouponFragment(), "Home");
        adapter.AddFragmentPage(new CouponFragment(), "Coupons");
        adapter.AddFragmentPage(new NotificationsFragmnet(), "Notifications");
        viewPager.setAdapter(adapter);
    }
}
