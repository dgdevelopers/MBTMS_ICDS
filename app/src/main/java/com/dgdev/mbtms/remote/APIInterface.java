package com.dgdev.mbtms.remote;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIInterface {


    @POST("login")
    @FormUrlEncoded
    Call<ModelLoginResponse> login(@Field("email") String email, @Field("psw") String Password);

    @GET("centrelist")
    Call<List<ModelCentreListItem>> getCentreList(@Query("uid") String uid);

    @POST("uploadvisit")
    @FormUrlEncoded
    Call<ModelUploadResponse> uploadVisitData(
            @Field("userid")String userid,
            @Field("centreid")String centreid,
            @Field("visit_date")String visit_date,
            @Field("visit_lat")String visit_lat,
            @Field("visit_long")String visit_long,
            @Field("visit_pic")String visit_pic,
            @Field("own_building")String own_building,
            @Field("centre_open")String centre_open,
            @Field("benef_total")int benef_total,
            @Field("benef_serve")int benef_serve,
            @Field("chld_7m_6y_tot")int chld_7m_6y_tot,
            @Field("chld_7m_6y_Mor_Snacks")int chld_7m_6y_Mor_Snacks,
            @Field("chld_3y_6y_tot")int chld_3y_6y_tot,
            @Field("chld_3y_6y_PSE")int chld_3y_6y_PSE,
            @Field("chld_blw_5y_tot")int chld_blw_5y_tot,
            @Field("chld_blw_5y_weighted")int chld_blw_5y_weighted,
            @Field("chld_blw_5y_mal_mod")int chld_blw_5y_mal_mod,
            @Field("chld_blw_5y_mal_severe")int chld_blw_5y_mal_severe,
            @Field("mother_meet")int mother_meet,
            @Field("register_found")int register_found,
            @Field("ecce_followed")String ecce_followed
    );

}
