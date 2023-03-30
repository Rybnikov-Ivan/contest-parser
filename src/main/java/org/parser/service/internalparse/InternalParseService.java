package org.parser.service.internalparse;

import org.jsoup.nodes.Document;

import java.util.Deque;
import java.util.Map;

public interface InternalParseService {

    Deque<Map<String, String>> getFullTextFromDocument(Document doc);
    Deque<Map<String, String>> getParseTitle(Deque<Map<String, String>> deque, Document doc, String title);
    Deque<Map<String, String>> getParseCondition(Deque<Map<String, String>> deque, Document doc, String title);
    Deque<Map<String, String>> getParseLegend(Deque<Map<String, String>> deque, Document doc, String title);
    Deque<Map<String, String>> getParseSpecification(Deque<Map<String, String>> deque, Document doc, String title);
    Deque<Map<String, String>> getParseTests(Deque<Map<String, String>> deque, Document doc, String title);
    Deque<Map<String, String>> getParseNotes(Deque<Map<String, String>> deque, Document doc, String title);
}
