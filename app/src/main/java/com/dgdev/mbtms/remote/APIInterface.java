package com.dgdev.mbtms.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {


    @POST("login")
    @FormUrlEncoded
    Call<ModelLoginResponse> login(@Field("email") String email, @Field("psw") String Password);

    @GET("centrelist")
    Call<List<ModelCentreListItem>> getCentreList(@Query("uid") String uid);

}
