package org.parser.service.creationfile;

import java.util.Deque;

public interface CreateFileService {
    void create(Deque<String> text, String path);
}
