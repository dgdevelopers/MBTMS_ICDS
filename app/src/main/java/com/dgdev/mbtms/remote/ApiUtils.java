package com.dgdev.mbtms.remote;

public class ApiUtils {
    public ApiUtils() {
    }

    //public static String BASE_URL = "http://icds.000webhostapp.com/mobileapi/";
    public static String BASE_URL = "http://v2.icdsjalpaiguri.in/mobileapi/";

    public static APIInterface getAPIService() {
        return ApiClient.getClient(BASE_URL).create(APIInterface.class);
    }
}
