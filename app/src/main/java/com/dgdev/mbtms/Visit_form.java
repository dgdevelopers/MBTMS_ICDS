package com.dgdev.mbtms;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.dgdev.mbtms.local.preferences.RealPathUtils;
import com.dgdev.mbtms.local.preferences.data.Visitdata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class Visit_form extends Fragment implements TextWatcher, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    FusedLocationProviderClient mFusedLocationClient;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    private static final int SELECT_PICTURE = 7777;
    public Boolean
            VALID_FORM_CTRL_0 = Boolean.FALSE,
            VALID_FORM_CTRL_1 = Boolean.FALSE,
            VALID_FORM_CTRL_2 = Boolean.FALSE,
            VALID_FORM_CTRL_3 = Boolean.FALSE,
            VALID_FORM_CTRL_4 = Boolean.FALSE,
            VALID_FORM_CTRL_5 = Boolean.FALSE,
            VALID_FORM_CTRL_6 = Boolean.FALSE,
            VALID_FORM_CTRL_7 = Boolean.FALSE,
            VALID_FORM_CTRL_8 = Boolean.FALSE;
    String code, name, uid, vispic;
    TextView tvCentName, tvCentCode, btnTakePhoto, btnSaveVisit;
    Switch cSwitch;
    TableRow tr01, tr02, tr03, tr04, tr05, tr06, tr07, tr08, tr09, tr10, tr11, tr12, tr13, tr14;
    Switch vis_cent_open_switch, ans_cent_open_switch, ans_cent_ecce_switch;

    Uri selectedImageUri;

    EditText ans_cent_tot_ben, ans_cent_ben_serv, ans_cent_chld_6m_6y,
            ans_cent_mor_snks, ans_cent_chld_3y_6Y, ans_cent_chld_pse,
            ans_cent_chld_blw_5y, ans_cent_chld_weighed, ans_cent_chld_mal_mod,
            ans_cent_chld_mal_severe, ans_cent_mom_meet, ans_cent_reg;

    Integer tot_snp, tot_snp_serv, tot_6_6, mor_snks, tot_3_6, pse,
            tot_blw_5, weighed, mal_mod, mal_seve, mom_meet, register;

    String latitude, longitude;

    LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for (Location location : locationResult.getLocations()) {
                latitude = location.getLatitude() + "";
                longitude = location.getLongitude() + "";
            }
        }
    };

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        requestLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public interface OnVisitDataFragmentActivityListener {
        void navigate2ListFragment();
    }

    OnVisitDataFragmentActivityListener onVisitDataFragmentActivityListener;

    public Visit_form() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleApiClient != null && mFusedLocationClient != null) {
            requestLocationUpdates();
        } else {
            buildGoogleApiClient();
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }



    public void requestLocationUpdates() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(0); // two minute interval
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mFusedLocationClient != null) {
            mFusedLocationClient.removeLocationUpdates(mLocationCallback);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visit_form, container, false);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        code = getArguments().get("cent_code").toString();
        name = getArguments().get("cent_name").toString();
        uid = getArguments().get("uid").toString();
        tvCentName = (TextView) view.findViewById(R.id.vis_tv_centre_name);
        tvCentCode = (TextView) view.findViewById(R.id.vis_tv_centre_code);
        cSwitch = (Switch) view.findViewById(R.id.vis_cent_open_switch);
        tr01 = (TableRow) view.findViewById(R.id.row_open_01);
        tr02 = (TableRow) view.findViewById(R.id.row_open_02);
        tr03 = (TableRow) view.findViewById(R.id.row_open_03);
        tr04 = (TableRow) view.findViewById(R.id.row_open_04);
        tr05 = (TableRow) view.findViewById(R.id.row_open_05);
        tr06 = (TableRow) view.findViewById(R.id.row_open_06);
        tr07 = (TableRow) view.findViewById(R.id.row_open_07);
        tr08 = (TableRow) view.findViewById(R.id.row_open_08);
        tr09 = (TableRow) view.findViewById(R.id.row_open_09);
        tr10 = (TableRow) view.findViewById(R.id.row_open_10);
        tr11 = (TableRow) view.findViewById(R.id.row_open_11);
        tr12 = (TableRow) view.findViewById(R.id.row_open_12);
        tr13 = (TableRow) view.findViewById(R.id.row_open_13);
        tr14 = (TableRow) view.findViewById(R.id.row_open_14);

        btnTakePhoto = (TextView) view.findViewById(R.id.btn_cent_take_photo);
        btnSaveVisit = (TextView) view.findViewById(R.id.btn_cent_visit_save);

        vis_cent_open_switch = (Switch) view.findViewById(R.id.vis_cent_open_switch);
        ans_cent_open_switch = (Switch) view.findViewById(R.id.ans_cent_open_switch);
        ans_cent_ecce_switch = (Switch) view.findViewById(R.id.ans_cent_ecce_switch);


        vis_cent_open_switch.setChecked(false);
        ans_cent_open_switch.setChecked(false);
        ans_cent_ecce_switch.setChecked(false);


        tvCentName.setText(name);
        tvCentCode.setText(code);
        cSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cSwitch.isChecked()) {
                    cSwitch.setText(cSwitch.getTextOn().toString());
                    tr01.setVisibility(View.VISIBLE);
                    tr02.setVisibility(View.VISIBLE);
                    tr03.setVisibility(View.VISIBLE);
                    tr04.setVisibility(View.VISIBLE);
                    tr05.setVisibility(View.VISIBLE);
                    tr06.setVisibility(View.VISIBLE);
                    tr07.setVisibility(View.VISIBLE);
                    tr08.setVisibility(View.VISIBLE);
                    tr09.setVisibility(View.VISIBLE);
                    tr10.setVisibility(View.VISIBLE);
                    tr11.setVisibility(View.VISIBLE);
                    tr12.setVisibility(View.VISIBLE);
                    tr13.setVisibility(View.VISIBLE);
                    tr14.setVisibility(View.VISIBLE);
                } else {
                    cSwitch.setText(cSwitch.getTextOff().toString());
                    tr01.setVisibility(View.GONE);
                    tr02.setVisibility(View.GONE);
                    tr03.setVisibility(View.GONE);
                    tr04.setVisibility(View.GONE);
                    tr05.setVisibility(View.GONE);
                    tr06.setVisibility(View.GONE);
                    tr07.setVisibility(View.GONE);
                    tr08.setVisibility(View.GONE);
                    tr09.setVisibility(View.GONE);
                    tr10.setVisibility(View.GONE);
                    tr11.setVisibility(View.GONE);
                    tr12.setVisibility(View.GONE);
                    tr13.setVisibility(View.GONE);
                    tr14.setVisibility(View.GONE);
                }
            }
        });

        ans_cent_tot_ben = (EditText) view.findViewById(R.id.ans_cent_tot_ben);
        ans_cent_ben_serv = (EditText) view.findViewById(R.id.ans_cent_ben_serv);
        ans_cent_chld_6m_6y = (EditText) view.findViewById(R.id.ans_cent_chld_6m_6y);
        ans_cent_mor_snks = (EditText) view.findViewById(R.id.ans_cent_mor_snks);
        ans_cent_chld_3y_6Y = (EditText) view.findViewById(R.id.ans_cent_chld_3y_6Y);
        ans_cent_chld_pse = (EditText) view.findViewById(R.id.ans_cent_chld_pse);
        ans_cent_chld_blw_5y = (EditText) view.findViewById(R.id.ans_cent_chld_blw_5y);
        ans_cent_chld_weighed = (EditText) view.findViewById(R.id.ans_cent_chld_weighed);
        ans_cent_chld_mal_mod = (EditText) view.findViewById(R.id.ans_cent_chld_mal_mod);
        ans_cent_chld_mal_severe = (EditText) view.findViewById(R.id.ans_cent_chld_mal_severe);
        ans_cent_mom_meet = (EditText) view.findViewById(R.id.ans_cent_mom_meet);
        ans_cent_reg = (EditText) view.findViewById(R.id.ans_cent_reg);


        ans_cent_tot_ben.addTextChangedListener(this);
        ans_cent_ben_serv.addTextChangedListener(this);
        ans_cent_chld_6m_6y.addTextChangedListener(this);
        ans_cent_mor_snks.addTextChangedListener(this);
        ans_cent_chld_3y_6Y.addTextChangedListener(this);
        ans_cent_chld_pse.addTextChangedListener(this);
        ans_cent_chld_blw_5y.addTextChangedListener(this);
        ans_cent_chld_weighed.addTextChangedListener(this);
        ans_cent_chld_mal_mod.addTextChangedListener(this);
        ans_cent_chld_mal_severe.addTextChangedListener(this);
        ans_cent_mom_meet.addTextChangedListener(this);
        ans_cent_reg.addTextChangedListener(this);


        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, SELECT_PICTURE);
            }
        });

        btnSaveVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(latitude==(null) || longitude==(null) || latitude.isEmpty() || longitude.isEmpty()){
                    Toast.makeText(getContext(),"Can't get the location data, Try Again",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"Your location is " + latitude+ ":"+longitude,Toast.LENGTH_LONG).show();
                    if (vis_cent_open_switch.isChecked()) {

                        if (
                                VALID_FORM_CTRL_0 &&
                                        VALID_FORM_CTRL_1 &&
                                        VALID_FORM_CTRL_2 &&
                                        VALID_FORM_CTRL_3 &&
                                        VALID_FORM_CTRL_4 &&
                                        VALID_FORM_CTRL_5 &&
                                        VALID_FORM_CTRL_6 &&
                                        VALID_FORM_CTRL_7 &&
                                        VALID_FORM_CTRL_8

                                ) {
                            new saveVisitData().execute();
                            onVisitDataFragmentActivityListener.navigate2ListFragment();
                        } else {
                            Toast.makeText(getContext(), "Error: Please check your data before submitting...", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        new saveVisitData().execute();
                        onVisitDataFragmentActivityListener.navigate2ListFragment();
                    }
                }
            }
        });


        return view;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }


    @Override
    public void afterTextChanged(Editable editable) {
        try {
            tot_snp = Integer.parseInt(ans_cent_tot_ben.getText().toString());
        } catch (Exception e) {
            tot_snp = 0;
        }
        try {
            tot_snp_serv = Integer.parseInt(ans_cent_ben_serv.getText().toString());
        } catch (Exception e) {
            tot_snp_serv = 0;
        }
        try {
            tot_6_6 = Integer.parseInt(ans_cent_chld_6m_6y.getText().toString());
        } catch (Exception e) {
            tot_6_6 = 0;
        }
        try {
            mor_snks = Integer.parseInt(ans_cent_mor_snks.getText().toString());
        } catch (Exception e) {
            mor_snks = 0;
        }
        try {
            tot_3_6 = Integer.parseInt(ans_cent_chld_3y_6Y.getText().toString());
        } catch (Exception e) {
            tot_3_6 = 0;
        }
        try {
            pse = Integer.parseInt(ans_cent_chld_pse.getText().toString());
        } catch (Exception e) {
            pse = 0;
        }
        try {
            tot_blw_5 = Integer.parseInt(ans_cent_chld_blw_5y.getText().toString());
        } catch (Exception e) {
            tot_blw_5 = 0;
        }
        try {
            weighed = Integer.parseInt(ans_cent_chld_weighed.getText().toString());
        } catch (Exception e) {
            weighed = 0;
        }
        try {
            mal_mod = Integer.parseInt(ans_cent_chld_mal_mod.getText().toString());
        } catch (Exception e) {
            mal_mod = 0;
        }
        try {
            mal_seve = Integer.parseInt(ans_cent_chld_mal_severe.getText().toString());
        } catch (Exception e) {
            mal_seve = 0;
        }
        try {
            mom_meet = Integer.parseInt(ans_cent_mom_meet.getText().toString());
        } catch (Exception e) {
            mom_meet = 0;
        }
        try {
            register = Integer.parseInt(ans_cent_reg.getText().toString());
        } catch (Exception e) {
            register = 0;
        }

        /* form level validation*/

        if (tot_snp > 0) {
            VALID_FORM_CTRL_0 = Boolean.TRUE;
        } else {
            ans_cent_tot_ben.setError("Total beneficiaries should not be zero!");
            VALID_FORM_CTRL_0 = Boolean.FALSE;
        }

        if (tot_snp < tot_snp_serv) {
            ans_cent_ben_serv.setError("SNP served should be less/equal to total beneficiaries!");
            VALID_FORM_CTRL_1 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_1 = Boolean.TRUE;
        }

        if (tot_6_6 < mor_snks) {
            ans_cent_mor_snks.setError("No. of Morning snacks served should be less/equal to total child of age group 6 months to 6 years!");
            VALID_FORM_CTRL_2 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_2 = Boolean.TRUE;
        }

        if (tot_3_6 < pse) {
            ans_cent_chld_pse.setError("No. of heads present in PSE should be less/equal to total child of age group 3 years to 6 years!");
            VALID_FORM_CTRL_3 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_3 = Boolean.TRUE;
        }

        if (tot_blw_5 < weighed) {
            ans_cent_chld_weighed.setError("No. of children weighed should be less/equal to total child of age group below 5 years!");
            VALID_FORM_CTRL_4 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_4 = Boolean.TRUE;
        }

        if (weighed < mal_mod) {
            ans_cent_chld_mal_mod.setError("No. of moderately malnourished child should be less/equal to total child weighed!");
            VALID_FORM_CTRL_5 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_5 = Boolean.TRUE;
        }

        if (weighed < mal_seve) {
            ans_cent_chld_mal_severe.setError("No. of severely malnourished child should be less/equal to total child weighed!");
            VALID_FORM_CTRL_6 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_6 = Boolean.TRUE;
        }

        if (weighed < (mal_seve + mal_mod)) {
            ans_cent_chld_mal_mod.setError("Sum of malnourished child should be less/equal to total child weighed!");
            ans_cent_chld_mal_severe.setError("Sum of malnourished child should be less/equal to total child weighed!");
            VALID_FORM_CTRL_7 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_7 = Boolean.TRUE;
        }

        if (register > 13) {
            ans_cent_reg.setError("No. of registers should be 13 or less!");
            VALID_FORM_CTRL_8 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_8 = Boolean.TRUE;
        }


        if (tot_snp < tot_snp_serv && tot_snp < tot_6_6 && tot_snp < mor_snks && tot_snp < tot_3_6 && tot_snp < pse && tot_snp < tot_blw_5 && tot_snp < weighed && tot_snp < mal_mod && tot_snp < mal_seve) {
            ans_cent_ben_serv.setError("Total beneficiaries should be higher than any other numbers.");
            VALID_FORM_CTRL_1 = Boolean.FALSE;
        } else {
            VALID_FORM_CTRL_1 = Boolean.TRUE;
        }

    }


    private class saveVisitData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Visitdata vd = new Visitdata();
            vd.setVisit_id(0);
            vd.setCentreid(code);
            vd.setUserid(uid);
            vd.setVisit_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()).toString());
            vd.setVisit_lat(latitude);
            vd.setVisit_long(longitude);
            vd.setVisit_pic(vispic);
            vd.setOwn_building(vis_cent_open_switch.isChecked() ? "Yes" : "No");
            vd.setCentre_open(ans_cent_open_switch.isChecked() ? "Yes" : "No");
            if (ans_cent_open_switch.isChecked() == false) {
                vd.setBenef_total(0);
                vd.setBenef_serve(0);
                vd.setChld_7m_6y_tot(0);
                vd.setChld_7m_6y_Mor_Snacks(0);
                vd.setChld_3y_6y_tot(0);
                vd.setChld_3y_6y_PSE(0);
                vd.setChld_blw_5y_tot(0);
                vd.setChld_blw_5y_weighted(0);
                vd.setChld_blw_5y_mal_mod(0);
                vd.setChld_blw_5y_mal_severe(0);
                vd.setMother_meet(0);
                vd.setRegister_found(0);
                vd.setEcce_followed("N");
            } else {
                vd.setBenef_total(tot_snp);
                vd.setBenef_serve(tot_snp_serv);
                vd.setChld_7m_6y_tot(tot_6_6);
                vd.setChld_7m_6y_Mor_Snacks(mor_snks);
                vd.setChld_3y_6y_tot(tot_3_6);
                vd.setChld_3y_6y_PSE(pse);
                vd.setChld_blw_5y_tot(tot_blw_5);
                vd.setChld_blw_5y_weighted(weighed);
                vd.setChld_blw_5y_mal_mod(mal_mod);
                vd.setChld_blw_5y_mal_severe(mal_seve);
                vd.setMother_meet(mom_meet);
                vd.setRegister_found(register);
                vd.setEcce_followed(ans_cent_ecce_switch.isChecked() ? "Yes" : "No");
            }

            MainActivity.db.visitDAO().insert_visit(vd);

            MainActivity.db.centreDAO().update_centre_status(code, "Unsynced");
            MainActivity.db.centreDAO().update_centre_visited_on(code, "Last visited:" + (new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date())));

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getActivity(), "Visit saved successfully...", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            selectedImageUri = data.getData();
            vispic = RealPathUtils.getRealPathFromURI_API19(getContext(), selectedImageUri);
            btnSaveVisit.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), vispic, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        onVisitDataFragmentActivityListener = (OnVisitDataFragmentActivityListener) activity;
    }
}

