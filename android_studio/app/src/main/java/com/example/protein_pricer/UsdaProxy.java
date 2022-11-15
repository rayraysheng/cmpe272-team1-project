package com.example.protein_pricer;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public class UsdaProxy {

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
        String url_mod = "search?query=" + query + "&pageSize=" + String.valueOf(pages);
        String url_full = url_base + url_mod;

        try {
            HttpResponse<JsonNode> response = Unirest.get(url_full).header("X-Api-Key", apikey).asJson();
            JSONObject json = response.getBody().getObject();
            System.out.println(json.toString());
            return json;
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
