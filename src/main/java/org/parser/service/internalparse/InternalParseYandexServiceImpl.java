package org.parser.service.internalparse;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.parser.utils.constants.yandex.YandexClasses;

import java.util.*;

public class InternalParseYandexServiceImpl implements InternalParseService {
    private final static List<String> classes = YandexClasses.getClasses();

    @Override
    public Deque<Map<String, String>> getFullTextFromDocument(Document doc) {
        Deque<Map<String, String>> deque = new ArrayDeque<>();
        for (String yClass : classes) {
            switch (yClass) {
                case "title":
                    processParseTitle(deque, doc, yClass);
                    break;
                case "time-limit":
                case "memory-limit":
                case "input-file":
                case "output-file":
                    processParseCondition(deque, doc, yClass);
                    break;
                case "legend":
                    processParseLegend(deque, doc, yClass);
                    break;
                case "input-specification":
                case "output-specification":
                    processParseSpecification(deque, doc, yClass);
                    break;
                case "sample-tests":
                    processParseTests(deque, doc, yClass);
                    break;
                case "notes":
                    processParseNotes(deque, doc, yClass);
                    break;
            }
        }

        return deque;
    }
    @Override
    public Deque<Map<String, String>> getParseTitle(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.selectFirst(title);
        Map<String, String> map = new HashMap<>();
        map.put(title, Objects.requireNonNull(element).outerHtml());
        deque.addLast(map);
        return deque;
    }
    private void processParseTitle(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.getElementsByClass(title).first();
        Map<String, String> map = new HashMap<>();
        map.put(title, Objects.requireNonNull(element).outerHtml());
        deque.addLast(map);
    }
    @Override
    public Deque<Map<String, String>> getParseCondition(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.selectFirst(title);
        Map<String, String> map = new HashMap<>();
        map.put(title, Objects.requireNonNull(element).outerHtml());
        deque.addLast(map);
        return deque;
    }
    private void processParseCondition(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.getElementsByClass(title).first();
        Map<String, String> map = new HashMap<>();
        map.put(title, Objects.requireNonNull(element).outerHtml());
        deque.addLast(map);
    }
    @Override
    public Deque<Map<String, String>> getParseLegend(Deque<Map<String, String>> deque, Document doc, String title) {
        Elements elements = Objects.requireNonNull(doc.select("div." + title).first()).children();
        for (int i = 0; i < Objects.requireNonNull(elements).size(); i++) {
            Element element;
            if (i == 0) {
                element = elements.get(i).select("span").select("p").first();
            } else {
                element = elements.get(i);
            }

            Map<String, String> map = new HashMap<>();
            map.put(title, Objects.requireNonNull(element).outerHtml());
            deque.addLast(map);
        }
        return deque;
    }
    private void processParseLegend(Deque<Map<String, String>> deque, Document doc, String title) {
        Elements elements = Objects.requireNonNull(doc.select("div." + title).first()).children();
        for (int i = 0; i < Objects.requireNonNull(elements).size(); i++) {
            Element element;
            if (i == 0) {
                element = elements.get(i).select("span").select("p").first();
            } else {
                element = elements.get(i);
            }

            Map<String, String> map = new HashMap<>();
            map.put(title, Objects.requireNonNull(element).outerHtml());
            deque.addLast(map);
        }
    }
    @Override
    public Deque<Map<String, String>> getParseSpecification(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.select("div." + title).select("span").first();
        Map<String, String> map = new HashMap<>();
        map.put(title, Objects.requireNonNull(element).outerHtml());
        deque.addLast(map);
        return deque;
    }
    private void processParseSpecification(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.select("div." + title).select("span").first();
        Map<String, String> map = new HashMap<>();
        map.put(title, Objects.requireNonNull(element).outerHtml());
        deque.addLast(map);
    }
    @Override
    public Deque<Map<String, String>> getParseTests(Deque<Map<String, String>> deque, Document doc, String title) {
        Elements elements = doc.select("table." + title);
        for (Element element : elements) {
            Map<String, String> map = new HashMap<>();
            map.put(title, Objects.requireNonNull(element).outerHtml());
            deque.addLast(map);
        }
        return deque;
    }
    private void processParseTests(Deque<Map<String, String>> deque, Document doc, String title) {
        Elements elements = doc.select("table." + title);
        for (Element element : elements) {
            Map<String, String> map = new HashMap<>();
            map.put(title, Objects.requireNonNull(element).outerHtml());
            deque.addLast(map);
        }
    }
    @Override
    public Deque<Map<String, String>> getParseNotes(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.select("div." + title).first();
        if (element != null) {
            Map<String, String> map = new HashMap<>();
            map.put(title, Objects.requireNonNull(element).outerHtml());
            deque.addLast(map);
            return deque;
        }
        return null;
    }
    private void processParseNotes(Deque<Map<String, String>> deque, Document doc, String title) {
        Element element = doc.select("div." + title).first();
        if (element != null) {
            Map<String, String> map = new HashMap<>();
            map.put(title, Objects.requireNonNull(element).outerHtml());
            deque.addLast(map);
        } else {
            deque.addLast(null);
        }
    }
}
