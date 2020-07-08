/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author gabri
 */
public class RetrofitClient {
     public static final String BASE_URL = "http://192.168.43.193:85/slim_kelompok/public/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if (retrofit == null){ retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }

        return retrofit;
    }
    
}
