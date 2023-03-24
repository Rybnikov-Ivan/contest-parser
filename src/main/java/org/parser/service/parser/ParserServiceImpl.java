package org.parser.service.parser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.parser.utils.tags.LeetcodeTags;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public Deque<String> getActualText(Document document) {
        Deque<String> deque = new ArrayDeque<>();
        List<String> tags = LeetcodeTags.getTags();

        for (String tag : tags) {
            String title = document.select("h-full").text();
            Elements elementsByClass = document.getElementsByClass("h-full");
            deque.addLast(String.valueOf(document.getElementsByTag(tag)));
        }
        return deque;
    }
}
