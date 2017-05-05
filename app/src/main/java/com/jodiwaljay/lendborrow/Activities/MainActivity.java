package com.jodiwaljay.lendborrow.Activities;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jodiwaljay.lendborrow.Framework.PromptDialog;
import com.jodiwaljay.lendborrow.R;

public class MainActivity extends AppCompatActivity implements PromptDialog.DialogClickCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogFragment newFragment = new PromptDialog();
        Bundle args = new Bundle();
        args.putString("title", "Add Name to your extravaganza");
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "Add Trip");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String Text) {
        Log.d("Output is ",Text);

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Log.e("Output", "Cancelled");
    }
}
