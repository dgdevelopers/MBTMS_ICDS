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
public class Reports extends Fragment {


    public Reports() {
        // Required empty public constructor
    }

    public interface OnReportsFragmentActvityListener {
        public void checkRepors();
    }

    OnReportsFragmentActvityListener reportsFragmentActvityListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reports, container, false);

        reportsFragmentActvityListener.checkRepors();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        reportsFragmentActvityListener = (OnReportsFragmentActvityListener) activity;
    }
}
