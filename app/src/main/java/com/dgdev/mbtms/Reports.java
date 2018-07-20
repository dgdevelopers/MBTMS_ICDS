package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dgdev.mbtms.local.preferences.data.Visitdata;
import com.dgdev.mbtms.remote.APIInterface;
import com.dgdev.mbtms.remote.ApiUtils;
import com.dgdev.mbtms.remote.ModelUploadResponse;

import java.io.File;
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
public class Reports extends Fragment {
    private APIInterface apiInterface;
    EditText editTextShowData;
    Button btn_get_data, btn_upload_data, btn_show_image;
    ImageView imageView;
    List<Visitdata> ListofData;

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

        btn_get_data = (Button) view.findViewById(R.id.btn_get_data);
        btn_upload_data = (Button) view.findViewById(R.id.btn_upload_data);
        btn_show_image = (Button) view.findViewById(R.id.btn_show_image);
        editTextShowData = (EditText) view.findViewById(R.id.editTextShowdata);
        imageView = (ImageView) view.findViewById(R.id.imageView3);

        btn_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new getDataAsync().execute();
            }
        });
        apiInterface = ApiUtils.getAPIService();
        btn_upload_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < ListofData.size(); i++) {

                    /*Uri uri = Uri.fromFile(new File(ListofData.get(0).getVisit_pic()));
                    File file = new File(uri.getPath());
                    RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
                    MultipartBody.Part visit_pic = MultipartBody.Part.createFormData("visit_pic", file.getName(), requestBody);
                    String userid = ListofData.get(i).getUserid();
                    String centreid = ListofData.get(i).getCentreid();
                    String visit_date = ListofData.get(i).getVisit_date();
                    apiInterface.uploadVisit(userid, centreid, visit_date, visit_pic).enqueue(new Callback<ModelUploadResponse>() {
                        @Override
                        public void onResponse(Call<ModelUploadResponse> call, Response<ModelUploadResponse> response) {
                            Toast.makeText(getContext(), response.body().getStatus(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<ModelUploadResponse> call, Throwable t) {
                            Toast.makeText(getContext(), "failed", Toast.LENGTH_LONG).show();
                        }
                    });*/
                    String userid = ListofData.get(i).getUserid();
                    String centreid = ListofData.get(i).getCentreid();
                    String visit_date = ListofData.get(i).getVisit_date();
                    String visit_lat = ListofData.get(i).getVisit_lat();
                    String visit_long = ListofData.get(i).getVisit_long();
                    String visit_pic = "";
                    String own_building = ListofData.get(i).getOwn_building();
                    String centre_open = ListofData.get(i).getCentre_open();
                    int benef_total = ListofData.get(i).getBenef_total();
                    int benef_serve = ListofData.get(i).getBenef_serve();
                    int chld_7m_6y_tot = ListofData.get(i).getChld_7m_6y_tot();
                    int chld_7m_6y_Mor_Snacks = ListofData.get(i).getChld_7m_6y_Mor_Snacks();
                    int chld_3y_6y_tot = ListofData.get(i).getChld_3y_6y_tot();
                    int chld_3y_6y_PSE = ListofData.get(i).getChld_3y_6y_PSE();
                    int chld_blw_5y_tot = ListofData.get(i).getChld_blw_5y_tot();
                    int chld_blw_5y_weighted = ListofData.get(i).getChld_blw_5y_weighted();
                    int chld_blw_5y_mal_mod = ListofData.get(i).getChld_blw_5y_mal_mod();
                    int chld_blw_5y_mal_severe = ListofData.get(i).getChld_blw_5y_mal_severe();
                    int mother_meet = ListofData.get(i).getMother_meet();
                    int register_found = ListofData.get(i).getRegister_found();
                    String ecce_followed = ListofData.get(i).getEcce_followed ();
                    apiInterface.uploadVisitData(userid, centreid, visit_date, visit_lat, visit_long, visit_pic, own_building, centre_open, benef_total, benef_serve, chld_7m_6y_tot, chld_7m_6y_Mor_Snacks, chld_3y_6y_tot, chld_3y_6y_PSE, chld_blw_5y_tot, chld_blw_5y_weighted, chld_blw_5y_mal_mod, chld_blw_5y_mal_severe, mother_meet, register_found, ecce_followed).enqueue(new Callback<ModelUploadResponse>() {
                        @Override
                        public void onResponse(Call<ModelUploadResponse> call, Response<ModelUploadResponse> response) {
                            Toast.makeText(getContext(), response.body().getStatus(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<ModelUploadResponse> call, Throwable t) {

                        }
                    });

                }
            }
        });
        btn_show_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.fromFile(new File(ListofData.get(0).getVisit_pic()));
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        reportsFragmentActvityListener = (OnReportsFragmentActvityListener) activity;
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
            String txt = null;
            for (int i = 0; i < ListofData.size(); i++) {
                txt = txt + ListofData.get(i).getVisit_lat() + "\n" + ListofData.get(i).getVisit_long() + "\n" + ListofData.get(i).getVisit_pic();
            }
            editTextShowData.setText(txt);
        }
    }

}
