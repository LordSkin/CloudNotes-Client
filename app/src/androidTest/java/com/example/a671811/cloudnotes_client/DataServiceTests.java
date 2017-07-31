package com.example.a671811.cloudnotes_client;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.example.a671811.cloudnotes_client.Activities.MainActivity;
import com.example.a671811.cloudnotes_client.Entity.Note;
import com.example.a671811.cloudnotes_client.Model.DAO.NotesResponseListener;
import com.example.a671811.cloudnotes_client.Model.DAO.RestServer.DataService;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by A671811 on 2017-07-31.
 */

public class DataServiceTests {

    ActivityTestRule activityTestRule;
    public static String IP_ADDRESS;

    public DataServiceTests() {
        activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class, true);
        activityTestRule.launchActivity(new Intent());
        IP_ADDRESS = "http:\\\\10.0.2.2:8080/notes";
    }

    @Test
    public void wrongAddressTest()
    {
        DataService ds = new DataService(new NotesResponseListener() {
            @Override
            public void getNotesResponse(ArrayList<Note> notes) {

            }

            @Override
            public void getNoteResponse(Note note) {

            }

            @Override
            public void addNoteResponse(int id) {
                Assert.fail();
            }

            @Override
            public void removeNoteResponse(boolean b) {

            }

            @Override
            public void updateResponse(boolean ok) {

            }

            @Override
            public void onError(Exception e) {
                Assert.assertEquals(true,true);
            }
        }, activityTestRule.getActivity(), "");//ip address is wrong
        ds.addNote("aaaaaaaa");
    }

    @Test
    public void addTest()
    {
        DataService ds = new DataService(new NotesResponseListener() {
            @Override
            public void getNotesResponse(ArrayList<Note> notes) {

            }

            @Override
            public void getNoteResponse(Note note) {

            }

            @Override
            public void addNoteResponse(int id) {
            }

            @Override
            public void removeNoteResponse(boolean b) {

            }

            @Override
            public void updateResponse(boolean ok) {

            }

            @Override
            public void onError(Exception e) {
                Assert.fail(e.toString());
            }
        }, activityTestRule.getActivity(), IP_ADDRESS);
        ds.addNote("aaaaa");
        ds.getNotes();
    }


    @Test
    public void removeTest()
    {
        DataService ds = new DataService(new NotesResponseListener() {
            @Override
            public void getNotesResponse(ArrayList<Note> notes) {

            }

            @Override
            public void getNoteResponse(Note note) {

            }

            @Override
            public void addNoteResponse(int id) {

            }

            @Override
            public void removeNoteResponse(boolean b) {
                Assert.fail();
            }

            @Override
            public void updateResponse(boolean ok) {

            }

            @Override
            public void onError(Exception e) {

            }
        }, activityTestRule.getActivity(), IP_ADDRESS);
        ds.removeNote(-1);
    }

    @Test
    public void listTest()
    {
        DataService ds = new DataService(new NotesResponseListener() {
            @Override
            public void getNotesResponse(ArrayList<Note> notes) {

            }

            @Override
            public void getNoteResponse(Note note) {

            }

            @Override
            public void addNoteResponse(int id) {

            }

            @Override
            public void removeNoteResponse(boolean b) {

            }

            @Override
            public void updateResponse(boolean ok) {

            }

            @Override
            public void onError(Exception e) {
                Assert.fail();
            }
        }, activityTestRule.getActivity(), IP_ADDRESS);
        ds.getNotes();
    }

    @Test
    public void updateTest()
    {
        DataService ds = new DataService(new NotesResponseListener() {
            @Override
            public void getNotesResponse(ArrayList<Note> notes) {

            }

            @Override
            public void getNoteResponse(Note note) {

            }

            @Override
            public void addNoteResponse(int id) {

            }

            @Override
            public void removeNoteResponse(boolean b) {

            }

            @Override
            public void updateResponse(boolean ok) {
                Assert.fail();
            }

            @Override
            public void onError(Exception e) {

            }
        }, activityTestRule.getActivity(), IP_ADDRESS);
        ds.updateNote(-1, "asd");
    }

}
