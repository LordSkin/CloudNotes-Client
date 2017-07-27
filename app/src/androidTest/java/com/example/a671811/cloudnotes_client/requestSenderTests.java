package com.example.a671811.cloudnotes_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Debug;
import android.support.annotation.IntegerRes;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;

import com.example.a671811.cloudnotes_client.Activities.MainActivity;
import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.Model.DAO.RestServer.RequestSender;
import com.example.a671811.cloudnotes_client.Model.DAO.RestServer.RestResponse;

import junit.framework.Assert;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by A671811 on 2017-07-26.
 */

public class requestSenderTests  {



    RequestSender requestSender;
    final String url = "http:\\\\10.0.2.2:8080/notes";
    ActivityTestRule<MainActivity> a;

    public requestSenderTests() {
        a = new ActivityTestRule<MainActivity>(MainActivity.class, true);
        a.launchActivity(new Intent());
    }

    @Test
    public void emptyListTest()
    {
        requestSender = new RequestSender(url, a.getActivity(), new RestResponse() {
            @Override
            public void notesListResponse(String s) {
                Assert.assertEquals(s, "[]");
            }

            @Override
            public void addNoteResponse(String s) {

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
            public void error(Exception e) {
                Assert.fail();
            }
        });

        requestSender.deleteAll();
        requestSender.getNotes();
    }

    @Test
    public void addingTest()
    {
        final String testNote = "aaaaaaaaaaaaaaabbbbbbbbbbbbbbbcccccccccccccccc";
        requestSender = new RequestSender(url, a.getActivity(), new RestResponse() {
            @Override
            public void notesListResponse(String s) {
                Assert.assertNotSame(s, "[]");
            }

            @Override
            public void addNoteResponse(String s) {
                int pos = Integer.parseInt(s);
                if(pos<0)Assert.fail();
                else
                {
                    requestSender.getNote(pos);
                }
            }

            @Override
            public void noteResponse(String s) {
                try
                {
                    JSONObject jsonObject = new JSONObject(s);
                    Assert.assertEquals(jsonObject.getString("note"), testNote);
                }
                catch (Exception e)
                {
                    Assert.fail(e.getMessage());
                }


            }

            @Override
            public void removeResponse(String s) {

            }

            @Override
            public void updateResponse(String s) {

            }

            @Override
            public void error(Exception e) {
                Assert.fail();
            }
        });


        requestSender.addNote(testNote);
    }

    @Test
    public void removeTest()
    {
        requestSender = new RequestSender(url, a.getActivity(), new RestResponse() {
            @Override
            public void notesListResponse(String s) {
            }

            @Override
            public void addNoteResponse(String s) {
                int id = Integer.parseInt(s);
                requestSender.deleteNote(id);
            }

            @Override
            public void noteResponse(String s) {

            }

            @Override
            public void removeResponse(String s) {
                Assert.fail(s);
            }

            @Override
            public void updateResponse(String s) {

            }

            @Override
            public void error(Exception e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            }
        });
        requestSender.addNote("aaaaaa");
    }

}
