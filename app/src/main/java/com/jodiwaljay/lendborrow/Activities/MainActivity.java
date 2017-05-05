package com.jodiwaljay.lendborrow.Activities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jodiwaljay.lendborrow.Database.DatabaseController;
import com.jodiwaljay.lendborrow.Framework.PromptDialog;
import com.jodiwaljay.lendborrow.Information.ColumnPairs;
import com.jodiwaljay.lendborrow.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements PromptDialog.DialogClickCallback {

    private DatabaseController dbController;
    private final int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbController = new DatabaseController(openOrCreateDatabase("Essentials", Context.MODE_PRIVATE, null));


        DialogFragment newFragment = new PromptDialog();
        Bundle args = new Bundle();
        args.putString("title", "Add Name to your extravaganza");
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "Add Trip");

    }



    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        dbController.instantiateTable("Trips", ColumnPairs.getTripColumns());
        dbController.createEntry("Trips",text, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        // For Debugging
        /********************************************************************/
        SQLiteDatabase db = dbController.getDatabase();
        String tableName = "Trips";
        String tableString = String.format("Table %s:\n", tableName);
        Cursor allRows  = db.rawQuery("SELECT * FROM " + tableName, null);
        if (allRows.moveToFirst() ){
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name: columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }
        /***********************************************************************/

        Log.d("Output is ",tableString);

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Log.e("Output", "Cancelled");
    }
}
