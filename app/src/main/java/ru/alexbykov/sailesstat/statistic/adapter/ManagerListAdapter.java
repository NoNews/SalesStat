package ru.alexbykov.sailesstat.statistic.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.alexbykov.sailesstat.R;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;

/**
 * Created by Alexey on 12.07.2016.
 */
public class ManagerListAdapter extends RecyclerView.Adapter<ManagerListAdapter.ManagerHolder> {


    private List<ManagerDTO> managers;


    public ManagerListAdapter(List<ManagerDTO> managers) {
        this.managers = managers;
    }


    @Override
    public ManagerHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manager_item, parent, false);


        return new ManagerHolder(view);
    }

    @Override
    public void onBindViewHolder(ManagerHolder holder, int position) {




        int numberOfRating = position;
        ++numberOfRating;


        holder.managerName.setText(numberOfRating + ". " + managers.get(position).getName());
        holder.managerPlan.setText(managers.get(position).getPlan() + " %");

    }

    @Override
    public int getItemCount() {


//        Log.e("LIST ADAPTER: I HAVE COLLECTION WITH SIZE", String.valueOf(+managers.size()));
        return managers.size();
    }

    public static class ManagerHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.managerName)
        TextView managerName;

        @BindView(R.id.managerPlan)
        TextView managerPlan;

        @BindView(R.id.managersCardView)
        CardView cardView;



        public ManagerHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }


}
