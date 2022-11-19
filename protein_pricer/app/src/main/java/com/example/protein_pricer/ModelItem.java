package com.example.protein_pricer;
import java.util.ArrayList;

public class ModelItem {
    int fdcId;
    String dataType;
    String description;
    String foodCode; // only for FNDDS
    String brandOwner; // only for Branded
    ArrayList<nutrient> nutrients;

    public class nutrient{
        int number;
        String name;
        double amount;
        String unitName;
    }
}
