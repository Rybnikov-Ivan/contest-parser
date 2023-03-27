package org.parser.service.parser;

import com.mashape.unirest.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.parser.utils.tags.Yandex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public Deque<String> getActualText(HttpResponse<String> response) {
        Deque<String> deque = new ArrayDeque<>();
        List<String> classes = Yandex.getClasses();
        Document doc = Jsoup.parseBodyFragment(response.getBody());

        for (String aClass : classes) {
            Elements elementsByClass = doc.getElementsByClass(aClass);
            for (Element byClass : elementsByClass) {
                deque.addLast(byClass.text());
            }
        }

        return deque;
    }
}
