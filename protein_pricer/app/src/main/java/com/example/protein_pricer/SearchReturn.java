package com.example.protein_pricer;
import org.json.JSONArray;

public class SearchReturn {
    private static SearchReturn results;
    private JSONArray items;

    public static synchronized SearchReturn getInstance(){
        if(results == null){
            results = new SearchReturn();
        }
        return results;
    }

    public void setItems(JSONArray input){
        this.items = input;
    }

    public JSONArray getItems(){
        return this.items;
    }
}
