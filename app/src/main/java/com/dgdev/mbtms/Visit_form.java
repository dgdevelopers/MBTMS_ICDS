package com.dgdev.mbtms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Visit_form extends Fragment {

    String code, name, uid;
    TextView tvCentName, tvCentCode;
    Switch cSwitch;
    TableRow tr01,tr02,tr03,tr04,tr05,tr06,tr07,tr08,tr09,tr10,tr11,tr12,tr13,tr14;

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
        tvCentName = (TextView)view.findViewById(R.id.vis_tv_centre_name);
        tvCentCode = (TextView)view.findViewById(R.id.vis_tv_centre_code);
        cSwitch = (Switch)view.findViewById(R.id.vis_cent_open_switch);
        tr01 = (TableRow)view.findViewById(R.id.row_open_01);
        tr02 = (TableRow)view.findViewById(R.id.row_open_02);
        tr03 = (TableRow)view.findViewById(R.id.row_open_03);
        tr04 = (TableRow)view.findViewById(R.id.row_open_04);
        tr05 = (TableRow)view.findViewById(R.id.row_open_05);
        tr06 = (TableRow)view.findViewById(R.id.row_open_06);
        tr07 = (TableRow)view.findViewById(R.id.row_open_07);
        tr08 = (TableRow)view.findViewById(R.id.row_open_08);
        tr09 = (TableRow)view.findViewById(R.id.row_open_09);
        tr10 = (TableRow)view.findViewById(R.id.row_open_10);
        tr11 = (TableRow)view.findViewById(R.id.row_open_11);
        tr12 = (TableRow)view.findViewById(R.id.row_open_12);
        tr13 = (TableRow)view.findViewById(R.id.row_open_13);
        tr14 = (TableRow)view.findViewById(R.id.row_open_14);
        tvCentName.setText(name);
        tvCentCode.setText(code);
        cSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cSwitch.isChecked()){
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
                }else{
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

        return view;
    }

}
