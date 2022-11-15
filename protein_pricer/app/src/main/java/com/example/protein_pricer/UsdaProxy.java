package com.example.protein_pricer;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UsdaProxy {

    private final OkHttpClient client = new OkHttpClient();
    private final Moshi moshi = new Moshi.Builder().build();


    private static UsdaProxy instance;
    private static HttpURLConnection connection;
    private final String apikey = "UkaojsuvAJCo3lryhbiiUg0eodTWSnmQyCIYr76d";

    private UsdaProxy() {
    }


    public static synchronized UsdaProxy getInstance() {
        if (instance == null) {
            instance = new UsdaProxy();
        }
        return instance;
    }

    public void search(String term, int size) throws Exception {

        String url_base = "https://api.nal.usda.gov/fdc/v1/foods/search?query=";
        String url_mod = term + "&pageSize=" + String.valueOf(size) + "&api_key=" + apikey;

        Request request = new Request.Builder()
                .url(url_base + url_mod)
                .build();

        client.newCall(request).enqueue(new Callback() {
            private JSONArray result;

            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    String json_string = responseBody.string();

                    try {
                        JSONObject json = new JSONObject(json_string);
                        JSONArray foods =  json.getJSONArray("foods");

                        //System.out.println(foods.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //return client.newCall(request).enqueue().onResponse.foods;
    }
}