package com.example.notedefrais.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.notedefrais.MyApplication;
import com.example.notedefrais.entity.Dejeuner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DejeunerDao {

    // Create
    public static void saveDejeuner(Dejeuner dejeuner) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", dejeuner.getDate().toString()); // Supposons que la date est stockée sous forme de chaîne
        values.put("montant", dejeuner.getMontant());
        values.put("details",dejeuner.getDetails());
        values.put("nomSociete", dejeuner.getNomSociete());
        values.put("type_id", dejeuner.getType().getId());
        db.insert("NoteDeFrais", null, values); // Utilisation de la table "NoteDeFrais" au lieu de "Dejeuner"
        //db.close();
    }
    @SuppressLint("Range")
    public Dejeuner findDejeunerById(int dejeunerId){
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Dejeuner", null, "id=?", new String[]{String.valueOf(dejeunerId)}, null, null, null);

        Dejeuner dejeuner =null;
        if (cursor.moveToFirst()){
            dejeuner = new Dejeuner();
            dejeuner.setId(cursor.getInt(cursor.getColumnIndex("id")));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dejeuner.setDate(FonctionUtile.convertStringToDate(cursor.getString(cursor.getColumnIndex("date"))));
            }
            dejeuner.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
            dejeuner.setDetails(cursor.getString(cursor.getColumnIndex("details")));
            dejeuner.setNomSociete(cursor.getString(cursor.getColumnIndex("nomSociete")));
        }
        cursor.close();
        db.close();
        return dejeuner;
    }
    public static int updateDejeuner(Dejeuner dejeuner){
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date",String.valueOf(dejeuner.getDate()));
        values.put("montant", dejeuner.getMontant());
        values.put("details",dejeuner.getDetails());
        values.put("nomSociete", dejeuner.getNomSociete());

        int rowsAffected = db.update("NoteDeFrais", values, "id=?", new String[]{String.valueOf(dejeuner.getId())});
        db.close();
        return rowsAffected;
    }

    public static void deleteDejeuner(int dejeunerId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("NoteDeFrais", "id=?", new String[]{String.valueOf(dejeunerId)});
        db.close();
    }
}
