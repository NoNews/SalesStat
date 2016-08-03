package ru.alexbykov.sailesstat.statistic.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import ru.alexbykov.sailesstat.statistic.fragments.PageFather;

/**
 * Created by Alexey on 09.06.2016.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {


    private Context context;
    private Map<Integer, PageFather> tabs;


    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).getTitle();
    }

    public void initTabs(PageFather page1, PageFather page2) {
        tabs = new HashMap<>();
        tabs.put(0, page1);
        tabs.put(1, page2);
    }
}
