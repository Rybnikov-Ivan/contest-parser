package org.parser;

import org.jsoup.nodes.Document;
import org.parser.model.TypeContest;
import org.parser.service.connection.ConnectionService;
import org.parser.service.connection.ConnectionYandexContestServiceImpl;
import org.parser.service.convert.ConvertService;
import org.parser.service.convert.ConvertToMDServiceImpl;
import org.parser.service.externalparse.ExternalParseService;
import org.parser.service.externalparse.ExternalParseYandexServiceImpl;
import org.parser.service.internalparse.InternalParseService;
import org.parser.service.internalparse.InternalParseYandexServiceImpl;

import java.util.Deque;
import java.util.Map;

public class ContestFacade {
    private final String url;

    public ContestFacade(TypeContest siteName, String url, String path) {
        this.url = url;
        selectConnection(siteName);
    }

    public void selectConnection(TypeContest siteName) {
        ExternalParseService externalParseService = new ExternalParseYandexServiceImpl();
        InternalParseService internalParseService = new InternalParseYandexServiceImpl();
        ConvertService convertService = new ConvertToMDServiceImpl();
        ConnectionService connectionService;
        if (siteName == TypeContest.YANDEX) {
            connectionService = new ConnectionYandexContestServiceImpl();
            Document actualDocumentFromHtml = externalParseService.getBodyResponse(connectionService.getResponseFromServer(url));
            Deque<Map<String, String>> deq = internalParseService.getFullTextFromDocument(actualDocumentFromHtml);
            Deque<String> d = convertService.convert(deq);
        }
    }
}
