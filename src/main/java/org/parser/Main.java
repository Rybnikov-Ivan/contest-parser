package org.parser;

import org.parser.service.connection.ConnectionService;
import org.parser.service.connection.ConnectionServiceImpl;
import org.parser.service.parser.ParserService;
import org.parser.service.parser.ParserServiceImpl;

public class Main {
    public static void main(String[] args) {
        ConnectionService connectionService = new ConnectionServiceImpl();
        ParserService parserService = new ParserServiceImpl();

        parserService.getActualText(connectionService.getDocumentFromHTML("https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/"));
    }
}