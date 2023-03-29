package org.parser.utils.constants.yandex;

import java.util.ArrayDeque;
import java.util.Deque;

public class YandexIntervals {
    private static final int START_CONDITION = 0;
    private static final int END_CONDITION = 5;
    private static final int START_LEGEND = 5;
    private static final int END_LEGEND = 6;
    private static final int START_SPECIFICATION = 6;
    private static final int END_SPECIFICATION = 8;
    private static final int START_SAMPLE_TESTS = 8;
    private static final int END_SAMPLE_TESTS = 9;
    private static final int START_NOTES = 9;
    private static final int END_NOTES = YandexClasses.getClasses().size();

    public static Deque<Integer> getIntervals() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(START_CONDITION);
        queue.add(END_CONDITION);
        queue.add(START_LEGEND);
        queue.add(END_LEGEND);
        queue.add(START_SPECIFICATION);
        queue.add(END_SPECIFICATION);
        queue.add(START_SAMPLE_TESTS);
        queue.add(END_SAMPLE_TESTS);
        queue.add(START_NOTES);
        queue.add(END_NOTES);

        return queue;
    }
}
