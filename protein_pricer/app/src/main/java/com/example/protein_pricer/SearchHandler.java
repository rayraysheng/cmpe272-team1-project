package com.example.protein_pricer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SearchHandler extends Service {

    public LocalBinder local_binder = new LocalBinder();

    public SearchHandler() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return local_binder;
    }

    public void search(){
        System.out.println("working");
    }

    public class LocalBinder extends Binder {
        SearchHandler getBoundService() {
            return SearchHandler.this;
        }
    }
}