package com.example.a671811.cloudnotes_client.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by A671811 on 2017-07-24.
 */

public class NotesAdapter extends BaseAdapter {

    ArrayList<Note> notes;
    Context context;
    LayoutInflater inflater;

    public static final int TITLE_LENGTH = 15;

    public NotesAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public NotesAdapter(Context context) {
        notes = new ArrayList<Note>();
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void update(ArrayList<Note> notes)
    {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public void addNote(Note note)
    {
        notes.add(note);
        notifyDataSetChanged();
    }

    public void removeNote(int position)
    {
        notes.remove(position);
        notifyDataSetChanged();
    }

    public void removeNote(Note position)
    {
        notes.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String title  = (String)(notes.get(position).getNote().subSequence(0,TITLE_LENGTH));

        View v = inflater.inflate(R.layout.note_cell, null);
        ((TextView)v.findViewById(R.id.Row)).setText(title);
        return v;
    }
}
