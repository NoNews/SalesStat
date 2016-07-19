package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.remote.dto.ApiObject;
import ru.alexbykov.sailesstat.remote.dto.ServiceGenerator;
import ru.alexbykov.sailesstat.statistic.adapter.ManagerListAdapter;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


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

        managersSwipe.setOnRefreshListener(this);
        managersSwipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.CYAN);

        //from JSON
        getRemoteManagers();

        return view;
    }


    private void getRemoteManagers() {


        ApiObject client = ServiceGenerator.createService(ApiObject.class);

        Observable<List<ManagerDTO>> managers = client.getManagers();
        managers
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ManagerDTO>>() {
                    @Override
                    public void onCompleted() {
                        //do nothing
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("OnError", e.getMessage());

                        managersSwipe.setRefreshing(false);

                        Toast.makeText(getContext(),R.string.toast_connection_false, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNext(List<ManagerDTO> managers) {

                        Log.e("OnNext", "Connect is OK");

                        sortManagers(managers);

                        ManagerListAdapter adapter = new ManagerListAdapter(managers);
                        initRecyclerView(adapter);
                        managersSwipe.setRefreshing(false);

                    }
                });


    }

    private void initRecyclerView(ManagerListAdapter adapter) {

        managersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        managersRecyclerView.setAdapter(adapter);

    }


    @Override
    public void onRefresh() {

        managersSwipe.setRefreshing(true);
        getRemoteManagers();


    }



    private List<ManagerDTO> sortManagers(List<ManagerDTO> managers) {
        Collections.sort(managers, new Comparator<ManagerDTO>() {
            @Override
            public int compare(ManagerDTO lhs, ManagerDTO rhs) {
                return rhs.getPlan() - lhs.getPlan();
            }
        });

        return managers;
    }


}
