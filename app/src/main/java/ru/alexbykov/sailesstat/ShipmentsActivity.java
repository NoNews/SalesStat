package ru.alexbykov.sailesstat;

import android.os.Bundle;

import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.statistic.adapter.TabFragmentAdapter;
import ru.alexbykov.sailesstat.statistic.fragments.tabShipments.ShipmentsStatFragment;
import ru.alexbykov.sailesstat.statistic.fragments.tabShipments.TodayShipmentsFragment;

public class ShipmentsActivity extends FatherActivity {


    private static final int LAYOUT = R.layout.activity_shipments;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setupThreme();
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        setupToolBar(R.string.nav_menu_shipments);
        setupNavigationView(R.id.nav_menu_shipments);

        setupTabs();
    }


    @Override
    protected void setupTabs() {

        TabFragmentAdapter adapter = new TabFragmentAdapter(this, getSupportFragmentManager());
        adapter.initTabs(TodayShipmentsFragment.getInstance(this), ShipmentsStatFragment.getInstance(this));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
