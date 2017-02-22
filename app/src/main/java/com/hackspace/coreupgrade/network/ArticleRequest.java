package com.hackspace.coreupgrade.network;


import com.hackspace.coreupgrade.data.ArticleEntity;
import com.hackspace.coreupgrade.data.TrackArticleHolder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by manu on 14/06/16.
 * Interfaz para consultar API referente al usuario
 */
public interface ArticleRequest {


    //registerUser, updateUser, updatePictureUser, recoveryPassword,
    @GET("v1/articles")
    Call<TrackArticleHolder> getArticles(@Query("source") String source,
                                         @Query("apiKey") String apiKey);



}
