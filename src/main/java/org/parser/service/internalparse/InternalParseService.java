package org.parser.service.internalparse;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Deque;

public interface InternalParseService {

    Deque<String> getFullTextFromDocument(Document doc);
    Deque<String> getParseCondition(Deque<String> deque, Element element);
    Deque<String> getParseLegend(Deque<String> deque, Elements elements);
    Deque<String> getParseSpecification(Deque<String> deque, Elements elements);
    Deque<String> getParseTests(Deque<String> deque, Elements elements);
}
