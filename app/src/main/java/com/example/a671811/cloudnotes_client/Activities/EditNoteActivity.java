package com.example.a671811.cloudnotes_client.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a671811.cloudnotes_client.Activities.NotesListActivity;
import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesDao;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;
import com.example.a671811.cloudnotes_client.Model.DAO.RestServer.DataService;
import com.example.a671811.cloudnotes_client.R;

import java.util.ArrayList;

public class EditNoteActivity extends AppCompatActivity implements View.OnClickListener, NotesResponseListener {

    FloatingActionButton fab;
    Note note;
    TextView updated, created;
    EditText noteEdit;
    NotesDao notesDao;
    Toolbar toolbar;
    ImageButton deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        updated = (TextView)findViewById(R.id.updatedLabel);
        created = (TextView)findViewById(R.id.createdLabel);
        noteEdit = (EditText)findViewById(R.id.noteTextEdit);
        toolbar = (Toolbar)findViewById(R.id.my_toolbar2);
        deleteButton = (ImageButton) findViewById(R.id.deleteNote);

        deleteButton.setOnClickListener(this);
        fab.setOnClickListener(this);
        note = (Note)getIntent().getSerializableExtra("Note");
        created.setText("Created: "+note.getCreated());
        updated.setText("Updated: "+note.getUpdated());
        noteEdit.setText(note.getNote());
        setSupportActionBar(toolbar);
        notesDao = new DataService(this, this, getIntent().getStringExtra("ipAddress"));

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.fab)
        {
            notesDao.updateNote(note.getId(), noteEdit.getText().toString());
        }
        else
        {
            notesDao.removeNote(note.getId());
        }
    }

    @Override
    public void getNotesResponse(ArrayList<Note> notes) {

    }

    @Override
    public void getNoteResponse(Note note) {

    }

    @Override
    public void addNoteResponse(int id) {

    }

    @Override
    public void removeNoteResponse(boolean b) {

        finish();
    }

    @Override
    public void updateResponse(boolean ok) {

        finish();
    }

    @Override
    public void onError(Exception e) {
        Snackbar.make(this.noteEdit, "Something went wrong :/ \n "+e, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        finish();
    }
}
