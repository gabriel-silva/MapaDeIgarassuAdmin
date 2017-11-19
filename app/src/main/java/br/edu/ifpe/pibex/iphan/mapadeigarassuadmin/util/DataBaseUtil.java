package br.edu.ifpe.pibex.iphan.mapadeigarassuadmin.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import br.edu.ifpe.pibex.iphan.mapadeigarassuadmin.constants.Constants;
import br.edu.ifpe.pibex.iphan.mapadeigarassuadmin.model.LocationModel;

public class DataBaseUtil extends ConnectionDataBaseUtil {

    protected SQLiteDatabase database;
    protected SQLiteStatement stmt;
    protected Cursor cursor;

    public DataBaseUtil(Context context) {
        super(context);
        ConnectionDataBaseUtil db = new ConnectionDataBaseUtil(context);
        database = db.getWritableDatabase();
    }

    public void dropTable() {
        database.execSQL(Constants.DROP_TABLE);
        onCreate(database);
    }

    public void insertLocation(LocationModel locationModel) {

        stmt = database.compileStatement(Constants.INSERT_ALL);
        stmt.bindString(1, locationModel.getName());
        stmt.bindDouble(2, locationModel.getLongitude());
        stmt.bindDouble(3, locationModel.getLatitude());
        stmt.bindString(4, locationModel.getAddress());
        stmt.bindString(5, locationModel.getDescription());
        stmt.executeInsert();
    }

    public void updateLocation(LocationModel locationModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement(Constants.UPDATE_TABLE_LOCATION);
        stmt.bindString(1, locationModel.getName());
        stmt.bindDouble(2, locationModel.getLongitude());
        stmt.bindDouble(3, locationModel.getLatitude());
        stmt.bindString(4, locationModel.getAddress());
        stmt.bindString(5, locationModel.getDescription());
        stmt.bindLong(6, locationModel.getId());
        stmt.execute();
    }

    public void deleteLocation(int locationId) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement(Constants.DELETE_LOCATION);
        stmt.bindLong(1, locationId);
        stmt.execute();
    }

    public LocationModel getLocation(String searchLocation) {

        cursor = database.rawQuery(Constants.SELECT_FROM_NAME, new String[]{ searchLocation });
        cursor.moveToNext();

        int id = cursor.getColumnIndex(Constants.ID);
        int name = cursor.getColumnIndex(Constants.NAME);
        int longitude = cursor.getColumnIndex(Constants.LONGITUDE);
        int latitude = cursor.getColumnIndex(Constants.LATITUDE);
        int address = cursor.getColumnIndex(Constants.ADDRESS);
        int description = cursor.getColumnIndex(Constants.DESCRIPTION);

        Log.d("id"," "+cursor.getInt(id));
        Log.d("name"," "+cursor.getString(name));
        Log.d("longitude"," "+cursor.getDouble(longitude));
        Log.d("latitude"," "+cursor.getDouble(latitude));
        Log.d("address"," "+cursor.getString(address));
        Log.d("latitude"," "+cursor.getString(description));


        LocationModel locationModel = new LocationModel();
        locationModel.setId(cursor.getInt(id));
        locationModel.setName(cursor.getString(name));
        locationModel.setLongitude(Double.valueOf(cursor.getString(longitude)));
        locationModel.setLatitude(Double.valueOf(cursor.getString(latitude)));
        locationModel.setAddress(cursor.getString(address));
        locationModel.setDescription(cursor.getString(description));

        return locationModel;
    }

}
