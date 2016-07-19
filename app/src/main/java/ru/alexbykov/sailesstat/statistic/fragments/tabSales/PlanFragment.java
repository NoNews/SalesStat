package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.statistic.fragments.PageFather;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends PageFather {

    private static final int LAYOUT = R.layout.fragment_plan;

    @BindView(R.id.costsPieChart)
    PieChart costsPieChart;



    RelativeLayout planRelativeLayout;


    public static PlanFragment getInstance(Context context) {


/*        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);*/


        PlanFragment fragment = new PlanFragment();
        fragment.setTitle(context.getString(R.string.tab_plan_stat_fragment));


        return fragment;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        initCosts();

        addData();

        return view;

    }



    private void initCosts() {


        //Наименования и разрешения
        costsPieChart.setUsePercentValues(true);
        costsPieChart.setCenterText("Пока что расходы не покрыты");
        costsPieChart.setDescription("Покрытие расходов компании 1.01.2017");
        costsPieChart.setDrawSliceText(false);
        costsPieChart.setDrawSlicesUnderHole(false);
        costsPieChart.setTouchEnabled(false);



//        costsPieChart.animateX(1500, Easing.EasingOption.EaseInOutBounce);
//        costsPieChart.animateY(1500, Easing.EasingOption.EaseInOutBounce);

//        costsPieChart.animateXY(1500,);


        costsPieChart.setClickable(false);
        costsPieChart.setLongClickable(false);



        //Папаметры отверстия
        costsPieChart.setDrawHoleEnabled(true);
        costsPieChart.setHoleColor(Color.WHITE);
        costsPieChart.setHoleRadius(55);

//        costsPieChart.setTransparentCircleRadius(1); //?


        //Параметры обозначений
        Legend legend = costsPieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        legend.setTextSize(14);


        //Создание массива с отображаемыми значениями и процентрами заполнения

        List<PieEntry> entries = new ArrayList<>();


        entries.add(new PieEntry(60, "Покрыто"));
        entries.add(new PieEntry(40, "Не покрыто"));



        PieDataSet dataset = new PieDataSet(entries, "");


        //Цвета. Не забыть отрефакторить это дерьмо потом..

        getChartColors();


        //Добавили цвета и форматирование в процентах
        dataset.setColors(getChartColors());
        dataset.setValueFormatter(new PercentFormatter());

        dataset.setValueTextSize(16);

        PieData data = new PieData(dataset);
        costsPieChart.setData(data);


    }

    private ArrayList<Integer> getChartColors() {

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.GRAY);


        return colors;
    }


    private void addData() {


    }


}



