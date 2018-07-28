package com.dgdev.mbtms;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
import com.dgdev.mbtms.local.preferences.data.Visitdata;
import com.dgdev.mbtms.remote.APIInterface;
import com.dgdev.mbtms.remote.ApiUtils;
import com.dgdev.mbtms.remote.ModelCentreListItem;
import com.dgdev.mbtms.remote.ModelUploadResponse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tools extends Fragment {
    private APIInterface apiInterface;
    Button button, btn_upload_data, btn_prepare_data;
    TextView textView;
    List<ModelCentreListItem> CentreList;
    List<Visitdata> ListofData;

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
        btn_upload_data = (Button) view.findViewById(R.id.btn_upload_data);
        btn_prepare_data = (Button) view.findViewById(R.id.btn_prepare_data);
        textView = (TextView) view.findViewById(R.id.tv_disp_centre_download);
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

        btn_upload_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < ListofData.size(); i++) {

                    Uri uri = Uri.fromFile(new File(ListofData.get(i).getVisit_pic()));

                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), convertImageToByte(uri));
                    MultipartBody.Part visit_pic = MultipartBody.Part.createFormData("visit_pic", "image.jpg", requestFile);
                    RequestBody userid = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getUserid());
                    RequestBody centreid = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getCentreid());
                    RequestBody visit_date = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getVisit_date());
                    RequestBody visit_lat = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getVisit_lat());
                    RequestBody visit_long = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getVisit_long());
                    RequestBody own_building = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getOwn_building());
                    RequestBody centre_open = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getCentre_open());
                    RequestBody benef_total = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getBenef_total() + "");
                    RequestBody benef_serve = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getBenef_serve() + "");
                    RequestBody chld_7m_6y_tot = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_7m_6y_tot() + "");
                    RequestBody chld_7m_6y_Mor_Snacks = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_7m_6y_Mor_Snacks() + "");
                    RequestBody chld_3y_6y_tot = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_3y_6y_tot() + "");
                    RequestBody chld_3y_6y_PSE = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_3y_6y_PSE() + "");
                    RequestBody chld_blw_5y_tot = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_blw_5y_tot() + "");
                    RequestBody chld_blw_5y_weighted = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_blw_5y_weighted() + "");
                    RequestBody chld_blw_5y_mal_mod = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_blw_5y_mal_mod() + "");
                    RequestBody chld_blw_5y_mal_severe = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getChld_blw_5y_mal_severe() + "");
                    RequestBody mother_meet = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getMother_meet() + "");
                    RequestBody register_found = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getRegister_found() + "");
                    RequestBody ecce_followed = RequestBody.create(MediaType.parse("text/plain"), ListofData.get(i).getEcce_followed());

                    apiInterface.uploadVisitData(userid, centreid, visit_date, visit_lat, visit_long, visit_pic, own_building, centre_open, benef_total, benef_serve, chld_7m_6y_tot, chld_7m_6y_Mor_Snacks, chld_3y_6y_tot, chld_3y_6y_PSE, chld_blw_5y_tot, chld_blw_5y_weighted, chld_blw_5y_mal_mod, chld_blw_5y_mal_severe, mother_meet, register_found, ecce_followed).enqueue(new Callback<ModelUploadResponse>() {
                        @Override
                        public void onResponse(Call<ModelUploadResponse> call, Response<ModelUploadResponse> response) {
                            Toast.makeText(getContext(), response.body().getStatus(), Toast.LENGTH_LONG).show();
                            btn_prepare_data.setVisibility(View.VISIBLE);
                            btn_upload_data.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<ModelUploadResponse> call, Throwable t) {
                            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
        btn_prepare_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new getDataAsync().execute();
            }
        });
        return view;
    }


    public byte[] convertImageToByte(Uri uri) {
        byte[] data = null;
        try {
            ContentResolver cr = getContext().getContentResolver();
            InputStream inputStream = cr.openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
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
            String SuccessString = "Successfully downloaded " + CentreList.size() + " centres...";
            Toast.makeText(getActivity(), SuccessString, Toast.LENGTH_LONG).show();
            textView.setText(SuccessString);
        }
    }


    private class getDataAsync extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            ListofData = MainActivity.db.visitDAO().select_all_visits();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            btn_prepare_data.setVisibility(View.GONE);
            btn_upload_data.setVisibility(View.VISIBLE);
        }
    }
}

