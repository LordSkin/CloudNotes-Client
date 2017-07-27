package com.example.a671811.cloudnotes_client.Model.DAO.RestServer;

import android.content.Context;
import android.util.JsonReader;

import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesDao;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Exchanger;

/**
 * Created by A671811 on 2017-07-25.
 */

public class DataService implements RestResponse, NotesDao {

    private RequestSender requestSender;
    NotesResponseListener listener;

    public DataService(NotesResponseListener listener, Context context, String url) {
        this.listener = listener;
        requestSender = new RequestSender(url, context, this);
    }

    @Override
    public void notesListResponse(String s) {
        try
        {
            JSONArray jsonArray = new JSONArray(s);
            ArrayList<Note> result = new ArrayList<Note>();
            for (int i=0; i<jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                result.add(new Note(new Date(jsonObject.getLong("created")), new Date(jsonObject.getLong("updated")), jsonObject.getString("note")));
            }
            listener.getNotesResponse(result);
        }
        catch (Exception e)
        {
            listener.onError(e);
        }


    }

    @Override
    public void addNoteResponse(String s) {
        try
        {
            int result = Integer.parseInt(s);
            if(result>0)
            {
                listener.addNoteResponse(result);
            }
            else
            {
                throw new Exception("Note can't be added");
            }
        }
        catch (Exception e)
        {
            listener.onError(e);
        }
    }

    @Override
    public void noteResponse(String s) {


        try
        {
            JSONObject jsonObject = new JSONObject(s);
            listener.getNoteResponse((new Note(new Date(jsonObject.getLong("created")), new Date(jsonObject.getLong("updated")), jsonObject.getString("note"))));
        }
        catch (Exception e)
        {
            listener.onError(e);
        }
    }

    @Override
    public void removeResponse(String s) {
        boolean b = new Boolean(s);
        listener.removeNoteResponse(b);
    }

    @Override
    public void updateResponse(String s) {
        boolean b = new Boolean(s);
        listener.updateResponse(b);
    }

    @Override
    public void error(Exception e) {
        listener.onError(e);
    }

    @Override
    public void getNotes() {
        requestSender.getNotes();
    }

    @Override
    public void getNote(int id) {
        requestSender.getNote(id);
    }

    @Override
    public void addNote(String note) {
        requestSender.addNote(note);
    }

    @Override
    public void updateNote(int id, String s) {
        requestSender.updateNote(id, s);
    }

    @Override
    public void removeNote(int id) {
        requestSender.deleteNote(id);
    }

    @Override
    public void clearAll() {
        requestSender.deleteAll();
    }
}
