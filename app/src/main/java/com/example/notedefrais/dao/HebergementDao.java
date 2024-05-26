package com.example.notedefrais.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.notedefrais.MyApplication;
import com.example.notedefrais.entity.Hebergement;

public class HebergementDao {
    public static void saveHebergement(Hebergement hebergement) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", hebergement.getDate().toString()); // Supposons que la date est stockée sous forme de chaîne
        values.put("montant", hebergement.getMontant());
        values.put("details", hebergement.getDetails());
        values.put("distance", hebergement.getDistance());
        values.put("type_id", hebergement.getType().getId());
        db.insert("NoteDeFrais", null, values); // Utilisation de la table "NoteDeFrais" au lieu de "Hebergement"
        //db.close();

}
    @SuppressLint("Range")
    public Hebergement findHebergementById(int hebergementId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Hebergement", null, "id=?", new String[]{String.valueOf(hebergementId)}, null, null, null);

        Hebergement hebergement = null;
        if (cursor.moveToFirst()) {
            hebergement = new Hebergement();
            hebergement.setId(cursor.getInt(cursor.getColumnIndex("id")));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hebergement.setDate(FonctionUtile.convertStringToDate(cursor.getString(cursor.getColumnIndex("date"))));
            }
            hebergement.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
            hebergement.setDetails(cursor.getString(cursor.getColumnIndex("details")));
            hebergement.setDistance(cursor.getInt(cursor.getColumnIndex("distance")));

        }
        cursor.close();
        db.close();
        return hebergement;
    }
    public static int updateHebergement(Hebergement hebergement) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(hebergement.getDate()));
        values.put("montant", hebergement.getMontant());
        values.put("details", hebergement.getDetails());
        values.put("nomDistance", hebergement.getDistance());

        int rowsAffected = db.update("NoteDeFrais", values, "id=?", new String[]{String.valueOf(hebergement.getId())});
        db.close();
        return rowsAffected;

    }

    public static void deleteHebergement(int hebergementId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("Hebergement", "id=?", new String[]{String.valueOf(hebergementId)});
        db.close();
    }
}