package org.parser.service.convert;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.parser.utils.constants.yandex.YandexTags;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ConvertToMDServiceImpl implements ConvertService {
    private final static Map<String, String> tagsAndReplacement = YandexTags.getTags();
    @Override
    public Deque<String> convert(Deque<Map<String, String>> deque) {
        Deque<String> markdownText = new ArrayDeque<>();
        for (Map<String, String> map : deque) {
            String key = map.entrySet().iterator().next().getKey();
            String val = map.get(key);
            if (map.containsKey("span")) {
                markdownText.addLast(map.get("span"));
            } else {
                for (String tag : tagsAndReplacement.keySet()) {
                    val = val.replaceAll(tag, tagsAndReplacement.get(tag));
                }
                val = Jsoup.clean(val, Safelist.none());
                markdownText.addLast(val);
            }
        }
        return markdownText;
    }
}
