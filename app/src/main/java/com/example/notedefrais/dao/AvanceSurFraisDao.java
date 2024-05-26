package com.example.notedefrais.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notedefrais.MyApplication;
import com.example.notedefrais.entity.AvanceSurFrais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvanceSurFraisDao {
    public void saveAvanceSurFrais(AvanceSurFrais avanceSurFrais) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", avanceSurFrais.getDate().toString()); // Supposons que la date est stockée sous forme de chaîne
        values.put("montant", avanceSurFrais.getMontant());
        values.put("justificatif", avanceSurFrais.getJustificatif());
        db.insert("NoteDeFrais", null, values); // Utilisation de la table "NoteDeFrais" au lieu de "AvanceSurFrais"
        //db.close();
    }

    @SuppressLint("Range")
    public AvanceSurFrais findAvanceSurFraisById(int avanceSurFraisId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("AvanceSurFrais", null, "id=?", new String[]{String.valueOf(avanceSurFraisId)}, null, null, null);

        AvanceSurFrais avanceSurFrais = null;
        if (cursor.moveToFirst()) {
            avanceSurFrais = new AvanceSurFrais();
            avanceSurFrais.setId(cursor.getInt(cursor.getColumnIndex("id")));
            avanceSurFrais.setJustificatif(cursor.getString(cursor.getColumnIndex("justificatif")));

        }
        cursor.close();
        db.close();
        return avanceSurFrais;
    }

    public static int updateAvanceSurFrais(AvanceSurFrais avanceSurFrais) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("justificatif", avanceSurFrais.getJustificatif());

        int rowsAffected = db.update("AvanceSurFrais", values, "id=?", new String[]{String.valueOf(avanceSurFrais.getId())});
        db.close();
        return rowsAffected;

    }

    public static void deleteAvanceSurFrais(int avanceSurFraisId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("AvanceSurFrais", "id=?", new String[]{String.valueOf(avanceSurFraisId)});
        db.close();
    }
}
