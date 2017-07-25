package com.example.a671811.cloudnotes_client.Model.DAO.RestServer;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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

    public void test()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String s = "Response is: "+ response.substring(0,500);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String s = "That didn't work!";
            }
        });
// Add the request to the
    }
}
