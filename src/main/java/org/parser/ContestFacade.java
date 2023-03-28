package org.parser;

import org.parser.model.ContestSiteName;
import org.parser.service.connection.ConnectionService;
import org.parser.service.connection.ConnectionYandexContestServiceImpl;
import org.parser.service.parser.ParserService;
import org.parser.service.parser.ParserYandexServiceImpl;

public class ContestFacade {
    private final ContestSiteName siteName;
    private final String url;

    public ContestFacade(ContestSiteName siteName, String url) {
        this.siteName = siteName;
        this.url = url;
        selectConnection(this.siteName);
    }

    public void selectConnection(ContestSiteName siteName) {
        ParserService parserService = new ParserYandexServiceImpl();
        ConnectionService connectionService;
        if (siteName == ContestSiteName.YANDEX) {
            connectionService = new ConnectionYandexContestServiceImpl();
            parserService.getActualText(connectionService.getResponseFromServer(url));
        }
    }
}
