package ru.alexbykov.sailesstat;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;


public abstract class FatherActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;


    protected void setupNavigationView(int idMenuItem) {

        initTogle();

        navigationView.setCheckedItem(idMenuItem); //set check insert item



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                drawerLayout.closeDrawers();
                switch (item.getItemId()) {

                    case R.id.nav_menu_sales:
                        startSalesActivity();
                        break;

                    case R.id.nav_menu_tenders:
                        startTendersActivity();
                        break;

                    case R.id.nav_menu_shipments:
                        startShipmentsActivity();
                        break;


                }
                return false;
            }
        });


    }

    private void initTogle() {

        ActionBarDrawerToggle togle =
                new ActionBarDrawerToggle(
                        this,
                        drawerLayout,
                        toolbar,
                        R.string.view_navigation_open,
                        R.string.view_navigation_close);
        togle.syncState();

    }


    protected void setupToolBar(int idTitle) {
        toolbar.setTitle(idTitle);
    }


    private void startSalesActivity() {



        Intent salesActivity = new Intent(this, SalesActivity.class);
        startActivity(salesActivity);


    }

    private void startTendersActivity() {

        Intent tendersActivity = new Intent(this, TendersActivity.class);
        startActivity(tendersActivity);


    }

    private void startShipmentsActivity() {

        Intent shipmentsActivity = new Intent(this, ShipmentsActivity.class);
        startActivity(shipmentsActivity);

    }


    abstract void setupTabs();


}
