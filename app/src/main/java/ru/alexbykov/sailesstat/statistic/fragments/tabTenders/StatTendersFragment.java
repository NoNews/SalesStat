package ru.alexbykov.sailesstat.statistic.fragments.tabTenders;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;

/**
 * A simple {@link Fragment} subclass.
 */


public class StatTendersFragment extends PageFather {


    private static final int LAYOUT = R.layout.fragment_stat_tenders;




    public static StatTendersFragment getInstance(Context context) {


        StatTendersFragment fragment = new StatTendersFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_tenders_stat_fragment));

        return fragment;


    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       view =  inflater.inflate(LAYOUT, container, false);
        return view;



    }

}
