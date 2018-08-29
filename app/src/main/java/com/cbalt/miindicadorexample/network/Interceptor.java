package com.cbalt.miindicadorexample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Interceptor {

    private static final String BASE_URL = "https://mindicador.cl/";

    public MiIndicador getBasic(){

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MiIndicador indicatorRequest = interceptor.create(MiIndicador.class);

        return indicatorRequest;
    }
}
