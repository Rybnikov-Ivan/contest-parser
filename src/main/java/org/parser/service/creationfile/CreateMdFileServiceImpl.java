package org.parser.service.creationfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;

public class CreateMdFileServiceImpl implements CreateFileService {
    @Override
    public void create(Deque<String> text, String path) {
        String fullPath = path + "README.md";
        File file = new File(fullPath);
        try {
            FileWriter myWriter = new FileWriter(file);
            int size = text.size();
            for (int i = 0; i < size; i++) {
                text.removeFirst();
            }
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
