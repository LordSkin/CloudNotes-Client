package com.example.a671811.cloudnotes_client.Entity;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by A671811 on 2017-07-24.
 */

public class Note {

    private Date created;
    private Date updated;
    private String note;

    public Note(Date created, Date updated, String note) {
        this.created = created;
        this.updated = updated;
        this.note = note;
    }

    public Note() {
        created = Calendar.getInstance().getTime();
        updated = Calendar.getInstance().getTime();
    }

    public Note(String note) {
        this.note = note;
        created = Calendar.getInstance().getTime();
        updated = Calendar.getInstance().getTime();
    }

    public String getNote() {
        return note;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void update(String newNote) {
        this.note = note;
        updated = Calendar.getInstance().getTime();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Note))
        {
            return false;
        }
        else
        {
            Note n = (Note)obj;
            return(this.created.equals(n.created)&&this.updated.equals(n.updated)&&this.note.equals(n.note));
        }
    }

    @Override
    public String toString() {
        return "Utworzona:"+this.created+", edytowana:"+updated+", tresc:"+note;
    }
}
