package com.example.a671811.cloudnotes_client.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a671811.cloudnotes_client.Activities.EditNoteActivity;
import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.R;

import java.util.ArrayList;

/**
 * Created by A671811 on 2017-07-24.
 */

public class NotesAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    ArrayList<Note> notes;
    Context context;
    LayoutInflater inflater;
    String ipAddress;

    public static final int TITLE_LENGTH = 12;

    public NotesAdapter(ArrayList<Note> notes, Context context, String ipAddress) {
        this.notes = notes;
        this.context = context;
        this.ipAddress = ipAddress;
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


        String title  = notes.get(position).getNote();
        if(title.length()>TITLE_LENGTH+1)
        {
            title = title.substring(0,TITLE_LENGTH)+"...";
        }

        View v = inflater.inflate(R.layout.note_cell, null);
        ((TextView)v.findViewById(R.id.Row)).setText(title);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(context, EditNoteActivity.class);
        i.putExtra("Note", notes.get(position));
        i.putExtra("ipAddress", ipAddress);
        context.startActivity(i);
    }
}
