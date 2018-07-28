package com.dgdev.mbtms.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.DateUtils;

import com.dgdev.mbtms.remote.ModelEfficiencyResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PreferencesConfig {

    private SharedPreferences sp;
    private Context context;

    public PreferencesConfig(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("com.dgdev.mbtms.pref", Context.MODE_PRIVATE);
    }

    public void WriteLoggedUser(String ucode) {
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("ucode", ucode);
        ed.commit();
    }

    public void RemoveLoggedUser() {
        SharedPreferences.Editor ed = sp.edit();
        ed.clear();
        ed.commit();
    }

    public String ReadLoggedUser() {
        return sp.getString("ucode", "None");
    }

    public boolean checkDatapresent(){
        boolean status = false;
        if(sp.contains("reportToDate")){
            Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date reportDate = dateFormat.parse(sp.getString("reportToDate",dateFormat.format(today)));
                status = DateUtils.isToday(reportDate.getTime());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return status;
    }

    public void saveEffiData(ModelEfficiencyResponse MER){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDate = new Date();
        Date fromDate = new Date( toDate.getTime() - 1000L*60L*60L*24L*30L);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("reportFromDate", dateFormat.format(fromDate));
        ed.putString("reportToDate", dateFormat.format(toDate));
        ed.putString("TOT_CENT",MER.gettOTCENT());
        ed.putString("TOT_VIS_CENT",MER.gettOTVISCENT());
        ed.putString("TOT_OPEN_CENT",MER.gettOTOPENCENT());
        ed.putString("TOT_SNP_BENEF",MER.gettOTSNPBENEF());
        ed.putString("TOT_SNP_SERV",MER.gettOTSNPSERV());
        ed.putString("TOT_6M_6Y",MER.gettOT6M6Y());
        ed.putString("TOT_MS_SERV",MER.gettOTMSSERV());
        ed.putString("TOT_3Y_6Y",MER.gettOT3Y6Y());
        ed.putString("TOT_PSE_P",MER.gettOTPSEP());
        ed.putString("TOT_BLW_5Y",MER.gettOTBLW5Y());
        ed.putString("TOT_WEIGHED",MER.gettOTWEIGHED());
        ed.putString("TOT_MOD",MER.gettOTMOD());
        ed.putString("TOT_SEVERE",MER.gettOTSEVERE());
        ed.putString("TOT_MOM_MEET",MER.gettOTMOMMEET());
        ed.putString("CENT_LESS_REG",MER.getcENTLESSREG());
        ed.putString("CENT_ECCE",MER.getcENTECCE());
        ed.putString("PERC_VISIT",MER.getpERCVISIT());
        ed.putString("PERC_OPEN",MER.getpERCOPEN());
        ed.putString("PERC_SNP",MER.getpERCSNP());
        ed.putString("PERC_MS",MER.getpERCMS());
        ed.putString("PERC_PSE",MER.getpERCPSE());
        ed.putString("PERC_WEIGHED",MER.getpERCWEIGHED());
        ed.putString("PERC_MAL_MOD",MER.getpERCMALMOD());
        ed.putString("PERC_MAL_SEVERE",MER.getpERCMALSEVERE());
        ed.putString("PERC_MOM_MEET",MER.getpERCMOMMEET());
        ed.putString("PERC_ECCE",MER.getpERCECCE());
        ed.putString("AVG_EFFI",MER.getaVGEFFI());
        ed.commit();
    }

    public ModelEfficiencyResponse getEffiData(){
        ModelEfficiencyResponse mer = new ModelEfficiencyResponse();
        mer.settOTCENT(sp.getString("TOT_CENT","0000"));
        mer.settOTVISCENT(sp.getString("TOT_VIS_CENT","0000"));
        mer.settOTOPENCENT(sp.getString("TOT_OPEN_CENT","0000"));
        mer.settOTSNPBENEF(sp.getString("TOT_SNP_BENEF","0000"));
        mer.settOTSNPSERV(sp.getString("TOT_SNP_SERV","0000"));
        mer.settOT6M6Y(sp.getString("TOT_6M_6Y","0000"));
        mer.settOTMSSERV(sp.getString("TOT_MS_SERV","0000"));
        mer.settOT3Y6Y(sp.getString("TOT_3Y_6Y","0000"));
        mer.settOTPSEP(sp.getString("TOT_PSE_P","0000"));
        mer.settOTBLW5Y(sp.getString("TOT_BLW_5Y","0000"));
        mer.settOTWEIGHED(sp.getString("TOT_WEIGHED","0000"));
        mer.settOTMOD(sp.getString("TOT_MOD","0000"));
        mer.settOTSEVERE(sp.getString("TOT_SEVERE","0000"));
        mer.settOTMOMMEET(sp.getString("TOT_MOM_MEET","0000"));
        mer.setcENTLESSREG(sp.getString("CENT_LESS_REG","0000"));
        mer.setcENTECCE(sp.getString("CENT_ECCE","0000"));
        mer.setpERCVISIT(sp.getString("PERC_VISIT","0000"));
        mer.setpERCOPEN(sp.getString("PERC_OPEN","0000"));
        mer.setpERCSNP(sp.getString("PERC_SNP","0000"));
        mer.setpERCMS(sp.getString("PERC_MS","0000"));
        mer.setpERCPSE(sp.getString("PERC_PSE","0000"));
        mer.setpERCWEIGHED(sp.getString("PERC_WEIGHED","0000"));
        mer.setpERCMALMOD(sp.getString("PERC_MAL_MOD","0000"));
        mer.setpERCMALSEVERE(sp.getString("PERC_MAL_SEVERE","0000"));
        mer.setpERCMOMMEET(sp.getString("PERC_MOM_MEET","0000"));
        mer.setpERCECCE(sp.getString("PERC_ECCE","0000"));
        mer.setaVGEFFI(sp.getString("AVG_EFFI","0000"));
        return mer;
    }

}
