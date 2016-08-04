package ru.alexbykov.sailesstat.statistic.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;

/**
 * Created by Alexey on 12.07.2016.
 */
public class ManagerListAdapter extends RecyclerView.Adapter<ManagerListAdapter.ManagerHolder> {

    private static final int LAYOUT = R.layout.manager_item;

    private List<ManagerDTO> managers;



    public ManagerListAdapter(List<ManagerDTO> managers) {
        this.managers = managers;
    }


    @Override
    public ManagerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(LAYOUT, parent, false);
        return new ManagerHolder(view);
    }

    @Override
    public void onBindViewHolder(ManagerHolder holder, int position) {

        String name = managers.get(position).getName();
        int plan = managers.get(position).getPlan();
        int quantityOfTenders = managers.get(position).getQuantityOfTenders();
        int quantityOfMeetings = managers.get(position).getQuantityOfMeetings();


        int numberOfRating = ++position;

        holder.managerName.setText(numberOfRating + ". " + name);
        holder.managerPlan.setText("План\n "+ plan + " %");

        holder.managerQuantityOfMeetings.setText("Проведено встреч: "+quantityOfMeetings);
        holder.managerQuantityOfTenders.setText("Участие в тендерах: "+String.valueOf(quantityOfTenders));


    }

    @Override
    public int getItemCount() {
        return managers.size();
    }

    public static class ManagerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.managerName)
        TextView managerName;

        @BindView(R.id.managerPlan)
        TextView managerPlan;

        @BindView(R.id.managerQuantityOfMeetings)
        TextView managerQuantityOfMeetings;


        @BindView(R.id.managerQuantityOfTenders)
        TextView managerQuantityOfTenders;


        @BindView(R.id.managersCardView)
        CardView cardView;

        public ManagerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



    private ArrayList<Integer> getChartColors() {

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.rgb(76, 175, 80)); //it's rgb green MD
        colors.add(Color.GRAY);
        return colors;
    }


}
