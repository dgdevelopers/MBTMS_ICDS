package com.dgdev.mbtms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Visit_form extends Fragment implements TextWatcher {

    String code, name, uid;
    TextView tvCentName, tvCentCode;
    Switch cSwitch;
    TableRow tr01, tr02, tr04, tr05, tr06, tr07, tr08, tr09, tr10, tr11, tr12, tr13, tr14;

    EditText ans_cent_tot_ben, ans_cent_ben_serv, ans_cent_chld_6m_6y, ans_cent_mor_snks, ans_cent_chld_3y_6Y, ans_cent_chld_pse, ans_cent_chld_blw_5y, ans_cent_chld_weighed, ans_cent_chld_mal_mod, ans_cent_chld_mal_severe, ans_cent_mom_meet, ans_cent_reg;

    Integer tot_snp, tot_snp_serv, tot_6_6, mor_snks, tot_3_6, pse, tot_blw_5, weighed, mal_mod, mal_seve, mom_meet, register;

    public Visit_form() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visit_form, container, false);
        code = getArguments().get("cent_code").toString();
        name = getArguments().get("cent_name").toString();
        uid = getArguments().get("uid").toString();
        tvCentName = (TextView) view.findViewById(R.id.vis_tv_centre_name);
        tvCentCode = (TextView) view.findViewById(R.id.vis_tv_centre_code);
        cSwitch = (Switch) view.findViewById(R.id.vis_cent_open_switch);
        tr01 = (TableRow) view.findViewById(R.id.row_open_01);
        tr02 = (TableRow) view.findViewById(R.id.row_open_02);
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
        tvCentName.setText(name);
        tvCentCode.setText(code);
        cSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cSwitch.isChecked()) {
                    cSwitch.setText(cSwitch.getTextOn().toString());
                    tr01.setVisibility(View.VISIBLE);
                    tr02.setVisibility(View.VISIBLE);
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

        if (tot_snp < tot_snp_serv) {
            ans_cent_ben_serv.setError("SNP served should be less/equal to total beneficiaries");
        }
        if (tot_6_6 < mor_snks) {
            ans_cent_mor_snks.setError("No. of Morning snacks served should be less/equal total child of age group 6 months to 6 years!");
        }
        if (tot_3_6 < pse) {
            ans_cent_chld_pse.setError("No. of heads present in PSE should be less/equal total child of age group 3 years to 6 years!");
        }
        if (tot_blw_5 < weighed) {
            ans_cent_chld_weighed.setError("No. of children weighed should be less/equal total child of age group below 5 years!");
        }

        if (weighed < mal_mod) {
            ans_cent_chld_mal_mod.setError("No. of moderately malnourished child should be less/equal total child weighed!");
        }

        if (weighed < mal_seve) {
            ans_cent_chld_mal_severe.setError("No. of severely malnourished child should be less/equal total child weighed!");
        }
        if (register > 12) {
            ans_cent_reg.setError("No. of registers should be 12 or less!");
        }

    }
}
