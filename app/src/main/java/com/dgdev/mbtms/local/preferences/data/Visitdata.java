package com.dgdev.mbtms.local.preferences.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Visitdata {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int visit_id;
    String userid;
    String centreid;
    String visit_date;
    String visit_lat;
    String visit_long;
    String visit_pic;
    String own_building;
    String centre_open;
    int benef_total;
    int benef_serve;
    int chld_7m_6y_tot;
    int chld_7m_6y_Mor_Snacks;
    int chld_3y_6y_tot;
    int chld_3y_6y_PSE;
    int chld_blw_5y_tot;
    int chld_blw_5y_weighted;
    int chld_blw_5y_mal_mod;
    int chld_blw_5y_mal_severe;
    int mother_meet;
    int register_found;
    String ecce_followed;

    public Visitdata(@NonNull int visit_id, String userid, String centreid, String visit_date, String visit_lat, String visit_long, String visit_pic, String own_building, String centre_open, int benef_total, int benef_serve, int chld_7m_6y_tot, int chld_7m_6y_Mor_Snacks, int chld_3y_6y_tot, int chld_3y_6y_PSE, int chld_blw_5y_tot, int chld_blw_5y_weighted, int chld_blw_5y_mal_mod, int chld_blw_5y_mal_severe, int mother_meet, int register_found, String ecce_followed) {
        this.visit_id = visit_id;
        this.userid = userid;
        this.centreid = centreid;
        this.visit_date = visit_date;
        this.visit_lat = visit_lat;
        this.visit_long = visit_long;
        this.visit_pic = visit_pic;
        this.own_building = own_building;
        this.centre_open = centre_open;
        this.benef_total = benef_total;
        this.benef_serve = benef_serve;
        this.chld_7m_6y_tot = chld_7m_6y_tot;
        this.chld_7m_6y_Mor_Snacks = chld_7m_6y_Mor_Snacks;
        this.chld_3y_6y_tot = chld_3y_6y_tot;
        this.chld_3y_6y_PSE = chld_3y_6y_PSE;
        this.chld_blw_5y_tot = chld_blw_5y_tot;
        this.chld_blw_5y_weighted = chld_blw_5y_weighted;
        this.chld_blw_5y_mal_mod = chld_blw_5y_mal_mod;
        this.chld_blw_5y_mal_severe = chld_blw_5y_mal_severe;
        this.mother_meet = mother_meet;
        this.register_found = register_found;
        this.ecce_followed = ecce_followed;
    }

    public Visitdata() {
    }

    @NonNull
    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(@NonNull int visit_id) {
        this.visit_id = visit_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCentreid() {
        return centreid;
    }

    public void setCentreid(String centreid) {
        this.centreid = centreid;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
    }

    public String getVisit_lat() {
        return visit_lat;
    }

    public void setVisit_lat(String visit_lat) {
        this.visit_lat = visit_lat;
    }

    public String getVisit_long() {
        return visit_long;
    }

    public void setVisit_long(String visit_long) {
        this.visit_long = visit_long;
    }

    public String getVisit_pic() {
        return visit_pic;
    }

    public void setVisit_pic(String visit_pic) {
        this.visit_pic = visit_pic;
    }

    public String getOwn_building() {
        return own_building;
    }

    public void setOwn_building(String own_building) {
        this.own_building = own_building;
    }

    public String getCentre_open() {
        return centre_open;
    }

    public void setCentre_open(String centre_open) {
        this.centre_open = centre_open;
    }

    public int getBenef_total() {
        return benef_total;
    }

    public void setBenef_total(int benef_total) {
        this.benef_total = benef_total;
    }

    public int getBenef_serve() {
        return benef_serve;
    }

    public void setBenef_serve(int benef_serve) {
        this.benef_serve = benef_serve;
    }

    public int getChld_7m_6y_tot() {
        return chld_7m_6y_tot;
    }

    public void setChld_7m_6y_tot(int chld_7m_6y_tot) {
        this.chld_7m_6y_tot = chld_7m_6y_tot;
    }

    public int getChld_7m_6y_Mor_Snacks() {
        return chld_7m_6y_Mor_Snacks;
    }

    public void setChld_7m_6y_Mor_Snacks(int chld_7m_6y_Mor_Snacks) {
        this.chld_7m_6y_Mor_Snacks = chld_7m_6y_Mor_Snacks;
    }

    public int getChld_3y_6y_tot() {
        return chld_3y_6y_tot;
    }

    public void setChld_3y_6y_tot(int chld_3y_6y_tot) {
        this.chld_3y_6y_tot = chld_3y_6y_tot;
    }

    public int getChld_3y_6y_PSE() {
        return chld_3y_6y_PSE;
    }

    public void setChld_3y_6y_PSE(int chld_3y_6y_PSE) {
        this.chld_3y_6y_PSE = chld_3y_6y_PSE;
    }

    public int getChld_blw_5y_tot() {
        return chld_blw_5y_tot;
    }

    public void setChld_blw_5y_tot(int chld_blw_5y_tot) {
        this.chld_blw_5y_tot = chld_blw_5y_tot;
    }

    public int getChld_blw_5y_weighted() {
        return chld_blw_5y_weighted;
    }

    public void setChld_blw_5y_weighted(int chld_blw_5y_weighted) {
        this.chld_blw_5y_weighted = chld_blw_5y_weighted;
    }

    public int getChld_blw_5y_mal_mod() {
        return chld_blw_5y_mal_mod;
    }

    public void setChld_blw_5y_mal_mod(int chld_blw_5y_mal_mod) {
        this.chld_blw_5y_mal_mod = chld_blw_5y_mal_mod;
    }

    public int getChld_blw_5y_mal_severe() {
        return chld_blw_5y_mal_severe;
    }

    public void setChld_blw_5y_mal_severe(int chld_blw_5y_mal_severe) {
        this.chld_blw_5y_mal_severe = chld_blw_5y_mal_severe;
    }

    public int getMother_meet() {
        return mother_meet;
    }

    public void setMother_meet(int mother_meet) {
        this.mother_meet = mother_meet;
    }

    public int getRegister_found() {
        return register_found;
    }

    public void setRegister_found(int register_found) {
        this.register_found = register_found;
    }

    public String getEcce_followed() {
        return ecce_followed;
    }

    public void setEcce_followed(String ecce_followed) {
        this.ecce_followed = ecce_followed;
    }
}
