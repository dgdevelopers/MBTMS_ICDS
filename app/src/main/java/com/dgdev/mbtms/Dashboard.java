package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dgdev.mbtms.remote.APIInterface;
import com.dgdev.mbtms.remote.ApiUtils;
import com.dgdev.mbtms.remote.ModelEfficiencyResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {
    private APIInterface apiInterface;
    ImageView ivEnterVisit, ivUpload, ivDownload, ivLogout;
    TextView tvCentVis, tvCentOpen;

    public Dashboard() {
        // Required empty public constructor
    }


    public interface OnDashboardFragmentActivityListener {
        public void checkDashboard();
        public void navigate2Fragment(ImageView imageView);
        public void refreshEfficiencyReport(ModelEfficiencyResponse mer);
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
        tvCentVis = (TextView) view.findViewById(R.id.tv_dash_centre_visited);
        tvCentOpen = (TextView) view.findViewById(R.id.tv_dash_centre_open);

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

    @Override
    public void onStart() {
        super.onStart();
        getStat();
    }

    @Override
    public void onResume() {
        super.onResume();
        getStat();
    }

    //this function is responsible for getting server response of efficiency of last 30 days.
    private void getStat(){
        String id = MainActivity.preferencesConfig.ReadLoggedUser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDate = new Date();
        Date fromDate = new Date(toDate.getTime() - 1000L * 60L * 60L * 24L * 30L);
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        boolean dataPresent = MainActivity.preferencesConfig.checkDatapresent();
        if (dataPresent == false && isConnected == true) {
            apiInterface = ApiUtils.getAPIService();
            apiInterface.getEffciency(id, dateFormat.format(fromDate), dateFormat.format(toDate)).enqueue(new Callback<ModelEfficiencyResponse>() {
                @Override
                public void onResponse(Call<ModelEfficiencyResponse> call, Response<ModelEfficiencyResponse> response) {
                    ModelEfficiencyResponse mer_remote = response.body();
                    dashboardFragmentActivityListener.refreshEfficiencyReport(mer_remote);
                }
                @Override
                public void onFailure(Call<ModelEfficiencyResponse> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
        tvCentVis.setText(MainActivity.preferencesConfig.getEffiData().gettOTVISCENT());
        tvCentOpen.setText(MainActivity.preferencesConfig.getEffiData().gettOTOPENCENT());
    }
}
