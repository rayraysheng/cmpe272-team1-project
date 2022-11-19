package com.example.protein_pricer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Search {
    private String search_term;
    private int page_size = 10;
    private ArrayList<FoodItem> items;

    public Search(String term ){
        this.search_term = term;
        try {
            UsdaProxy.getInstance().search(search_term, page_size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Search(String term, int size){
        this.search_term = term;
        this.page_size = size;
        try {
            UsdaProxy.getInstance().search(search_term, page_size);
            //System.out.println("term: " + search_term + " size: " + page_size);
            //System.out.println("from SR: " + SearchReturn.getInstance().getItems().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(SearchReturn.getInstance().getItems().length());
        //saveItems();
    }

    public JSONArray getResults() {
        return SearchReturn.getInstance().getItems();
    }

    /*
    public void saveItems(){
        JSONArray array = getResults();
        System.out.println(SearchReturn.getInstance().getItems().toString());
        if(array != null){
            for(int i = 0; i < array.length(); i++){
                try {
                    System.out.println(i + ": ");
                    System.out.println(array.get(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     */
}
