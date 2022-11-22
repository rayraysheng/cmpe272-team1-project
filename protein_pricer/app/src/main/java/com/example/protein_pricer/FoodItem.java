package com.example.protein_pricer;

import android.icu.text.DateIntervalFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodItem {

    private JSONObject json;
    private JSONArray nutrients;

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
        this.json = json;
        setId();
        setDescription();
        setBrand();
        setUnit();
        setSize();
        setNutrients();
        //printAll();
    }

    public void checkType(String key){
        try {
            System.out.println(json.get(key).getClass().getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJson() { return json; }

    public double getId() {
        return id;
    }
    public void setId() {

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
    public void setSize(){
        double s = 0;

        try {
            s = json.getDouble("servingSize");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.size = s;
    };

    public String getUnit() {
        return unit;
    }
    public void setUnit() {
        String u = "";

        try {
            u = json.getString("servingSizeUnit");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.unit = u;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand() {
        String br = "";

        try {
            br = json.getString("brandName");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.brand = br;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription() {
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
    private void setNutrients(){
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
