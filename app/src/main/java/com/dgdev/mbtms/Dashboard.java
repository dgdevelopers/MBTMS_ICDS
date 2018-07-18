package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {


    public Dashboard() {
        // Required empty public constructor
    }

    public interface OnDashboardFragmentActivityListener{
        public void checkDashboard();
    }

    OnDashboardFragmentActivityListener dashboardFragmentActivityListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        dashboardFragmentActivityListener.checkDashboard();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        dashboardFragmentActivityListener = (OnDashboardFragmentActivityListener) activity;
    }
}
