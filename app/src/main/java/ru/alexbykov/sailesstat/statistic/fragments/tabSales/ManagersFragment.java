package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.local.Cache;
import ru.alexbykov.sailesstat.remote.dto.presenter.RemoteManagerPresenter;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManagersFragment extends PageFather implements SwipeRefreshLayout.OnRefreshListener {


    private static final int LAYOUT = R.layout.fragment_managers;



    @BindView(R.id.managersRecyclerView)
    RecyclerView managersRecyclerView;

    @BindView(R.id.managersSwipe)
    SwipeRefreshLayout managersSwipe;

    public static ManagersFragment getInstance(Context context) {

        ManagersFragment fragment = new ManagersFragment();
        fragment.setTitle(context.getString(R.string.tab_managers_fragment));
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        initManagersSwipe();
        initRemoteHelper();

        return view;
    }

    private void initManagersSwipe() {
        managersSwipe.setOnRefreshListener(this);
        managersSwipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.CYAN);
    }

    private void initRemoteHelper() {
        RemoteManagerPresenter helper = getRemoteManagerHelper();
        if (Cache.getManagers().isEmpty()) helper.getManagersFromJSON();

        else helper.initRecyclerView(Cache.getManagers());
    }

    @NonNull
    private RemoteManagerPresenter getRemoteManagerHelper() {
        return new RemoteManagerPresenter(getContext(), managersRecyclerView, managersSwipe);
    }

    @Override
    public void onRefresh() {
        managersSwipe.setRefreshing(true);
        getRemoteManagerHelper().getManagersFromJSON();
    }


}
