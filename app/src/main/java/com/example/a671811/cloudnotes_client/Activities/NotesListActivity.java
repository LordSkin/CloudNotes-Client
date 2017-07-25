package com.example.a671811.cloudnotes_client.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.Model.DAO.FakeDAO;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesDao;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;
import com.example.a671811.cloudnotes_client.R;
import com.example.a671811.cloudnotes_client.View.NotesAdapter;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity implements NotesResponseListener, View.OnClickListener {

    ListView listView;
    ProgressBar progress;
    FloatingActionButton fab;
    NotesDao notesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        listView = (ListView)findViewById(R.id.listView);
        progress = (ProgressBar) findViewById(R.id.progressBar1);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        progress.setVisibility(View.VISIBLE);
        fab.setOnClickListener(this);
        notesDao = new FakeDAO(this);
        notesDao.getNotes();

    }

    @Override
    public void getNotesResponse(ArrayList<Note> notes) {
        listView.setAdapter(new NotesAdapter(notes, this.getApplicationContext()));
        progress.setVisibility(View.GONE);
    }

    @Override
    public void getNoteResponse(Note note) {

    }

    @Override
    public void addNoteResponse(int id) {

    }

    @Override
    public void removeNoteResponse(boolean b) {

    }

    @Override
    public void clearAllResponse() {

    }

    @Override
    public void updateResponse(boolean ok) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onClick(View v) {

    }
}
