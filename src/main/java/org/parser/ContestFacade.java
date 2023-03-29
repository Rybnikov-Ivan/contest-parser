package org.parser;

import org.jsoup.nodes.Document;
import org.parser.model.ContestSiteName;
import org.parser.service.connection.ConnectionService;
import org.parser.service.connection.ConnectionYandexContestServiceImpl;
import org.parser.service.externalparse.ExternalParseService;
import org.parser.service.externalparse.ExternalParseYandexServiceImpl;
import org.parser.service.internalparse.InternalParseService;
import org.parser.service.internalparse.InternalParseYandexServiceImpl;

import java.util.Deque;

public class ContestFacade {
    private final String url;

    public ContestFacade(ContestSiteName siteName, String url) {
        this.url = url;
        selectConnection(siteName);
    }

    public void selectConnection(ContestSiteName siteName) {
        ExternalParseService externalParseService = new ExternalParseYandexServiceImpl();
        InternalParseService internalParseService = new InternalParseYandexServiceImpl();
        ConnectionService connectionService;
        if (siteName == ContestSiteName.YANDEX) {
            connectionService = new ConnectionYandexContestServiceImpl();
            Document actualDocumentFromHtml = externalParseService.getBodyResponse(connectionService.getResponseFromServer(url));
            Deque<String> deque = internalParseService.getFullTextFromDocument(actualDocumentFromHtml);
        }
    }
}
