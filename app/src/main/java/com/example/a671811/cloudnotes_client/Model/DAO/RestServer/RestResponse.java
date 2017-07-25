package com.example.a671811.cloudnotes_client.Model.DAO.RestServer;

/**
 * Created by A671811 on 2017-07-25.
 */

public interface RestResponse {

    void notesListResponse(String s);

    void noteResponse(String s);

    void removeResponse(String s);

    void updateResponse(String s);

    void clearAllResponse(String s);
}
