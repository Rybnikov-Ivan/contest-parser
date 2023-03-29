package org.parser.service.convert;

import java.util.Deque;

public interface ConvertService {
    Deque<String> convertToMDMarkdownText(Deque<String> deque);
}
