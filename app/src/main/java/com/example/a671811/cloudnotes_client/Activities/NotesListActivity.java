package com.example.a671811.cloudnotes_client.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesDao;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;
import com.example.a671811.cloudnotes_client.Model.DAO.RestServer.DataService;
import com.example.a671811.cloudnotes_client.R;
import com.example.a671811.cloudnotes_client.View.Dialogs.EnterNoteDialog;
import com.example.a671811.cloudnotes_client.View.NotesAdapter;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity implements NotesResponseListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, EnterNoteDialog.NoteAddedListener {

    ListView listView;
    ProgressBar progress;
    FloatingActionButton fab;
    NotesDao notesDao;
    SwipeRefreshLayout swipeRefreshLayout;
    String ipAddress;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ipAddress = getIntent().getStringExtra("ip");
        setContentView(R.layout.activity_test);
        listView = (ListView)findViewById(R.id.listView);
        progress = (ProgressBar) findViewById(R.id.progressBar1);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
        notesAdapter = new NotesAdapter(new ArrayList<Note>(), this.getApplicationContext(), ipAddress);

        listView.setOnItemClickListener(notesAdapter);
        listView.setAdapter(notesAdapter);
        swipeRefreshLayout.setOnRefreshListener(this);
        progress.setVisibility(View.VISIBLE);
        fab.setOnClickListener(this);
        notesDao = new DataService(this, this, ipAddress);
        notesDao.getNotes();

    }


    @Override
    public void getNotesResponse(ArrayList<Note> notes) {
        notesAdapter.update(notes);
        progress.setVisibility(View.GONE);
        if(swipeRefreshLayout.isRefreshing())swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        notesDao.getNotes();
    }

    @Override
    public void getNoteResponse(Note note) {

    }

    @Override
    public void addNoteResponse(int id) {
        notesDao.getNotes();
    }

    @Override
    public void removeNoteResponse(boolean b) {

    }

    @Override
    public void updateResponse(boolean ok) {

    }

    @Override
    public void onError(Exception e) {
        progress.setVisibility(View.GONE);
        Snackbar.make(this.listView, "Something went wrong :/ \n "+e, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onClick(View v) {
        EnterNoteDialog dialog = new EnterNoteDialog();
        dialog.show(getFragmentManager(), "Add new note");
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        notesDao.getNotes();
    }

    @Override
    public void onNoteAdded(String note) {
        notesDao.addNote(note);
        progress.setVisibility(View.VISIBLE);
    }


}
