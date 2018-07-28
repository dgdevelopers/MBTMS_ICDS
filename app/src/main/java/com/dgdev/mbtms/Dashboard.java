package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {

    ImageView ivEnterVisit, ivUpload, ivDownload, ivLogout;

    public Dashboard() {
        // Required empty public constructor
    }



    public interface OnDashboardFragmentActivityListener {
        public void checkDashboard();
        public void navigate2Fragment(ImageView imageView);
    }

    OnDashboardFragmentActivityListener dashboardFragmentActivityListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        dashboardFragmentActivityListener.checkDashboard();
        ivEnterVisit = (ImageView) view.findViewById(R.id.img_visit);
        ivUpload = (ImageView) view.findViewById(R.id.img_upload);
        ivDownload = (ImageView) view.findViewById(R.id.img_download);
        ivLogout = (ImageView) view.findViewById(R.id.img_logout);

        ivEnterVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardFragmentActivityListener.navigate2Fragment(ivEnterVisit);
            }
        });
        ivUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardFragmentActivityListener.navigate2Fragment(ivUpload);
            }
        });
        ivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardFragmentActivityListener.navigate2Fragment(ivDownload);
            }
        });
        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardFragmentActivityListener.navigate2Fragment(ivLogout);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        dashboardFragmentActivityListener = (OnDashboardFragmentActivityListener) activity;
    }
}
