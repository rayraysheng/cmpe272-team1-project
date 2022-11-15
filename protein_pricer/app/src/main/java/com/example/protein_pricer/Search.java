package com.example.protein_pricer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Search {
    private String search_term;
    private JSONObject response;
    private JSONArray results;

    public Search(String term){
        this.search_term = term;
    }

    public JSONArray getResults() {
        return results;
    }
}
