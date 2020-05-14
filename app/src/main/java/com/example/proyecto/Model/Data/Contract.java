package com.example.proyecto.Model.Data;

import android.provider.BaseColumns;

import com.example.proyecto.Model.Entities.SubCategory;

public final class Contract {

    private Contract(){}

    public final static class DepartmentEntry implements BaseColumns{
        public final static String TABLE_NAME = "Department";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DEPARTMENT_NAME = "name";
        public final static String DEPARTMENT_ID = "department"+_ID;


        public static final String SQL_CREATE_DEPARTMENT_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + DEPARTMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DEPARTMENT_NAME + " TEXT NOT NULL);";

        public static final String SQL_INSERT_DEPARTMENT_TABLE = "INSERT INTO " + TABLE_NAME + "("
                + COLUMN_DEPARTMENT_NAME + " )"+"VALUES"
                + "('Cesar');";
    }

    public final static class MunicipalityEntry implements BaseColumns{
        public final static String TABLE_NAME = "Municipality";
        public final static String _ID = BaseColumns._ID;
        public final static String MUNICIPALITY_ID = "municipality"+_ID;
        public final static String COLUMN_DEPARTMENT_ID = "department";
        public final static String COLUMN_MUNICIPALITY_NAME = "name";
        public final static String FOREIGN_KEY_DEPARTMENT = DepartmentEntry.DEPARTMENT_ID;

        public static final String SQL_CREATE_MUNICIPALITY_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + MUNICIPALITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DEPARTMENT_ID + " INTEGER,"
                + COLUMN_MUNICIPALITY_NAME + " TEXT NOT NULL,"
                + "FOREIGN KEY("+COLUMN_DEPARTMENT_ID+") REFERENCES "+DepartmentEntry.TABLE_NAME +"("+FOREIGN_KEY_DEPARTMENT+"));";

        public static final String SQL_INSERT_MUNICIPALITY_TABLE = "INSERT INTO " + TABLE_NAME + "("
                + COLUMN_MUNICIPALITY_NAME + ","+ COLUMN_DEPARTMENT_ID+ ")" + "VALUES"
                + "('Valledupar',1),"
                + "('Chiriguana',1),"
                + "('La Jagua de Ibirico',1),"
                + "('Agustin Codazzi',1),"
                + "('Aguachica',1),"
                + "('El paso',1),"
                + "('Curumani',1),"
                + "('Chimichagua',1),"
                + "('Bosconia',1),"
                + "('La Paz',1),"
                + "('Rio de Oro',1),"
                + "('Becerril',1),"
                + "('El Copey',1),"
                + "('Pueblo Bello',1),"
                + "('Astrea',1),"
                + "('Pailitas',1),"
                + "('Tamalameque',1),"
                + "('San Diego',1),"
                + "('Pelaya',1),"
                + "('La Gloria',1),"
                + "('San Alberto',1),"
                + "('San Martin',1),"
                + "('Gamarra',1),"
                + "('Gonzalez',1),"
                + "('Manaure Balcon del Cesar',1)";

    }

    public final static class SubCategoryEntry implements BaseColumns{

        public final static String TABLE_NAME = "SubCategory";
        public final static String SUBCATEGORY_ID = BaseColumns._ID;
        public final static String COLUMN_SUBCATEGORY_NAME = "name";


        public static final String SQL_CREATE_SUBCATEGORY_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + SUBCATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SUBCATEGORY_NAME + " TEXT NOT NULL);";
    }

    public final static class CategoryEntry implements BaseColumns{

        public final static String TABLE_NAME = "Category";
        public final static String CATEGORY_ID = BaseColumns._ID;
        public final static String COLUMN_SUBCATEGORY_ID = "subcategory_id";
        public final static String COLUMN_CATEGORY_NAME = "name";


        public static final String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SUBCATEGORY_ID + " INTEGER NOT NULL,"
                + COLUMN_CATEGORY_NAME + " TEXT NOT NULL,"
                + "FOREIGN KEY("+COLUMN_SUBCATEGORY_ID+") REFERENCES "+ SubCategoryEntry.TABLE_NAME +"("+SubCategoryEntry.SUBCATEGORY_ID+"));";
    }

    public final static class EventEntry implements BaseColumns{

        public final static String TABLE_NAME = "Event";
        public final static String EVENT_ID = BaseColumns._ID;
        public final static String COLUMN_EVENT_NAME = "name";
        public final static String COLUMN_EVENT_DESCRIPTION = "description";
        public final static String COLUMN_EVENT_LOCATION = "location";
        public final static String COLUMN_CATEGORY_ID = "category";
        public final static String COLUMN_MUNICIPALITY_ID = "municipality";
        public final static String COLUMN_EVENT_STATE = "municipality";
        public final static String COLUMN_EVENT_PHONE = "phone";
        public final static String COLUMN_EVENT_START = "dateStart";
        public final static String COLUMN_EVENT_END = "dateEnd";

        public static final String SQL_CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EVENT_NAME + " TEXT NOT NULL,"
                + COLUMN_EVENT_DESCRIPTION + " TEXT,"
                + COLUMN_EVENT_LOCATION + " TEXT NOT NULL,"
                + COLUMN_CATEGORY_ID + " INTEGER NOT NULL,"
                + COLUMN_MUNICIPALITY_ID + " INTEGER,"
                + COLUMN_EVENT_PHONE + " TEXT,"
                + COLUMN_EVENT_STATE + " TEXT,"
                + COLUMN_EVENT_START + "DATE NOT NULL,"
                + COLUMN_EVENT_END + "DATE NOT NULL,"
                + "FOREIGN KEY(" + COLUMN_MUNICIPALITY_ID + ") REFERENCES " + MunicipalityEntry.TABLE_NAME + "(" + MunicipalityEntry._ID+"),"
                + "FOREIGN KEY(" + COLUMN_CATEGORY_ID + ") REFERENCES "+ CategoryEntry.TABLE_NAME +"("+ CategoryEntry._ID +"));";
    }

    public final static class PlaceEntry implements BaseColumns{

        public final static String TABLE_NAME = "Place";
        public final static String EVENT_ID = BaseColumns._ID;
        public final static String COLUMN_PLACE_NAME = "name";
        public final static String COLUMN_PLACE_DESCRIPTION = "description";
        public final static String COLUMN_PLACE_LOCATION = "location";
        public final static String COLUMN_CATEGORY_ID = "category";
        public final static String COLUMN_MUNICIPALITY_ID = "municipality";
        public final static String COLUMN_PLACE_PHONE = "phone";
        public final static String COLUMN_PLACE_SCHEDULE = "Schedule";

        public static final String SQL_CREATE_PLACE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PLACE_NAME + " TEXT NOT NULL,"
                + COLUMN_PLACE_DESCRIPTION + " TEXT,"
                + COLUMN_PLACE_LOCATION + " TEXT NOT NULL,"
                + COLUMN_CATEGORY_ID + " INTEGER NOT NULL,"
                + COLUMN_MUNICIPALITY_ID + " INTEGER,"
                + COLUMN_PLACE_PHONE + " TEXT,"
                + COLUMN_PLACE_SCHEDULE + "TEXT NOT NULL,"
                + "FOREIGN KEY(" + COLUMN_MUNICIPALITY_ID + ") REFERENCES " + MunicipalityEntry.TABLE_NAME + "(" + MunicipalityEntry._ID+"),"
                + "FOREIGN KEY(" + COLUMN_CATEGORY_ID + ") REFERENCES "+ CategoryEntry.TABLE_NAME +"("+ CategoryEntry._ID +"));";
    }


}
