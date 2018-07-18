package com.dgdev.mbtms.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

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
}
