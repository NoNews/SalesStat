package ru.alexbykov.sailesstat.statistic.fragments.tabSales;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
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


public class PlanFragment extends PageFather {

    private static final int LAYOUT = R.layout.fragment_plan;

    @BindView(R.id.costsPieChart)
    PieChart costsPieChart;


    @BindView(R.id.progressPlan)
    RoundCornerProgressBar progressPlan;


    @BindView(R.id.percentPlanTextView)
    TextView percentPlanTextView;


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


        initCostsChartPie(95.63);
        initProgressPlan(61.54);


        return view;

    }


    private void initProgressPlan(double plan) {


        String textPlan = "";


        progressPlan.setMax(100);
        progressPlan.setProgress((float) plan);

        progressPlan.getProgressColor();
        progressPlan.getProgressBackgroundColor();
        progressPlan.getMax();
        progressPlan.getProgress();


        if (plan >= 100) textPlan = "Ура! План выполнен на " + plan;
        else textPlan = String.valueOf(plan);

        percentPlanTextView.setText(textPlan + " %");

    }


    private void initCostsChartPie(double cover) {
        setGeneralSettings();
        setHoleSettings(cover);
        setLegendSettings();
        setDataAndColors(cover);
    }

    private void setDataAndColors(double cover) {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry((float) cover, "Покрыто"));
        entries.add(new PieEntry((float) (100 - cover), "Не покрыто"));
        PieDataSet dataset = new PieDataSet(entries, "");


        //Добавили цвета и форматирование в процентах
        dataset.setColors(getChartColors());
        dataset.setValueFormatter(new PercentFormatter());
        dataset.setValueTextSize(15);

        PieData data = new PieData(dataset);
        costsPieChart.setData(data);
    }

    private void setLegendSettings() {
        Legend legend = costsPieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        legend.setTextSize(14);
    }

    private void setHoleSettings(double cover) {

        String holeMessage;

        if (cover != 100)
            holeMessage = "01.01.2017  \n" +
                    " Расходы не покрыты!";
        else holeMessage = "01.01.2017 \n" +
                " Расходы покрыты ";

        costsPieChart.setDrawHoleEnabled(true);
        costsPieChart.setHoleColor(Color.LTGRAY);
        costsPieChart.setHoleRadius(55);

        costsPieChart.setCenterText(holeMessage);
        costsPieChart.setCenterTextSize(16);
    }

    private void setGeneralSettings() {


        costsPieChart.setUsePercentValues(true);
        costsPieChart.setDescription("");
        costsPieChart.setDrawSliceText(false);
        costsPieChart.setDrawSlicesUnderHole(false);
        costsPieChart.setTouchEnabled(false);
        costsPieChart.animateXY(0, 2500);


        costsPieChart.setClickable(false);
        costsPieChart.setLongClickable(false);
    }

    private ArrayList<Integer> getChartColors() {

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.rgb(76, 175, 80)); //it's rgb green
        colors.add(Color.GRAY);


        return colors;
    }


}



