package org.parser.utils.tags;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeTags {

    public final static String NAME_TASK = "mr-2";

    public final static String DESCRIPTION = "p";

    public final static String CONSTRAINTS = "ul";

    public final static String TOPICS = "mt-2";

    public static List<String> getTags() {
        List<String> list = new ArrayList<>();
        list.add(NAME_TASK);
        list.add(DESCRIPTION);
        list.add(CONSTRAINTS);
        list.add(TOPICS);
        return list;
    }
}
