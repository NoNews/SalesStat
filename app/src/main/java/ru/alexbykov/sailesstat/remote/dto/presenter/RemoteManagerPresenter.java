package ru.alexbykov.sailesstat.remote.dto.presenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.local.RealmHelper;
import ru.alexbykov.sailesstat.remote.dto.ApiObject;
import ru.alexbykov.sailesstat.local.Cache;
import ru.alexbykov.sailesstat.remote.dto.ServiceGenerator;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;
import ru.alexbykov.sailesstat.statistic.adapter.ManagerListAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey on 21.07.2016.
 */
public class RemoteManagerPresenter {

    private Context context;
    private SwipeRefreshLayout managersSwipe;
    private RecyclerView managersRecyclerView;


    public RemoteManagerPresenter(Context context, RecyclerView managersRecyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.context = context;
        this.managersSwipe = swipeRefreshLayout;
        this.managersRecyclerView = managersRecyclerView;

    }


    public void getManagersFromJSON() {


        if (Cache.getManagers().isEmpty()) {
            List<ManagerDTO> managersFromBd = new RealmHelper(context).getAllFromRealm(ManagerDTO.class);
            Cache.setManagerDTO(managersFromBd);
            Log.e("data cached from db", String.valueOf(managersFromBd.size()));
        }


        ApiObject service = ServiceGenerator.createService(ApiObject.class);
        Observable<List<ManagerDTO>> observManagers = service.getManagers();
        observManagers
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
                        Toast.makeText(context, R.string.toast_connection_false, Toast.LENGTH_SHORT).show();
                        initRecyclerView(Cache.getManagers());
                        managersSwipe.setRefreshing(false);
                    }

                    @Override
                    public void onNext(List<ManagerDTO> managers) {
                        Log.e("OnNext", "Connect is OK");
                        sortManagers(managers);
                        Cache.setManagerDTO(managers);
                        initRecyclerView(managers);
                        managersSwipe.setRefreshing(false);

                        //Copy to db
                        RealmHelper helper = new RealmHelper(context);
                        helper.copyToRealmOrUpdate(managers);
                        Log.e("RealmCopy", "it's ok");
                    }
                });


    }

    public void initRecyclerView(List<ManagerDTO> managers) {
        managersRecyclerView.setLayoutManager(new LinearLayoutManager(context));
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
