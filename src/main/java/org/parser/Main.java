package org.parser;

import org.parser.model.ContestSiteName;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContestFacade facade = new ContestFacade(ContestSiteName.YANDEX, "https://contest.yandex.ru/contest/27393/problems/E/");

    }

    private static String getUrlFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}