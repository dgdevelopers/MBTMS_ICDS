package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dgdev.mbtms.local.preferences.PreferencesConfig;


/**
 * A simple {@link Fragment} subclass.
 */
public class Welcome extends Fragment {



    public interface onWelcomeFragmentActivityLienster {
        public void logout();
        public void backToDash();
    }

    onWelcomeFragmentActivityLienster welcomeFragmentActivityLienster;

    public Welcome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        final Button btnLogOut = (Button) view.findViewById(R.id.btn_logout);
        final Button btnBack2Dash = (Button) view.findViewById(R.id.btnBackToDash);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeFragmentActivityLienster.logout();
            }
        });
        btnBack2Dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeFragmentActivityLienster.backToDash();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        welcomeFragmentActivityLienster = (onWelcomeFragmentActivityLienster) activity;
    }
}
