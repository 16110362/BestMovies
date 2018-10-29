package com.example.henri.bestmovie.api;

import com.example.henri.bestmovie.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

public interface apiInterface {

    public static String DB_API="49b1d14c2b0e9c6f28b139b9352c5bea";

//    @GET("popular?api_key="+DB_API)
//    Call<Dates>getDates();

    @GET("popular?api_key="+DB_API)
    Call<Movie>getPopular();

    @GET("top_rated?api_key="+DB_API)
    Call<Movie>getRated();

}