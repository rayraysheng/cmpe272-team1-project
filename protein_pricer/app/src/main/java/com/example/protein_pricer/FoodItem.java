package com.example.protein_pricer;

import android.icu.text.DateIntervalFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodItem {

    private JSONArray nutrients;

    private int index;
    private int id;
    private double carbs = 0;
    private double protein = 0;
    private double fat = 0;
    private double calories = 0;
    private double size = 1;
    private String unit = "oz";
    private String brand = "N/A";
    private String description;

    public FoodItem(JSONObject json){
        setId(json);
        setDescription(json);
        setBrand(json);
        setUnit(json);
        setSize(json);
        setNutrients(json);
        //printAll();
    }

    public void checkType(JSONObject json, String key){
        try {
            System.out.println(json.get(key).getClass().getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setIndex(int i){
        this.index = i;
    }
    public int getIndex(){
        return this.index;
    }

    public double getId() {
        return id;
    }
    public void setId(JSONObject json) {

        int id = 0;

        try {
            id = json.getInt("fdcId");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.id = id;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCalories() {
        return calories;
    }


    public String getServing(){
        String serving = String.valueOf(getSize()) + getUnit();
        return serving;
    }

    public double getSize(){return size;}
    public void setSize(JSONObject json){
        double s = 0;

        try {
            s = json.getDouble("servingSize");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(s != 0){
            this.size = s;
        }
        else {
            this.size = 1;
        }
    };

    public String getUnit() {
        return unit;
    }
    public void setUnit(JSONObject json) {
        String u = "";

        try {
            u = json.getString("servingSizeUnit");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(u != ""){
            this.unit = u;
        }
        else {
            this.unit = "oz";
        }

    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(JSONObject json) {
        String br = "";

        try {
            br = json.getString("brandName");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(br != ""){
            this.brand = br;
        }
        else{
            this.brand = "N/A";
        }

    }

    public String getDescription() {
        return description;
    }
    public void setDescription(JSONObject json) {
        String desc = "";

        try {
            desc = json.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.description = desc;
    }

    // helper function to convert string to int
    private double toNum(String input){
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    // create nutrient list
    private void setNutrients(JSONObject json){
        try {
            nutrients =  json.getJSONArray("foodNutrients");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < nutrients.length(); i++){
            try {
                JSONObject obj = (JSONObject) nutrients.get(i);
                if(obj.getInt("nutrientId") == 1003){
                    this.protein = obj.getDouble("value");
                }
                if(obj.getInt("nutrientId") == 1004){
                    this.fat = obj.getDouble("value");
                }
                if(obj.getInt("nutrientId") == 1005){
                    this.carbs = obj.getDouble("value");
                }
                if(obj.getInt("nutrientId") == 1008){
                    this.calories = obj.getDouble("value");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void printAll(){
        System.out.println("-------------------");
        System.out.println("index: " + getIndex());
        System.out.println("id: " + getId());
        System.out.println("desc: " + getDescription());
        System.out.println("brand: " + getBrand());
        System.out.println("serving: " + getServing());
        System.out.println("protein " + getProtein());
        System.out.println("carbs " + getCarbs());
        System.out.println("fat " + getFat());
        System.out.println("energy " + getCalories());
        System.out.println("===================");
    }
}
