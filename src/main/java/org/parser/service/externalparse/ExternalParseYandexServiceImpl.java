package org.parser.service.externalparse;

import com.mashape.unirest.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ExternalParseYandexServiceImpl implements ExternalParseService{
    @Override
    public Document getBodyResponse(HttpResponse<String> response) {

        return Jsoup.parseBodyFragment(response.getBody());
    }
}
