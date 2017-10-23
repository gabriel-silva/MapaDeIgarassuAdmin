package br.edu.ifpe.pibex.iphan.mapadeigarassuadmin.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.ifpe.pibex.iphan.mapadeigarassuadmin.constants.Constants;

public class ConnectionDataBaseUtil extends SQLiteOpenHelper{

    public ConnectionDataBaseUtil(Context context) {
        super(context, Constants.NAME_DB, null, Constants.VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constants.DROP_TABLE);
        onCreate(db);
    }

}
