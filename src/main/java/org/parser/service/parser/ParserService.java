package org.parser.service.parser;

import org.jsoup.nodes.Document;

import java.util.Deque;

public interface ParserService {

    Deque<String> getActualText(Document document);
}
