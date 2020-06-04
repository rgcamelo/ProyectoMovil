package com.example.proyecto.Model.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ConnectionSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EMI.db";
    private static final int DATABASE_VERSION = 1;


    public ConnectionSQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Contract.DepartmentEntry.SQL_CREATE_DEPARTMENT_TABLE);
        db.execSQL(Contract.DepartmentEntry.SQL_INSERT_DEPARTMENT_TABLE);
        db.execSQL(Contract.MunicipalityEntry.SQL_CREATE_MUNICIPALITY_TABLE);
        db.execSQL(Contract.MunicipalityEntry.SQL_INSERT_MUNICIPALITY_TABLE);
        db.execSQL(Contract.SubCategoryEntry.SQL_CREATE_SUBCATEGORY_TABLE);
        db.execSQL(Contract.CategoryEntry.SQL_CREATE_CATEGORY_TABLE);
        db.execSQL(Contract.EventEntry.SQL_CREATE_EVENT_TABLE);
        db.execSQL(Contract.PlaceEntry.SQL_CREATE_PLACE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionOld, int versionNew) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.EventEntry.TABLE_NAME);
        onCreate(db);
    }


}
