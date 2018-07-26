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

//    @POST("uploadvisit")
//    @FormUrlEncoded
//    Call<ModelUploadResponse> uploadVisitData(
//            @Field("userid")String userid,
//            @Field("centreid")String centreid,
//            @Field("visit_date")String visit_date,
//            @Field("visit_lat")String visit_lat,
//            @Field("visit_long")String visit_long,
//            @Field("visit_pic")String visit_pic,
//            @Field("own_building")String own_building,
//            @Field("centre_open")String centre_open,
//            @Field("benef_total")int benef_total,
//            @Field("benef_serve")int benef_serve,
//            @Field("chld_7m_6y_tot")int chld_7m_6y_tot,
//            @Field("chld_7m_6y_Mor_Snacks")int chld_7m_6y_Mor_Snacks,
//            @Field("chld_3y_6y_tot")int chld_3y_6y_tot,
//            @Field("chld_3y_6y_PSE")int chld_3y_6y_PSE,
//            @Field("chld_blw_5y_tot")int chld_blw_5y_tot,
//            @Field("chld_blw_5y_weighted")int chld_blw_5y_weighted,
//            @Field("chld_blw_5y_mal_mod")int chld_blw_5y_mal_mod,
//            @Field("chld_blw_5y_mal_severe")int chld_blw_5y_mal_severe,
//            @Field("mother_meet")int mother_meet,
//            @Field("register_found")int register_found,
//            @Field("ecce_followed")String ecce_followed
//    );

    @POST("uploadvisit")
    @Multipart
    Call<ModelUploadResponse> uploadVisitData(
            @Part("userid")RequestBody userid,
            @Part("centreid")RequestBody centreid,
            @Part("visit_date")RequestBody visit_date,
            @Part("visit_lat")RequestBody visit_lat,
            @Part("visit_long")RequestBody visit_long,
            @Part MultipartBody.Part visit_pic,
            @Part("own_building")RequestBody own_building,
            @Part("centre_open")RequestBody centre_open,
            @Part("benef_total")RequestBody benef_total,
            @Part("benef_serve")RequestBody benef_serve,
            @Part("chld_7m_6y_tot")RequestBody chld_7m_6y_tot,
            @Part("chld_7m_6y_Mor_Snacks")RequestBody chld_7m_6y_Mor_Snacks,
            @Part("chld_3y_6y_tot")RequestBody chld_3y_6y_tot,
            @Part("chld_3y_6y_PSE")RequestBody chld_3y_6y_PSE,
            @Part("chld_blw_5y_tot")RequestBody chld_blw_5y_tot,
            @Part("chld_blw_5y_weighted")RequestBody chld_blw_5y_weighted,
            @Part("chld_blw_5y_mal_mod")RequestBody chld_blw_5y_mal_mod,
            @Part("chld_blw_5y_mal_severe")RequestBody chld_blw_5y_mal_severe,
            @Part("mother_meet")RequestBody mother_meet,
            @Part("register_found")RequestBody register_found,
            @Part("ecce_followed")RequestBody ecce_followed
    );

}
