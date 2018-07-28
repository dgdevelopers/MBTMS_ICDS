package com.dgdev.mbtms.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelEfficiencyResponse {
    @SerializedName("TOT_CENT")
    @Expose
    private String tOTCENT;
    @SerializedName("TOT_VIS_CENT")
    @Expose
    private String tOTVISCENT;
    @SerializedName("TOT_OPEN_CENT")
    @Expose
    private String tOTOPENCENT;
    @SerializedName("TOT_SNP_BENEF")
    @Expose
    private String tOTSNPBENEF;
    @SerializedName("TOT_SNP_SERV")
    @Expose
    private String tOTSNPSERV;
    @SerializedName("TOT_6M_6Y")
    @Expose
    private String tOT6M6Y;
    @SerializedName("TOT_MS_SERV")
    @Expose
    private String tOTMSSERV;
    @SerializedName("TOT_3Y_6Y")
    @Expose
    private String tOT3Y6Y;
    @SerializedName("TOT_PSE_P")
    @Expose
    private String tOTPSEP;
    @SerializedName("TOT_BLW_5Y")
    @Expose
    private String tOTBLW5Y;
    @SerializedName("TOT_WEIGHED")
    @Expose
    private String tOTWEIGHED;
    @SerializedName("TOT_MOD")
    @Expose
    private String tOTMOD;
    @SerializedName("TOT_SEVERE")
    @Expose
    private String tOTSEVERE;
    @SerializedName("TOT_MOM_MEET")
    @Expose
    private String tOTMOMMEET;
    @SerializedName("CENT_LESS_REG")
    @Expose
    private String cENTLESSREG;
    @SerializedName("CENT_ECCE")
    @Expose
    private String cENTECCE;
    @SerializedName("PERC_VISIT")
    @Expose
    private String pERCVISIT;
    @SerializedName("PERC_OPEN")
    @Expose
    private String pERCOPEN;
    @SerializedName("PERC_SNP")
    @Expose
    private String pERCSNP;
    @SerializedName("PERC_MS")
    @Expose
    private String pERCMS;
    @SerializedName("PERC_PSE")
    @Expose
    private String pERCPSE;
    @SerializedName("PERC_WEIGHED")
    @Expose
    private String pERCWEIGHED;
    @SerializedName("PERC_MAL_MOD")
    @Expose
    private String pERCMALMOD;
    @SerializedName("PERC_MAL_SEVERE")
    @Expose
    private String pERCMALSEVERE;
    @SerializedName("PERC_MOM_MEET")
    @Expose
    private String pERCMOMMEET;
    @SerializedName("PERC_ECCE")
    @Expose
    private String pERCECCE;
    @SerializedName("AVG_EFFI")
    @Expose
    private String aVGEFFI;

    public ModelEfficiencyResponse() {
    }

    public ModelEfficiencyResponse(String tOTCENT, String tOTVISCENT, String tOTOPENCENT, String tOTSNPBENEF, String tOTSNPSERV, String tOT6M6Y, String tOTMSSERV, String tOT3Y6Y, String tOTPSEP, String tOTBLW5Y, String tOTWEIGHED, String tOTMOD, String tOTSEVERE, String tOTMOMMEET, String cENTLESSREG, String cENTECCE, String pERCVISIT, String pERCOPEN, String pERCSNP, String pERCMS, String pERCPSE, String pERCWEIGHED, String pERCMALMOD, String pERCMALSEVERE, String pERCMOMMEET, String pERCECCE, String aVGEFFI) {
        this.tOTCENT = tOTCENT;
        this.tOTVISCENT = tOTVISCENT;
        this.tOTOPENCENT = tOTOPENCENT;
        this.tOTSNPBENEF = tOTSNPBENEF;
        this.tOTSNPSERV = tOTSNPSERV;
        this.tOT6M6Y = tOT6M6Y;
        this.tOTMSSERV = tOTMSSERV;
        this.tOT3Y6Y = tOT3Y6Y;
        this.tOTPSEP = tOTPSEP;
        this.tOTBLW5Y = tOTBLW5Y;
        this.tOTWEIGHED = tOTWEIGHED;
        this.tOTMOD = tOTMOD;
        this.tOTSEVERE = tOTSEVERE;
        this.tOTMOMMEET = tOTMOMMEET;
        this.cENTLESSREG = cENTLESSREG;
        this.cENTECCE = cENTECCE;
        this.pERCVISIT = pERCVISIT;
        this.pERCOPEN = pERCOPEN;
        this.pERCSNP = pERCSNP;
        this.pERCMS = pERCMS;
        this.pERCPSE = pERCPSE;
        this.pERCWEIGHED = pERCWEIGHED;
        this.pERCMALMOD = pERCMALMOD;
        this.pERCMALSEVERE = pERCMALSEVERE;
        this.pERCMOMMEET = pERCMOMMEET;
        this.pERCECCE = pERCECCE;
        this.aVGEFFI = aVGEFFI;
    }

    public String gettOTCENT() {
        return tOTCENT;
    }

    public void settOTCENT(String tOTCENT) {
        this.tOTCENT = tOTCENT;
    }

    public String gettOTVISCENT() {
        return tOTVISCENT;
    }

    public void settOTVISCENT(String tOTVISCENT) {
        this.tOTVISCENT = tOTVISCENT;
    }

    public String gettOTOPENCENT() {
        return tOTOPENCENT;
    }

    public void settOTOPENCENT(String tOTOPENCENT) {
        this.tOTOPENCENT = tOTOPENCENT;
    }

    public String gettOTSNPBENEF() {
        return tOTSNPBENEF;
    }

    public void settOTSNPBENEF(String tOTSNPBENEF) {
        this.tOTSNPBENEF = tOTSNPBENEF;
    }

    public String gettOTSNPSERV() {
        return tOTSNPSERV;
    }

    public void settOTSNPSERV(String tOTSNPSERV) {
        this.tOTSNPSERV = tOTSNPSERV;
    }

    public String gettOT6M6Y() {
        return tOT6M6Y;
    }

    public void settOT6M6Y(String tOT6M6Y) {
        this.tOT6M6Y = tOT6M6Y;
    }

    public String gettOTMSSERV() {
        return tOTMSSERV;
    }

    public void settOTMSSERV(String tOTMSSERV) {
        this.tOTMSSERV = tOTMSSERV;
    }

    public String gettOT3Y6Y() {
        return tOT3Y6Y;
    }

    public void settOT3Y6Y(String tOT3Y6Y) {
        this.tOT3Y6Y = tOT3Y6Y;
    }

    public String gettOTPSEP() {
        return tOTPSEP;
    }

    public void settOTPSEP(String tOTPSEP) {
        this.tOTPSEP = tOTPSEP;
    }

    public String gettOTBLW5Y() {
        return tOTBLW5Y;
    }

    public void settOTBLW5Y(String tOTBLW5Y) {
        this.tOTBLW5Y = tOTBLW5Y;
    }

    public String gettOTWEIGHED() {
        return tOTWEIGHED;
    }

    public void settOTWEIGHED(String tOTWEIGHED) {
        this.tOTWEIGHED = tOTWEIGHED;
    }

    public String gettOTMOD() {
        return tOTMOD;
    }

    public void settOTMOD(String tOTMOD) {
        this.tOTMOD = tOTMOD;
    }

    public String gettOTSEVERE() {
        return tOTSEVERE;
    }

    public void settOTSEVERE(String tOTSEVERE) {
        this.tOTSEVERE = tOTSEVERE;
    }

    public String gettOTMOMMEET() {
        return tOTMOMMEET;
    }

    public void settOTMOMMEET(String tOTMOMMEET) {
        this.tOTMOMMEET = tOTMOMMEET;
    }

    public String getcENTLESSREG() {
        return cENTLESSREG;
    }

    public void setcENTLESSREG(String cENTLESSREG) {
        this.cENTLESSREG = cENTLESSREG;
    }

    public String getcENTECCE() {
        return cENTECCE;
    }

    public void setcENTECCE(String cENTECCE) {
        this.cENTECCE = cENTECCE;
    }

    public String getpERCVISIT() {
        return pERCVISIT;
    }

    public void setpERCVISIT(String pERCVISIT) {
        this.pERCVISIT = pERCVISIT;
    }

    public String getpERCOPEN() {
        return pERCOPEN;
    }

    public void setpERCOPEN(String pERCOPEN) {
        this.pERCOPEN = pERCOPEN;
    }

    public String getpERCSNP() {
        return pERCSNP;
    }

    public void setpERCSNP(String pERCSNP) {
        this.pERCSNP = pERCSNP;
    }

    public String getpERCMS() {
        return pERCMS;
    }

    public void setpERCMS(String pERCMS) {
        this.pERCMS = pERCMS;
    }

    public String getpERCPSE() {
        return pERCPSE;
    }

    public void setpERCPSE(String pERCPSE) {
        this.pERCPSE = pERCPSE;
    }

    public String getpERCWEIGHED() {
        return pERCWEIGHED;
    }

    public void setpERCWEIGHED(String pERCWEIGHED) {
        this.pERCWEIGHED = pERCWEIGHED;
    }

    public String getpERCMALMOD() {
        return pERCMALMOD;
    }

    public void setpERCMALMOD(String pERCMALMOD) {
        this.pERCMALMOD = pERCMALMOD;
    }

    public String getpERCMALSEVERE() {
        return pERCMALSEVERE;
    }

    public void setpERCMALSEVERE(String pERCMALSEVERE) {
        this.pERCMALSEVERE = pERCMALSEVERE;
    }

    public String getpERCMOMMEET() {
        return pERCMOMMEET;
    }

    public void setpERCMOMMEET(String pERCMOMMEET) {
        this.pERCMOMMEET = pERCMOMMEET;
    }

    public String getpERCECCE() {
        return pERCECCE;
    }

    public void setpERCECCE(String pERCECCE) {
        this.pERCECCE = pERCECCE;
    }

    public String getaVGEFFI() {
        return aVGEFFI;
    }

    public void setaVGEFFI(String aVGEFFI) {
        this.aVGEFFI = aVGEFFI;
    }
}
