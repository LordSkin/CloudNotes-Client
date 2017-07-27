package com.example.a671811.cloudnotes_client.View.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.a671811.cloudnotes_client.R;

/**
 * Created by A671811 on 2017-07-27.
 */

public class EnterNoteDialog extends DialogFragment {

    private NoteAddedListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View editView = inflater.inflate(R.layout.ad_note_dialog, null);
        final EditText noteEdit = (EditText) editView.findViewById(R.id.dialogNoteText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("tekst1")
                .setView(editView)
                .setPositiveButton("tekst2", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onNoteAdded(noteEdit.getText().toString());
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (NoteAddedListener) context;

    }

    public interface NoteAddedListener
    {
        public void onNoteAdded(String note);
    }

}