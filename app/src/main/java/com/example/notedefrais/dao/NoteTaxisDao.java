package com.example.notedefrais.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.example.notedefrais.MyApplication;
import com.example.notedefrais.entity.Hebergement;
import com.example.notedefrais.entity.NoteTaxis;

public class NoteTaxisDao {
    public static void saveNoteTaxis(NoteTaxis noteTaxis){
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", noteTaxis.getDate().toString());
        values.put("montant", noteTaxis.getMontant());
        values.put("villeDepart", noteTaxis.getVilleDepart());
        values.put("villeArrivee", noteTaxis.getVilleArrivee());
        values.put("nomClient", noteTaxis.getNomClient());
        values.put("typeId", noteTaxis.getId());
    }

    @SuppressLint("Range")
    public NoteTaxis findNoteTaxisById(int noteTaxisId){
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("NoteTaxis", null, "id=?", new String[]{String.valueOf(noteTaxisId)}, null, null, null);

        NoteTaxis noteTaxis = null;
        if (cursor.moveToFirst()) {
            noteTaxis = new NoteTaxis();
            noteTaxis.setId(cursor.getInt(cursor.getColumnIndex("id")));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                noteTaxis.setDate(FonctionUtile.convertStringToDate(cursor.getString(cursor.getColumnIndex("date"))));
            }
            noteTaxis.setMontant(cursor.getDouble(cursor.getColumnIndex("montant")));
            noteTaxis.setVilleDepart(cursor.getString(cursor.getColumnIndex("villeDepart")));
            noteTaxis.setVilleArrivee(cursor.getString(cursor.getColumnIndex("villeArrivee")));
            noteTaxis.setNomClient(cursor.getString(cursor.getColumnIndex("nomClient")));
        }
        cursor.close();
        db.close();
        return noteTaxis;
    }
    public static int updateNoteTaxis(NoteTaxis noteTaxis) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", String.valueOf(noteTaxis.getDate()));
        values.put("montant", noteTaxis.getMontant());
        values.put("villeDepart", noteTaxis.getVilleDepart());
        values.put("villeArrivee", noteTaxis.getVilleArrivee());
        values.put("nomClient", noteTaxis.getNomClient());

        int rowsAffected = db.update("NoteTaxis", values, "id=?", new String[]{String.valueOf(noteTaxis.getId())});
        db.close();
        return rowsAffected;

    }

    public static void deleteNoteTaxis(int noteTaxisId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("NoteTaxis", "id=?", new String[]{String.valueOf(noteTaxisId)});
        db.close();
    }
}

