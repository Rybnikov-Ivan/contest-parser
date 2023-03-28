package org.parser.service.parser;

import com.mashape.unirest.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Safelist;
import org.jsoup.select.Elements;
import org.parser.utils.tags.Yandex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class ParserYandexServiceImpl implements ParserService {
    @Override
    public Deque<String> getActualText(HttpResponse<String> response) {
        Deque<String> deque = new ArrayDeque<>();
        List<String> classes = Yandex.getClasses();
        Document doc = Jsoup.parseBodyFragment(response.getBody());

        for (String aClass : classes.subList(0, 5)) {
            Elements elementsByClass = doc.getElementsByClass(aClass);
            for (Element byClass : elementsByClass) {
                processCondition(deque, byClass);
            }
        }
        for (String aClass : classes.subList(5, 6)) {
            Element element = doc.select("div." + aClass).first();
            processLegend(deque, Objects.requireNonNull(element).children());
        }

        return deque;
    }

    private void processCondition(Deque<String> deque, Element byClass) {
        deque.addLast(byClass.text());
    }

    private void processLegend(Deque<String> deque, Elements elementsByClass) {
        Safelist safelist = new Safelist();
        safelist.addAttributes("span","class");
        for (Element element : elementsByClass) {
            String str = Jsoup.clean(element.outerHtml(), safelist);
            System.out.println();
        }
    }

    private void processConclusion(Deque<String> deque, Element byClass) {

    }
}
