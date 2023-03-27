package org.parser;

import org.parser.service.connection.ConnectionService;
import org.parser.service.connection.ConnectionYandexContestServiceImpl;

public class Main {
    public static void main(String[] args) {
        ConnectionService connectionService = new ConnectionYandexContestServiceImpl();
        connectionService.getResponseFromServer("https://contest.yandex.ru/contest/27393/problems/D/");

    }
}