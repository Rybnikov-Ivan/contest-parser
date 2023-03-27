package org.parser.utils.tags;

import java.util.ArrayList;
import java.util.List;

public class Yandex {
    public final static String TITLE = "title";
    public final static String TIME_LIMIT = "time-limit";
    public final static String MEMORY_LIMIT = "memory-limit";
    public final static String INPUT_FILE = "input-file";
    public final static String OUTPUT_FILE = "output-file";
    public final static String LEGEND = "legend";
    public final static String INPUT_SPECIFICATION = "input-specification";
    public final static String OUTPUT_SPECIFICATION = "output-specification";
    public final static String SAMPLE_TEST = "sample-tests";
    public final static String NOTES = "notes";

    public static List<String> getClasses() {
        List<String> classes = new ArrayList<>();
        classes.add(TITLE);
        classes.add(TIME_LIMIT);
        classes.add(MEMORY_LIMIT);
        classes.add(INPUT_FILE);
        classes.add(OUTPUT_FILE);
        classes.add(LEGEND);
        classes.add(INPUT_SPECIFICATION);
        classes.add(OUTPUT_SPECIFICATION);
        classes.add(SAMPLE_TEST);
        classes.add(NOTES);

        return classes;
    }

}
