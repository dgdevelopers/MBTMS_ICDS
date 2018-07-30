package com.dgdev.mbtms;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.dgdev.mbtms.local.preferences.data.Centres;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Visits extends Fragment {

    View view;
    RecyclerView recyclerView;
    public centreAdapter adapter;
    List<Centres> CentresArray;
    ImageButton btnSearch, btnClose;
    ConstraintLayout constraintLayoutSearch, constraintLayoutTitle;
    EditText editText;

    public Visits() {
        // Required empty public constructor
    }

    public interface OnVisitFragmentActivityListener {

        public void checkvisits();
    }

    OnVisitFragmentActivityListener visitFragmentActivityListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_visits, container, false);
        visitFragmentActivityListener.checkvisits();
        recyclerView = (RecyclerView) view.findViewById(R.id.Recycler_View_Centres);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        btnSearch = (ImageButton) view.findViewById(R.id.imgBtnSearch);
        btnClose = (ImageButton) view.findViewById(R.id.imgBtnClose);
        constraintLayoutSearch = (ConstraintLayout) view.findViewById(R.id.ConstLaySearch);
        constraintLayoutTitle = (ConstraintLayout) view.findViewById(R.id.constLayoutHead);
        editText = (EditText) view.findViewById(R.id.etSearchCentre);

        new loadlist().execute();

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.getFilter().filter("");
                editText.setText("");
                constraintLayoutTitle.setVisibility(View.VISIBLE);
                constraintLayoutSearch.setVisibility(View.GONE);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintLayoutSearch.setVisibility(View.VISIBLE);
                constraintLayoutTitle.setVisibility(View.GONE);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(editable.toString().toLowerCase());
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        visitFragmentActivityListener = (OnVisitFragmentActivityListener) activity;
    }


    //This inner class is for loading centre list to recyclerview.

    private class loadlist extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            CentresArray = MainActivity.db.centreDAO().select_all_centres();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new centreAdapter(CentresArray);
            recyclerView.setAdapter(adapter);
        }
    }
}
