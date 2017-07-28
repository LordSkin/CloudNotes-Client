package com.example.a671811.cloudnotes_client.Model.DAO;

/**
 * Created by A671811 on 2017-07-25.
 */

public interface NotesDao {

    void getNotes();

    void getNote(int id);

    void addNote(String note);

    void updateNote(int id, String s);

    void removeNote(int id);

    void clearAll();

    void setListener(NotesResponseListener listener);
}
