package com.samebits.beacon.locator.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prachisingh on 20/03/18.
 */

public class ApiClient {
    static private ApiInterface ApiInterface;


    public static ApiInterface getAuthorizedApiInterface(){
        if(ApiInterface==null){

            Retrofit retrofit= new Retrofit.Builder().baseUrl("https://statue-api-1.herokuapp.com/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            ApiInterface =retrofit.create(ApiInterface.class);
        }
        return ApiInterface;
    }


}
