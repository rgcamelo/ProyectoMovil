package com.example.proyecto.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EMI.db";
    private static final int DATABASE_VERSION = 1;

    public ConnectionSQLiteHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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

    }

    public void UpData(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesDepartmen = new ContentValues();
        valuesDepartmen.put(Contract.DepartmentEntry.COLUMN_DEPARTMENT_NAME,"Cesar");
        ContentValues valuesMunicipality = new ContentValues();
        valuesMunicipality.put(Contract.MunicipalityEntry.COLUMN_MUNICIPALITY_NAME,"Valledupar");
        valuesMunicipality.put(Contract.MunicipalityEntry.COLUMN_DEPARTMENT_ID,1);



    }
}
