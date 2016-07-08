package ru.alexbykov.sailesstat.statistic.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

public class PageFather extends Fragment {


    private String title;
    protected Context context;
    protected View view;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(Context context) {

        this.context=context;

    }

    public String getTitle() {
        return title;
    }
}
