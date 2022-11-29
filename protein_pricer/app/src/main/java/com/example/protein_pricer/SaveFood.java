package com.example.protein_pricer;

import android.icu.text.DateIntervalFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SaveFood {
    //private int index;
    private int fdcid;
    private String description;
    private String lowercaseDescription;
    private String dataType;
    private String gtinUpc;
    private String publishedDate;
    private String brandOwner;
    private String brandName;
    private String ingredients;
    private String marketCountry;
    private String foodCategory;
    private String modifiedDate;
    private String dataSource;
    private String packageWeight;
    private String servingSizeUnit;
    private String allHighlightFields;
    private int servingSize;



    public SaveFood(JSONObject json){
        setId(json);
        setBrand(json);
        setBrandOwner(json);
        setDescription(json);
        setLowercaseDescription(json);
        setingredients(json);
        setvalues(json);
    }
    public String getBrandOwner(){return brandOwner;}
    public String getlowercaseDescription(){return lowercaseDescription;}
    public String getdescription(){return description;}
    public String getbrandName(){return brandName;}
    public String getdataType(){return dataType;}
    public String getgtinUpc(){return gtinUpc;}
    public String getpublishedDate(){return publishedDate;}
    public String getmarketCountry(){return marketCountry;}
    public String getfoodCategory(){return foodCategory;}
    public String getmodifiedDate(){return modifiedDate;}
    public String getdataSource(){return dataSource;}
    public String getpackageWeight(){return packageWeight;}
    public String getservingSizeUnit(){return servingSizeUnit;}
    public String getallHighlightFields(){return allHighlightFields;}
    public int getfdcid(){return fdcid;}
    public int getservingSize(){return servingSize;}
    public String getingredients(){return ingredients;}

    public void setId(JSONObject json) {

        int fdcid = 0;

        try {
            fdcid = json.getInt("fdcId");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.fdcid = fdcid;
    }

    public void setBrand(JSONObject json) {
        String br = "";

        try {
            br = json.getString("brandName");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(br != ""){
            this.brandName = br;
        }
        else{
            this.brandName = "N/A";
        }

    }

    public void setBrandOwner(JSONObject json) {
        String br = "";

        try {
            br = json.getString("brandOwner");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(br != ""){
            this.brandOwner = br;
        }
        else{
            this.brandOwner = "N/A";
        }

    }

    public void setvalues(JSONObject json) {
        String br = "";
        String dt = "";
        String pd = "";
        String mc = "";
        String fc = "";
        String md = "";
        String ds = "";
        String pw = "";
        String ssu = "";
        String hf = "";
        int ss = 0;
        try {
            br = json.getString("gtinUpc");
            dt = json.getString("dataType");
            pd = json.getString("publishedDate");
            mc = json.getString("marketCountry");
            fc = json.getString("foodCategory");
            md = json.getString("modifiedDate");
            ds = json.getString("dataSource");
            pw = json.getString("packageWeight");
            ssu = json.getString("servingSizeUnit");
            hf = json.getString("allHighlightFields");
            ss = json.getInt("servingSize");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(br != "" && dt != "" && pd != ""){
            this.gtinUpc = br;
            this.dataType = dt;
            this.publishedDate = pd;
            this.marketCountry = mc;
            this.foodCategory = fc;
            this.modifiedDate = md;
            this.dataSource = ds;
            this.packageWeight = pw;
            this.servingSizeUnit = ssu;
            this.servingSize = ss;
            this.allHighlightFields = hf;

        }
        else{
            this.gtinUpc = "N/A";
        }

    }

    public void setingredients(JSONObject json) {
        String br = "";

        try {
            br = json.getString("ingredients");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(br != ""){
            this.ingredients = br;
        }
        else{
            this.ingredients = "N/A";
        }

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

    public void setLowercaseDescription(JSONObject json) {
        String desc = "";

        try {
            desc = json.getString("lowercaseDescription");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.lowercaseDescription = desc;
    }
}
