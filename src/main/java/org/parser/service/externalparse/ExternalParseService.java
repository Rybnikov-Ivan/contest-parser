package org.parser.service.externalparse;

import com.mashape.unirest.http.HttpResponse;
import org.jsoup.nodes.Document;

public interface ExternalParseService {

    Document getBodyResponse(HttpResponse<String> response);
}
