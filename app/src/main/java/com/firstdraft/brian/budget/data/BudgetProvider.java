package com.firstdraft.brian.budget.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by brisket on 2/25/2017.
 */

public class BudgetProvider extends ContentProvider {

    // Database Columns
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE_TIME = "entry_date_time";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_RECURRENCE = "recurrence";
    public static final String COLUMN_CATEGORY = "category";

    // Database Related Constants
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE_EXPENSE = "expense";

    // The database
    SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        db = new DatabaseHelper(getContext()).getWriteableDatabase();
        return true;
    }

    protected static class DatabaseHelper extends SQLiteOpenHelper {
        static final String DATABASE_CREATE =
                "create table" + DATABASE_TABLE_EXPENSE + " (" +
                        COLUMN_ID + " integer primary key autoincrement, " +
                        COLUMN_DATE_TIME + " integer not null, " +
                        COLUMN_AMOUNT + " text not null, " +
                        COLUMN_RECURRENCE + " text not null, " +
                        COLUMN_CATEGORY + " text not null, ";
    }
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@Nullable Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
