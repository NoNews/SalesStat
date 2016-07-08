package ru.alexbykov.sailesstat.statistic.fragments.tabShipments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;
import ru.alexbykov.sailesstat.statistic.fragments.tabSales.PlanFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShipmentsStatFragment extends PageFather {


    private static final int LAYOUT = R.layout.fragment_plan;



    public static ShipmentsStatFragment getInstance (Context context){


        ShipmentsStatFragment fragment = new ShipmentsStatFragment();
        fragment.setTitle(context.getString(R.string.tab_shipments_stat_fragment));

        return fragment;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_shipments_stat, container, false);
        return view;
    }




}
