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
