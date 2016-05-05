package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/05/05/0005.
 */
public class CoolWhetherOpenHelper extends SQLiteOpenHelper {
    public static final String CREATE_PROVINCE = "CREATE TABLE Province (" +
            "id integer primary key autoincrement, "+
            "province_name text, "+
            "province_code text)";

    public static final String CREATE_CITY = "CREATE TABLE City (" +
            "id integer primary key autoincrement, "+
            "city_name text, " +
            "city_code text, " +
            "province_id integer)";

    private static final String CREATE_COUNTY = "CREATE TABLE County (" +
            "id integer primary key autoincrement, " +
            "county_name text, " +
            "county_code text, " +
            "city_id text)";

    public CoolWhetherOpenHelper(Context context, SQLiteDatabase.CursorFactory factory,
                                 String name,int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
