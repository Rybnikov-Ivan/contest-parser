package org.parser;

import org.parser.model.TypeContest;
import org.parser.utils.paths.Paths;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "https://contest.yandex.ru/contest/27393/problems/H/";
        ContestFacade facade = new ContestFacade(TypeContest.YANDEX, url, Paths.WORK_DIR);
        Package aPackage = Main.class.getPackage();
    }

    private static String getUrlFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}