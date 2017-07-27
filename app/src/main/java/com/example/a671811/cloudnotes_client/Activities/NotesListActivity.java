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
import com.example.a671811.cloudnotes_client.Model.DAO.FakeDAO;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesDao;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;
import com.example.a671811.cloudnotes_client.Model.DAO.RestServer.DataService;
import com.example.a671811.cloudnotes_client.R;
import com.example.a671811.cloudnotes_client.View.NotesAdapter;

import java.util.ArrayList;
import java.util.Random;

public class NotesListActivity extends AppCompatActivity implements NotesResponseListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    ListView listView;
    ProgressBar progress;
    FloatingActionButton fab;
    NotesDao notesDao;
    Toolbar myToolbar;
    SwipeRefreshLayout swipeRefreshLayout;
    String ipAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ipAddress = getIntent().getStringExtra("ip");
        setContentView(R.layout.activity_test);
        listView = (ListView)findViewById(R.id.listView);
        progress = (ProgressBar) findViewById(R.id.progressBar1);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);

        swipeRefreshLayout.setOnRefreshListener(this);
        setSupportActionBar(myToolbar);
        progress.setVisibility(View.VISIBLE);
        fab.setOnClickListener(this);
        notesDao = new DataService(this, this, ipAddress);
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
        Snackbar.make(this.listView, "Something went wrong :/", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onClick(View v) {
        progress.setVisibility(View.VISIBLE);
        Random r = new Random();
        String s = "";
        for (int i =0; i<5; i++)
        {
            s+= r.nextInt(999);
        }
        notesDao.addNote(s);
    }

    @Override
    public void onRefresh() {
        progress.setVisibility(View.VISIBLE);
        notesDao.getNotes();
    }
}
