package com.example.a671811.cloudnotes_client.Model.DAO.RestServer;


import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;

/**
 * Created by A671811 on 2017-07-25.
 */

public class RequestSender {

    String url;
    Context context;
    RequestQueue queue;
    RestResponse listener;

    public RequestSender(String url, Context context, RestResponse listener) {
        this.url = url;
        this.context = context;
        this.listener = listener;
        queue = Volley.newRequestQueue(context);
    }


    public void getNotes()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.notesListResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.error(error);
            }
        });
        queue.add(stringRequest);
    }

    public void getNote(int id)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url+"/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.noteResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.error(error);
            }
        });
        queue.add(stringRequest);
    }

    public void addNote(final String note)
    {
        final String tempNote = new String(note);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.addNoteResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.error(error);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try
                {
                    return tempNote == null ? null : tempNote.getBytes("utf-8");
                }
                catch (Exception e){throw new AuthFailureError();}
            }
        };
        queue.add(stringRequest);
    }

    public void deleteNote(int id)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url+"/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.removeResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.error(error);
            }
        });
        queue.add(stringRequest);
    }

    public void updateNote(int id, String note)
    {
        final String tempNote = new String(note);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url+"/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.updateResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.error(error);
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try
                {
                    return tempNote == null ? null : tempNote.getBytes("utf-8");
                }
                catch (Exception e){throw new AuthFailureError();}
            }
        };
        queue.add(stringRequest);
    }

    public void deleteAll()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {}
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.error(error);
            }
        });
        queue.add(stringRequest);
    }
}
