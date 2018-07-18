package com.dgdev.mbtms.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCentreListItem {

    @SerializedName("centre_id")
    @Expose
    private String centreId;
    @SerializedName("centre_name")
    @Expose
    private String centreName;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("sectorid")
    @Expose
    private String sectorid;

    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSectorid() {
        return sectorid;
    }

    public void setSectorid(String sectorid) {
        this.sectorid = sectorid;
    }
}
