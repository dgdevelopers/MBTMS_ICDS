package com.dgdev.mbtms.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelLoginResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("res_msg")
    @Expose
    private String res_msg;

    public String getStatus() {
        return status;
    }

    public String getRes_msg() {
        return res_msg;
    }
}
