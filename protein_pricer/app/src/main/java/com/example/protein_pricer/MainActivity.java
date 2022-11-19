package com.example.protein_pricer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.example.protein_pricer.SearchHandler.LocalBinder;

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

        searchHandler.search();
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