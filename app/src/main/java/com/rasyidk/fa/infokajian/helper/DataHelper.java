package com.rasyidk.fa.infokajian.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "infokajian";
    private static final int DATABASE_VERSION = "1";

    public DataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table INFO(id integer primary key, nama text null, tgl text null, jk text null, jurusan text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO mahasiswa (no, nama, tgl, jk, jurusan) VALUES ('1001', 'codeborneo', '1994-13-11', 'Laki-laki','teknik sipil');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
