package org.parser.service.parser;

import com.mashape.unirest.http.HttpResponse;
import org.jsoup.nodes.Document;


import java.util.Deque;

public interface ParserService {

    Deque<String> getActualText(HttpResponse<String> document);
}
