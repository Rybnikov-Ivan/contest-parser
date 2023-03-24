package org.parser.service.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ConnectionServiceImpl implements ConnectionService {
    private final static Logger log = LogManager.getLogger(ConnectionServiceImpl.class);

    @Override
    public Document getDocumentFromHTML(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException ex) {
            log.error("Cannot parse the site: " + url, ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
