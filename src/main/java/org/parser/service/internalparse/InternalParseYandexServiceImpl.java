package org.parser.service.internalparse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Safelist;
import org.jsoup.select.Elements;
import org.parser.utils.constants.yandex.YandexClasses;
import org.parser.utils.constants.yandex.YandexIntervals;
import org.parser.utils.constants.yandex.YandexTags;

import java.util.*;

public class InternalParseYandexServiceImpl implements InternalParseService {
    private final static List<String> classes = YandexClasses.getClasses();
    private final static Map<String, String> tags = YandexTags.getTags();
    private final static Deque<Integer> intervals = YandexIntervals.getIntervals();
    @Override
    public Deque<String> getFullTextFromDocument(Document doc) {
        Deque<String> deque = new ArrayDeque<>();

        for (String yClass : classes.subList(Objects.requireNonNull(intervals.removeFirst()), Objects.requireNonNull(intervals.removeFirst()))) {
            Elements elements = doc.getElementsByClass(yClass);
            for (Element element : elements) {
                getParseCondition(deque, element);
            }
        }
        deque.addLast("\n");

        for (String yClass : classes.subList(Objects.requireNonNull(intervals.removeFirst()), Objects.requireNonNull(intervals.removeFirst()))) {
            Element element = doc.select("div." + yClass).first();
            getParseLegend(deque, Objects.requireNonNull(element).children());
        }
        deque.addLast("\n");

        for (String yClass : classes.subList(Objects.requireNonNull(intervals.removeFirst()), Objects.requireNonNull(intervals.removeFirst()))) {
            Element element = doc.select("div." + yClass).select("span").first();
            getParseSpecification(deque, Objects.requireNonNull(element).children());
        }
        deque.addLast("\n");

        for (String yClass : classes.subList(Objects.requireNonNull(intervals.removeFirst()), Objects.requireNonNull(intervals.removeFirst()))) {
            Element element = doc.select("table." + yClass).first();
            getParseTests(deque, Objects.requireNonNull(element).children());
        }
        return deque;
    }

    @Override
    public Deque<String> getParseCondition(Deque<String> deque, Element element) {
        deque.addLast("   " + element.text());
        return deque;
    }

    @Override
    public Deque<String> getParseLegend(Deque<String> deque, Elements elements) {
        for (int i = 0; i < elements.size(); i++) {
            Element element;
            if (i == 0) {
                element = elements.get(i).select("span").select("p").first();
            } else {
                element = elements.get(i);
            }
            String paragraph = Objects.requireNonNull(element).outerHtml();

            for (String tag : tags.keySet()) {
                paragraph = paragraph.replaceAll(tag, tags.get(tag));
            }

            paragraph = Jsoup.clean(paragraph, Safelist.none());
            deque.addLast(paragraph);
        }
        return deque;
    }

    @Override
    public Deque<String> getParseSpecification(Deque<String> deque, Elements elements) {
        for (Element element : elements) {
            String paragraph = Objects.requireNonNull(element).outerHtml();

            for (String tag : tags.keySet()) {
                paragraph = paragraph.replaceAll(tag, tags.get(tag));
            }

            paragraph = Jsoup.clean(paragraph, Safelist.none());
            deque.addLast(paragraph);
        }
        return deque;
    }

    @Override
    public Deque<String> getParseTests(Deque<String> deque, Elements elements) {

        return deque;
    }
}
