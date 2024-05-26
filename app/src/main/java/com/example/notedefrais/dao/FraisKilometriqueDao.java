package com.example.notedefrais.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.notedefrais.MyApplication;
import com.example.notedefrais.entity.FraisKilometrique;

import java.time.LocalDate;

public class FraisKilometriqueDao {
    public static void saveFraisKilometrique(FraisKilometrique fraisKilometrique){
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase(); //Obtient une référence à la base de données en mode écriture.
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(fraisKilometrique.getDate()));
        values.put("montant", fraisKilometrique.getMontant());
        values.put("details", fraisKilometrique.getDetails());
        values.put("villeDepart", fraisKilometrique.getLieuDepart());
        values.put("villeArrivee", fraisKilometrique.getLieuArrivee());
        values.put("nomClient", fraisKilometrique.getNomClient());
        values.put("distance",fraisKilometrique.getKilometrage());
       // values.put("photocopieCarteGrise",fraisKilometrique.getPhotocopieCarteGrise());
        values.put("type_id", fraisKilometrique.getType().getId());
        db.insert("NoteDeFrais",null,values); // NoteDeFrais ?
        //db.close();
    }
    @SuppressLint("Range")
    public FraisKilometrique findFraisKilometriqueById(int fraisKilometriqueId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("FraisKilometrique", null, "id=?", new String[]{String.valueOf(fraisKilometriqueId)}, null, null, null);

        FraisKilometrique fraisKilometrique = null;
        if (cursor.moveToFirst()) {
            fraisKilometrique = new FraisKilometrique();
            fraisKilometrique.setId(cursor.getInt(cursor.getColumnIndex("id")));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                fraisKilometrique.setDate(FonctionUtile.convertStringToDate(cursor.getString(cursor.getColumnIndex("date"))));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                fraisKilometrique.setDate(LocalDate.parse(cursor.getString(cursor.getColumnIndex("date"))));
            }

            fraisKilometrique.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
            fraisKilometrique.setDetails(cursor.getString(cursor.getColumnIndex("details")));
            fraisKilometrique.setKilometrage(cursor.getDouble(cursor.getColumnIndex("distance")));
            fraisKilometrique.setNomClient(cursor.getString(cursor.getColumnIndex("nomClient")));
            fraisKilometrique.setLieuDepart(cursor.getString(cursor.getColumnIndex("villeDepart")));
            fraisKilometrique.setLieuArrivee(cursor.getString(cursor.getColumnIndex("villeArrivee")));
            //fraisKilometrique.setPhotocopieCarteGrise(cursor.getString(cursor.getColumnIndex("photocopieCarteGrise")));
        }
        cursor.close();
        db.close();
        return fraisKilometrique;
    }

    public static int updateFraisKilometrique(FraisKilometrique fraisKilometrique) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(fraisKilometrique.getDate()));
        values.put("montant", fraisKilometrique.getMontant());
        values.put("details", fraisKilometrique.getDetails());
        values.put("distance", fraisKilometrique.getKilometrage());
        values.put("nomClient", fraisKilometrique.getNomClient());
        values.put("villeDepart", fraisKilometrique.getLieuDepart());
        values.put("villeArrivee", fraisKilometrique.getLieuArrivee());
       // values.put("photocopieCarteGrise", fraisKilometrique.getPhotocopieCarteGrise());


        int rowsAffected = db.update("NoteDeFrais", values, "id=?", new String[]{String.valueOf(fraisKilometrique.getId())});
        db.close();
        return rowsAffected;

    }

    public static void deleteFraisKilometrique(int fraisKilometriqueId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("NoteDeFrais", "id=?", new String[]{String.valueOf(fraisKilometriqueId)});
        db.close();
    }

}
