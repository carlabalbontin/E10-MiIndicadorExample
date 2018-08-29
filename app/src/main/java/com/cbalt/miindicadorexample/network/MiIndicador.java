package com.cbalt.miindicadorexample.network;

import com.cbalt.miindicadorexample.models.Wrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MiIndicador {

    @GET("api/{indicator}/{date}/")
    Call<Wrapper> indicatorByDate(@Path("indicator") String indicator, @Path("date") String date);

}
