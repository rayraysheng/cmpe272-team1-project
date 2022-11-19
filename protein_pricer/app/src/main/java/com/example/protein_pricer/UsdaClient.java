package com.example.protein_pricer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsdaClient {

    private static Retrofit client;
    private static String url_base = "https://api.nal.usda.gov/fdc/v1/";
    private static String apikey = "UkaojsuvAJCo3lryhbiiUg0eodTWSnmQyCIYr76d";

    public static Retrofit getInstance(){
        if (client == null){
            client = new Retrofit.Builder()
                    .baseUrl(url_base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return client;
    }
}
