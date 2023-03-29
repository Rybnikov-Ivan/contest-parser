package org.parser.utils.constants.yandex;

import java.util.HashMap;
import java.util.Map;

public class YandexTags {
    private static final String TAG_SPAN = "<span class=\"tex-math-text\">";
    private static final String TAG_SPAN_REPLACE = "\\$";
    private static final String TAG_SPAN_CLOSE = "</span>";
    private static final String TAG_SPAN_CLOSE_REPLACE = "\\$";
    private static final String TAG_SUB = "<sub>";
    private static final String TAG_SUB_REPLACE = "_";
    private static final String TAG_SUP = "<sup>";
    private static final String TAG_SUP_REPLACE = "^";

    public static Map<String, String> getTags() {
        Map<String, String> map = new HashMap<>();
        map.put(TAG_SPAN, TAG_SPAN_REPLACE);
        map.put(TAG_SPAN_CLOSE, TAG_SPAN_CLOSE_REPLACE);
        map.put(TAG_SUB, TAG_SUB_REPLACE);
        map.put(TAG_SUP, TAG_SUP_REPLACE);

        return map;
    }

}
