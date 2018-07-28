package com.dgdev.mbtms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.dgdev.mbtms.local.preferences.data.Centres;

import java.util.ArrayList;
import java.util.List;

class centreAdapter extends RecyclerView.Adapter<centreAdapter.ViewHolder> implements Filterable {
    public List<Centres> orginalCentlist;
    public List<Centres> filteredCentlist;
    public itemFilter itemFilter;

    public centreAdapter(List<Centres> centlist) {
        orginalCentlist = centlist;
        filteredCentlist = centlist;
    }

    @NonNull
    @Override
    public centreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.centre_list_row_layout, parent, false);
        itemFilter = new itemFilter();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull centreAdapter.ViewHolder holder, int position) {
        holder.tv_c_name.setText(filteredCentlist.get(position).getCentre_name());
        holder.tv_c_code.setText(filteredCentlist.get(position).getCentre_id());
        holder.tv_c_last.setText(filteredCentlist.get(position).getVisited_on());
        holder.tv_c_stat.setText(filteredCentlist.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return filteredCentlist.size();
    }

    @Override
    public Filter getFilter() {
        return itemFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv_c_name, tv_c_code, tv_c_last, tv_c_stat;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_c_name = (TextView) itemView.findViewById(R.id.row_centre_name);
            tv_c_code = (TextView) itemView.findViewById(R.id.row_centre_code);
            tv_c_last = (TextView) itemView.findViewById(R.id.row_last_visited);
            tv_c_stat = (TextView) itemView.findViewById(R.id.row_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            MainActivity activity = (MainActivity) view.getContext();
            Visit_form vis = new Visit_form();
            Bundle bundle = new Bundle();

            bundle.putString("uid", MainActivity.preferencesConfig.ReadLoggedUser());
            bundle.putString("cent_name", tv_c_name.getText().toString());
            bundle.putString("cent_code", tv_c_code.getText().toString());
            vis.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.flContent, vis).addToBackStack(null).commit();

        }
    }


    public class itemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String Query = charSequence.toString().toLowerCase();
            List<Centres> tempList = orginalCentlist;
            List<Centres> resultList = new ArrayList<>(tempList.size());
            FilterResults filterResults = new FilterResults();
            for (Centres c : tempList) {
                if (c.getCentre_id().toLowerCase().contains(Query)) {
                    resultList.add(c);
                }
            }
            filterResults.values = resultList;
            filterResults.count = resultList.size();
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filteredCentlist = (List<Centres>) filterResults.values;
            notifyDataSetChanged();
        }
    }

}
