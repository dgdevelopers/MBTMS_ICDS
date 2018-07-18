package com.dgdev.mbtms.remote;

public class ApiUtils {
    public ApiUtils() {
    }

    public static String BASE_URL = "http://192.168.137.1/mobileapi/";

    public static  APIInterface getAPIService(){
        return ApiClient.getClient(BASE_URL).create(APIInterface.class);
    }
}
