package org.parser.service.connection;

import org.jsoup.nodes.Document;

public interface ConnectionService {

    Document getDocumentFromHTML(String url);
}
