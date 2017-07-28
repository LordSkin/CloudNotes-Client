package com.example.a671811.cloudnotes_client.Model.DAO;

import com.example.a671811.cloudnotes_client.Entity.Note;

import java.util.ArrayList;

/**
 * Created by A671811 on 2017-07-24.
 */

public class FakeDAO implements NotesDao {
    ArrayList<Note> notes;
    NotesResponseListener listener;

    public FakeDAO(NotesResponseListener notesResponseListener) {
        notes = new ArrayList<Note>();
        listener = notesResponseListener;
        notes.add(new Note("aaaaaaaaaaaaaa",0));
        notes.add(new Note("bbbbbbbb",1));
        notes.add(new Note("a345aaaaaaaaadr43r43f43f43rf4erf23e32raaaa",2));
    }

    public void  getNotes()
    {
        listener.getNotesResponse(notes);
    }

    public void getNote(int id)
    {
        if(notes.size()>id&&id>=0)
            listener.getNoteResponse(notes.get(id));
        else listener.getNoteResponse(null);
    }

    public void addNote(String note)
    {
        notes.add(new Note(note,0));
        listener.addNoteResponse(notes.size()-1);
    }

    public void removeNote(int id)
    {
        if(notes.size()>id&&id>=0)
        {
            notes.remove(id);
            listener.removeNoteResponse(true);
        }
        else
        {
            listener.removeNoteResponse(false);
        }

    }

    public void updateNote(int id, String noteText) {
        if(notes.size()>id&&id>=0)
        {
            notes.get(id).update(noteText);
           listener.updateResponse(true);
        }
        else
        {
            listener.updateResponse(false);
        }

    }

    public void clearAll() {
        notes.clear();
    }

    @Override
    public void setListener(NotesResponseListener listener) {

    }

    public int size() {
        return notes.size();
    }
}

