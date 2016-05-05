package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.City;
import model.County;
import model.Province;

/**
 * Created by Administrator on 2016/05/05/0005.
 */
public class CoolWhetherDb {
    private static final String dbName = "cool_whether";
    private SQLiteDatabase db;
    private static CoolWhetherDb coolWhetherDb;
    private static final int VERSION = 1;

    public CoolWhetherDb(Context context){
        CoolWhetherOpenHelper coolWhetherOpenHelper = new CoolWhetherOpenHelper(context,
                null,dbName,VERSION);
        db = coolWhetherOpenHelper.getWritableDatabase();
    }

    public synchronized static CoolWhetherDb getInstance(Context context){
        if (coolWhetherDb == null){
            coolWhetherDb = new CoolWhetherDb(context);
        }
        return coolWhetherDb;
    }

    public void saveProvince(Province province){
        if (province != null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }

    public List<Province> loadProvinces(){
        List<Province> list = new ArrayList<>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                Province province = new Province();
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                list.add(province);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void saveCity(City city){
        if (city != null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            db.insert("City",null,values);
        }
    }

    public List<City> loadCities(){
        List<City> list = new ArrayList<>();
        Cursor cursor = db.query("City",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));

                list.add(city);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void saveCounty(County county){
        if (county != null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            db.insert("County",null,values);
        }
    }

    public List<County> loadCounties(){
        List<County> list = new ArrayList<>();
        Cursor cursor = db.query("County",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));

                list.add(county);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
