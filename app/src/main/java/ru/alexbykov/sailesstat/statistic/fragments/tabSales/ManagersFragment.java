package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.remote.dto.ApiObject;
import ru.alexbykov.sailesstat.remote.dto.ServiceGenerator;
import ru.alexbykov.sailesstat.statistic.adapter.ManagerListAdapter;
import ru.alexbykov.sailesstat.remote.dto.ManagerDTO;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManagersFragment extends PageFather {


    private static final int LAYOUT = R.layout.fragment_managers;


    public static ManagersFragment getInstance(Context context) {

        ManagersFragment fragment = new ManagersFragment();
//        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_managers_fragment));


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);


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
                    }

                    @Override
                    public void onNext(List<ManagerDTO> managers) {

                        initRecyclerView(managers);
                    }
                });
        managers.cache();


    }

    private void initRecyclerView(List<ManagerDTO> managers) {

        RecyclerView managersRecyclerView = (RecyclerView) view.findViewById(R.id.managersRecyclerView);
        managersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        managersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        sortManagers(managers);
        managersRecyclerView.setAdapter(new ManagerListAdapter(managers));
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
