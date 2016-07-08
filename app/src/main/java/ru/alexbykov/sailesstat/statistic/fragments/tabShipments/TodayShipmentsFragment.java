package ru.alexbykov.sailesstat.statistic.fragments.tabShipments;


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
public class TodayShipmentsFragment extends PageFather {


    private static final int LAYOUT = R.layout.fragment_today_shipments;

    public static  TodayShipmentsFragment getInstance(Context context) {



        TodayShipmentsFragment fragment = new TodayShipmentsFragment();
        fragment.setTitle(context.getString(R.string.tab_shipments_today_fragment));

        return fragment;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(LAYOUT, container, false);
    }

}
