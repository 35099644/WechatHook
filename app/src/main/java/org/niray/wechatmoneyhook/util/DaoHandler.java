package org.niray.wechatmoneyhook.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.niray.wechatmoneyhook.MyApplication;

public class DaoHandler {

    private MyDatabaseHelper helper;

    private DaoHandler() {
        helper = new MyDatabaseHelper(MyApplication.getInstance());
    }

    public static DaoHandler getInstance() {
        return SingleHolder.instance;
    }

    public Cursor query(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase readableDatabase = helper.getReadableDatabase();
        return readableDatabase.query(MyDatabaseHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    public void add(ContentValues values) {
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        int result = writableDatabase.update(MyDatabaseHelper.TABLE_NAME, values, null, null);
        if (result == 0) {
            writableDatabase.insert(MyDatabaseHelper.TABLE_NAME, null, values);
        }
    }

    private static class SingleHolder {
        private static DaoHandler instance = new DaoHandler();
    }

}
