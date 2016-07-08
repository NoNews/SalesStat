package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


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
public class PlanFragment extends PageFather {

    private static final int LAYOUT = R.layout.fragment_plan;




    public static PlanFragment getInstance(Context context) {


/*        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);*/


        PlanFragment fragment = new PlanFragment();
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_plan_stat_fragment));

        return fragment;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }








}
