package com.example.notedefrais;

import android.app.Application;
import com.example.notedefrais.dao.DatabaseHelper;

public class MyApplication extends Application {
    private static DatabaseHelper dbHelper ;
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialiser votre base de données ici
        dbHelper = new DatabaseHelper(getApplicationContext());
        dbHelper.getWritableDatabase();


    }
    public static DatabaseHelper getDbHelper() {
        return dbHelper;
    }
    public static void setDbHelper(DatabaseHelper dbHelper) {
        MyApplication.dbHelper = dbHelper;
    }
}

