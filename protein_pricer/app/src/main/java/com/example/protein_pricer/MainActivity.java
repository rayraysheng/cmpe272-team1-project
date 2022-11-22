package com.example.protein_pricer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.example.protein_pricer.SearchHandler.LocalBinder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Search search;

    SearchHandler searchHandler = new SearchHandler();
    boolean isConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SearchHandler.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

        /*
        UsdaProxy proxy = UsdaProxy.getInstance();
        try {
            proxy.search("chicken breast", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
        /*
        SearchReturn.getInstance();
        search = new Search("chicken breast", 10);

         */

        // To do a search
        try {
            searchHandler.search("tofu", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println("success: " + searchHandler.getResults().toString());
        //searchHandler.printItems();

        // After searching, access each food item by using:
        ArrayList<FoodItem> search_results = searchHandler.getItems();
        for(int i = 0; i < search_results.size(); i++){

            FoodItem item = search_results.get(i);

            // Then call the specific method to get specific field
            // For example:
            System.out.println("-------------------");
            System.out.println("id: " + item.getId());
            System.out.println("desc: " + item.getDescription());
            System.out.println("brand: " + item.getBrand());
            System.out.println("serving: " + item.getServing());
            System.out.println("protein " + item.getProtein());
            System.out.println("carbs " + item.getCarbs());
            System.out.println("fat " + item.getFat());
            System.out.println("energy " + item.getCalories());
            System.out.println("===================");
        }
    }
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocalBinder binder = (LocalBinder) iBinder;
            searchHandler = binder.getBoundService();
            isConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isConnected = false;
        }
    };
}