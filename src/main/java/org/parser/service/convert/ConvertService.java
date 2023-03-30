package org.parser.service.convert;

import java.util.Deque;
import java.util.Map;

public interface ConvertService {
    Deque<String> convert(Deque<Map<String, String>> deque);
}
