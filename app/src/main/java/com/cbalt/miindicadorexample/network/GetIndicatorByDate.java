package com.cbalt.miindicadorexample.network;

import android.os.AsyncTask;

import com.cbalt.miindicadorexample.models.Wrapper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetIndicatorByDate extends AsyncTask<String, Void, Wrapper> {


    @Override
    protected Wrapper doInBackground(String... strings) {

        MiIndicador miIndicador = new Interceptor().getBasic();
        Call<Wrapper> indicator = miIndicador.indicatorByDate(strings[0], strings[1]);
        try {
            Response<Wrapper> response = indicator.execute();
            if(200 == response.code() && response.isSuccessful()){
                return response.body();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

}
