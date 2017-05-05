package com.jodiwaljay.lendborrow.Framework;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.jodiwaljay.lendborrow.R;

/**
 * Created by jodiwaljay on 24/3/17.
 */

public class PromptDialog extends DialogFragment {



    public interface DialogClickCallback {
        public void onDialogPositiveClick(DialogFragment dialog, String Text);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(getArguments().getString("title"));
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View view = inflater.inflate(R.layout.prompt_dialog, null);
        builder.setView(view)


                .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(PromptDialog.this, ((EditText)view.findViewById(R.id.dialog_text)).getText().toString());
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNegativeClick(PromptDialog.this);
                    }
                });

        return builder.create();
    }

    DialogClickCallback mListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {

            mListener = (DialogClickCallback) context;
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

}
