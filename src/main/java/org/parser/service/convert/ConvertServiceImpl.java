package org.parser.service.convert;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.parser.utils.constants.yandex.YandexTags;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ConvertServiceImpl implements ConvertService {
    private final static Map<String, String> tagsAndReplacement = YandexTags.getTags();
    @Override
    public Deque<String> convertToMDMarkdownText(Deque<String> deque) {
        Deque<String> markdownText = new ArrayDeque<>();
        for (String line : deque) {
            for (String tag : tagsAndReplacement.keySet()) {
                line = line.replaceAll(tag, tagsAndReplacement.get(tag));
            }
            line = Jsoup.clean(line, Safelist.none());
            markdownText.add(line);
        }

        return markdownText;
    }
}
