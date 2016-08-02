package ru.alexbykov.sailesstat;

import android.os.Bundle;

import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.statistic.adapter.TabFragmentAdapter;
import ru.alexbykov.sailesstat.statistic.fragments.tabTenders.InWorkTendersFragment;
import ru.alexbykov.sailesstat.statistic.fragments.tabTenders.StatTendersFragment;

public class TendersActivity extends FatherActivity {



    private static final int LAYOUT = R.layout.activity_tenders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupThreme();
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);

        setupToolBar(R.string.nav_menu_tenders);
        setupNavigationView(R.id.nav_menu_tenders);
        setupTabs();

    }

    @Override
    protected void setupTabs() {

        TabFragmentAdapter adapter = new TabFragmentAdapter(this, getSupportFragmentManager());
        adapter.initTabs(InWorkTendersFragment.getInstance(this), StatTendersFragment.getInstance(this));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
