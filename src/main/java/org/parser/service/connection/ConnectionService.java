package org.parser.service.connection;

import com.mashape.unirest.http.HttpResponse;

public interface ConnectionService {

    HttpResponse<String> getResponseFromServer(String url);
}
