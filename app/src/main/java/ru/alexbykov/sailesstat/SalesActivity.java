package ru.alexbykov.sailesstat;

import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.statistic.adapter.TabFragmentAdapter;
import ru.alexbykov.sailesstat.statistic.fragments.tabSales.ManagersFragment;
import ru.alexbykov.sailesstat.statistic.fragments.tabSales.PlanFragment;

public class SalesActivity extends FatherActivity {


    private static final int LAYOUT = R.layout.activity_sales;

    String TAG = "SalesActivityLOG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.e(TAG, "onCreate()");




        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        setupToolBar(R.string.nav_menu_sales);
        setupNavigationView(R.id.nav_menu_sales);
        setupTabs();


    }

    void setupTabs() {

        TabFragmentAdapter adapter = new TabFragmentAdapter(this, getSupportFragmentManager());
        adapter.initTabs(PlanFragment.getInstance(this), ManagersFragment.getInstance(this));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }


}
