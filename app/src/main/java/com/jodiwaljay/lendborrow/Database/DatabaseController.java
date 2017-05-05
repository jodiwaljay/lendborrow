package com.jodiwaljay.lendborrow.Database;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


/**
 * Created by jodiwaljay on 12/7/16.
 */
public class DatabaseController {

    private SQLiteDatabase db;
    private String dbName;

    public DatabaseController(SQLiteDatabase db){
        //this.dbName = dbName;
        //instantiateDatabase(this.dbName);
        this.db = db;
    }

    public SQLiteDatabase getDatabase(){
        return db;
    }

    private void instantiateDatabase(String dbName){
            db = SQLiteDatabase.openOrCreateDatabase(dbName, null);
    }

    public void instantiateTable(String TableName, ArrayList<PairDataType> colNames ){

        String tableCreateSql = "CREATE TABLE IF NOT EXISTS ";

        tableCreateSql = tableCreateSql + TableName + "(";

        for (PairDataType pair: colNames) {
            tableCreateSql = tableCreateSql + pair.getColumnName() + " " + pair.getDtType() + ",";
        }

        tableCreateSql = tableCreateSql.substring(0,tableCreateSql.lastIndexOf(","));
        tableCreateSql = tableCreateSql + ");";

        db.execSQL(tableCreateSql);

    }

    public void createEntry (String TableName, String ... values){
        String entryCreateSql = "INSERT INTO " + TableName + " VALUES('" ;

        for(String value : values){
            entryCreateSql = entryCreateSql + value + "','";
        }

        entryCreateSql = entryCreateSql.substring(0,entryCreateSql.lastIndexOf(","));
        entryCreateSql = entryCreateSql.substring(0,entryCreateSql.lastIndexOf("'"));

        entryCreateSql = entryCreateSql + "');" ;
        db.execSQL(entryCreateSql);
    }


}
