package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.statistic.adapter.ManagerListAdapter;
import ru.alexbykov.sailesstat.statistic.dto.ManagerDTO;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManagersFragment extends PageFather {


    private static final int LAYOUT = R.layout.fragment_managers;


    public static ManagersFragment getInstance(Context context){

        ManagersFragment fragment = new ManagersFragment();
//        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_managers_fragment));

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);

        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {
        RecyclerView managersRecyclerView = (RecyclerView) view.findViewById(R.id.managersRecyclerView);
        managersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        managersRecyclerView.setAdapter(new ManagerListAdapter(createManagers()));
    }

    private List<ManagerDTO> createManagers() {


        List<ManagerDTO> managers = new ArrayList<>();

        managers.add(new ManagerDTO("Alex Pavlov", 100));
        managers.add(new ManagerDTO("Ivan Pavlov", 95));
        managers.add(new ManagerDTO("Petr Pavlov", 99));
        managers.add(new ManagerDTO("Stepan Pavlov", 100));
        managers.add(new ManagerDTO("Azik Pavlov", 100));
        managers.add(new ManagerDTO("Azik Myand", 100));
        managers.add(new ManagerDTO("Azik Specca", 50));
        managers.add(new ManagerDTO("Azik Kane", 0));
        managers.add(new ManagerDTO("Azik McDonald", 99));
        managers.add(new ManagerDTO("Azik Jagr", 1));

        Collections.sort(managers, new Comparator<ManagerDTO>() {
            @Override
            public int compare(ManagerDTO lhs, ManagerDTO rhs) {
                return  rhs.getPlan() - lhs.getPlan() ;
            }
        });

        return managers;


    }

}
