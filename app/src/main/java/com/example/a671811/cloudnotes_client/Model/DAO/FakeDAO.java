package com.example.a671811.cloudnotes_client.Model.DAO;

import com.example.a671811.cloudnotes_client.Entity.Note;

import java.util.ArrayList;

/**
 * Created by A671811 on 2017-07-24.
 */

public class FakeDAO {
    ArrayList<Note> notes;

    public FakeDAO() {
        notes = new ArrayList<Note>();
        notes.add(new Note("aaaaaaaaaaaaaa"));
        notes.add(new Note("bbbbbbbb"));
        notes.add(new Note("a345aaaaaaaaadr43r43f43f43rf4erf23e32raaaa"));
    }

    public ArrayList<Note> getNotes()
    {
        return notes;
    }

    public Note getNote(int id)
    {
        if(notes.size()>id&&id>=0)
            return notes.get(id);
        else return null;
    }

    public int addNote(String note)
    {
        notes.add(new Note(note));
        return notes.size()-1;
    }

    public boolean removeNote(int id)
    {
        if(notes.size()>id&&id>=0)
        {
            notes.remove(id);
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean updateNote(int id, String noteText) {
        if(notes.size()>id&&id>=0)
        {
            notes.get(id).update(noteText);
            return true;
        }
        else
        {
            return false;
        }

    }

    public void deleteAll() {
        notes.clear();
    }

    public int size() {
        return notes.size();
    }
}

