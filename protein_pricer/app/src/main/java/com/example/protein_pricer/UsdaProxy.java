package com.example.protein_pricer;

import org.json.JSONObject;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONArray;

import java.util.Map;

import okhttp3.OkHttpClient;

public class UsdaProxy {

    private final OkHttpClient client = new OkHttpClient();
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);

    private static UsdaProxy instance;
    private final String apikey = "UkaojsuvAJCo3lryhbiiUg0eodTWSnmQyCIYr76d";

    private UsdaProxy(){}

    public static synchronized UsdaProxy getInstance(){
        if (instance == null){
            instance = new UsdaProxy();
        }
        return instance;
    }


    public JSONObject search(String query, int pages){

        String url_base = "https://api.nal.usda.gov/fdc/v1/foods/";
        String url_mod = "search?query=" + query + "&pageSize=" + String.valueOf(pages) + "&apikey=" + apikey;
        String url_full = url_base + url_mod;

        /*
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://api.nal.usda.gov/fdc/v1/foods/search?query=chicken%20breast%20tyson&pageSize=10&api_key=UkaojsuvAJCo3lryhbiiUg0eodTWSnmQyCIYr76d").asJson();
            JSONObject json = response.getBody().getObject();
            System.out.println(json.toString());
            return json;
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }

         */
        System.out.println("not here");
        return null;
    }

    static class Gist {
        Map<String, GistFile> files;
    }

    static class GistFile {
        String content;
    }
}
