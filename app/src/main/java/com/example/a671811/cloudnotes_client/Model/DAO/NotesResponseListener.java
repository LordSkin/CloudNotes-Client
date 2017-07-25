package com.example.a671811.cloudnotes_client.Model.DAO;

import com.example.a671811.cloudnotes_client.Entity.Note;

import java.util.ArrayList;

/**
 * Created by A671811 on 2017-07-25.
 */

public interface NotesResponseListener {

    void getNotesResponse(ArrayList<Note> notes);

    void getNoteResponse(Note note);

    void addNoteResponse(int id);

    void removeNoteResponse(boolean b);

    void clearAllResponse();

    void updateResponse(boolean ok);

    void onError(Exception e);
}
