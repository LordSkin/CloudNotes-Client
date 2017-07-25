package com.example.a671811.cloudnotes_client.Model.DAO.RestServer;

import android.content.Context;
import android.util.JsonReader;

import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by A671811 on 2017-07-25.
 */

public class DataService implements RestResponse {

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
            
        }
        catch (Exception e)
        {
            listener.onError(e);
        }


    }

    @Override
    public void noteResponse(String s) {

    }

    @Override
    public void removeResponse(String s) {

    }

    @Override
    public void updateResponse(String s) {

    }

    @Override
    public void clearAllResponse(String s) {

    }
}
