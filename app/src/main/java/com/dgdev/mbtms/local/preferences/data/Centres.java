package com.dgdev.mbtms.local.preferences.data;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Centres {

    @NonNull
    @PrimaryKey
    private String Centre_id;

    private String Centre_name;

    private String visited_on;

    private String status;

    public Centres() {
    }

    @NonNull
    public String getCentre_id() {
        return Centre_id;
    }

    public void setCentre_id(@NonNull String centre_id) {
        Centre_id = centre_id;
    }

    public String getCentre_name() {
        return Centre_name;
    }

    public void setCentre_name(String centre_name) {
        Centre_name = centre_name;
    }

    public String getVisited_on() {
        return visited_on;
    }

    public void setVisited_on(String visited_on) {
        this.visited_on = visited_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
