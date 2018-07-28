package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dgdev.mbtms.local.preferences.PreferencesConfig;
import com.dgdev.mbtms.remote.APIInterface;
import com.dgdev.mbtms.remote.ApiUtils;
import com.dgdev.mbtms.remote.ModelLoginResponse;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Userscreen extends Fragment {

    private APIInterface apiInterface;
    private PreferencesConfig pc;

    public Userscreen() {
        // Required empty public constructor
    }


    //this interface will communication to the main activity from this fragment.

    public interface OnLoginFragmentActivityListener{

        public void performRegistration ();
        public void performLogin(String Ucode);
        public void performLoginCheck();

    }

    OnLoginFragmentActivityListener loginFragmentActivityListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_userscreen, container, false);

        final EditText email = (EditText) view.findViewById(R.id.et_user_email);
        final EditText password = (EditText) view.findViewById(R.id.et_user_psw);
        final Button button = (Button) view.findViewById(R.id.btn_user_login);
        final TextView regTextview = (TextView) view.findViewById(R.id.tv_register);
        loginFragmentActivityListener.performLoginCheck();
        apiInterface = ApiUtils.getAPIService();


        //  Bellow section submits data to server to check login creadential.
        //  if, success then the user id will be returned.
        //  Which could be saved to Sharedpreferences for future use.

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String uemail = email.getText().toString().trim();
                String upassword = password.getText().toString().trim();
                try{
                    apiInterface.login(uemail, upassword).enqueue(new Callback<ModelLoginResponse>() {
                        @Override
                        public void onResponse(Call<ModelLoginResponse> call, Response<ModelLoginResponse> response) {
                            if (response.body().getStatus().equals("success")) {
                                loginFragmentActivityListener.performLogin(response.body().getRes_msg());
                                Toast.makeText(view.getContext(), "You are now logged into the system...", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(view.getContext(), response.body().getRes_msg(), Toast.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<ModelLoginResponse> call, Throwable t) {
                            Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        regTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginFragmentActivityListener.performRegistration();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFragmentActivityListener = (OnLoginFragmentActivityListener) activity;
    }
}
