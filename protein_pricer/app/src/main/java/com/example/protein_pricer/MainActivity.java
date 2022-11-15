package com.example.protein_pricer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsdaProxy proxy = UsdaProxy.getInstance();
       // proxy.search("chicken breast", 2);
        try {
            proxy.search("chicken breast", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}