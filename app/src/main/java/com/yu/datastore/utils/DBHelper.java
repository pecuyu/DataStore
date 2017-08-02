package com.yu.datastore.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by D22436 on 2017/8/2.
 */

public class DBHelper  extends SQLiteOpenHelper {
    private static final String DB_NAME = "person.db";
    private static final int VERSION_DB = 1;
    private static final String CREATEAA_BOOK ="create table book(_id integer primary key autoincrement," +
            "name text," +
            "author text," +
            "price real," +
            "pages integer)";
    public DBHelper(Context context) {
        super(context, DB_NAME , null, VERSION_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATEAA_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
