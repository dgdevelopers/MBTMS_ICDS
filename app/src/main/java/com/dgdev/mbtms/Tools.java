package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dgdev.mbtms.local.preferences.data.Centres;
import com.dgdev.mbtms.remote.APIInterface;
import com.dgdev.mbtms.remote.ApiUtils;
import com.dgdev.mbtms.remote.ModelCentreListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tools extends Fragment {
    private APIInterface apiInterface;
    Button button;
    TextView textView;
    List<ModelCentreListItem> CentreList;

    public Tools() {
        // Required empty public constructor
    }

    public interface OnToolsFragmentActivityListener {

        public void checktools();
    }

    OnToolsFragmentActivityListener toolsFragmentActivityListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        toolsFragmentActivityListener.checktools();
        button = (Button) view.findViewById(R.id.btn_download_centres);
        textView = (TextView) view.findViewById(R.id.tv_disp_centre_download) ;
        apiInterface = ApiUtils.getAPIService();
        final String uid = MainActivity.preferencesConfig.ReadLoggedUser();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    apiInterface.getCentreList(uid).enqueue(new Callback<List<ModelCentreListItem>>() {
                        @Override
                        public void onResponse(Call<List<ModelCentreListItem>> call, Response<List<ModelCentreListItem>> response) {
                            CentreList = response.body();
                            new centreAsyncOperation().execute();
                        }
                        @Override
                        public void onFailure(Call<List<ModelCentreListItem>> call, Throwable t) {
                            Toast.makeText(getActivity(), "Data fetching failed!", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        toolsFragmentActivityListener = (OnToolsFragmentActivityListener) activity;
    }


    //this inner class in for asyncronus operation of centre info download

    private class centreAsyncOperation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            MainActivity.db.centreDAO().delete_all_centres();
            for (int i = 0; i < CentreList.size(); i++) {
                Centres centre = new Centres();
                centre.setCentre_id(CentreList.get(i).getCentreId());
                centre.setCentre_name(CentreList.get(i).getCentreName());
                MainActivity.db.centreDAO().insert_centre(centre);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String SuccessString = "Successfully downloaded " + CentreList.size()+ " centres...";
            Toast.makeText(getActivity(), SuccessString, Toast.LENGTH_LONG).show();
            textView.setText( SuccessString );
        }
    }
}

