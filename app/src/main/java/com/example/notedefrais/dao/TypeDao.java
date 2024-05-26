package com.example.notedefrais.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notedefrais.MyApplication;
import com.example.notedefrais.entity.Type;

public class TypeDao {

    public static void saveType(Type type){
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("libelle", type.getLibelle());
        db.insert("Type",null, values);
    }
    @SuppressLint("Range")
    public static Type findById(int typeId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getReadableDatabase();
        Cursor cursor = db.query("Type", new String[]{"id","type"},"id=?", new String[]{String.valueOf(typeId)}, null, null, null);

        Type type = null;
        if (cursor.moveToFirst()){
            type = new Type();
            type.setId(cursor.getInt(cursor.getColumnIndex("id")));
            type.setLibelle(cursor.getString(cursor.getColumnIndex("type")));
        }
        cursor.close();

        return type;
    }

    public static int updateType(Type type){
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", type.getLibelle());

        int rowsAffected = db.update("Type", values, "id=?", new String[]{String.valueOf(type.getId())});
        db.close();
        return rowsAffected;
    }
    public static void deleteType(int typeId) {
        SQLiteDatabase db = MyApplication.getDbHelper().getWritableDatabase();
        db.delete("Type", "id=?", new String[]{String.valueOf(typeId)});
        db.close();
    }
}
