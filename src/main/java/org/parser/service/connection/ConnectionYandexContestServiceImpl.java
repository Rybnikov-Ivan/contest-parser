package org.parser.service.connection;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionYandexContestServiceImpl implements ConnectionService {
    private final static Logger log = LogManager.getLogger(ConnectionYandexContestServiceImpl.class);

    @Override
    public HttpResponse<String> getResponseFromServer(String url) {
        Map<String, String> map = getProperties();
        if (map.size() == 0) return null;

        HttpResponse<String> response = null;
        try {
            response = Unirest.get(url)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header("Accept-Language", "ru,en;q=0.9")
                    .header("Cache-Control", "max-age=0")
                    .header("Connection", "keep-alive")
                    .header("Cookie", "is_gdpr=0; yabs-frequency=/5/0000000000000000/Cu0D6mrbN6-KIYFT_4lBOD0FPvHA8qFughr34BPvbqhy____rv3nU6rbAa6KIY7Rhd4u2UHwHfHAfm00/; " +
                            "yandexuid=" + map.get("login") + "; yuidss=" + map.get("login") + "; ymex=1990152959.yrts.1674792959#1990152959.yrtsi.1674792959; _ym_uid=1674792960592612356; " +
                            "is_gdpr_b=CMjpUhCXowEoAg==; yandex_login=" + map.get("uuid") + "; gdpr=0; font_loaded=YSv1; " +
                            "L=ZX0Gf1hUYXZMSQN+eVh1fHAEcnhACFVzKANXJyoyECgiKQBG.1676273416.15252.321191.71a7ed15ded42b444fe1938a891b9d84; " +
                            "spravka=dD0xNjQ2MTIxMjU4O2k9MTk0LjMzLjIwLjg7RD0wMjk5MzBDQjc4QUQ0MEE5NjMwMjYzQ0IyMkIzMDdERDU1NjQxRkJDRERCQzE0NjZFQjNBNjZBOUY4ODI7dT0xNjQ2MTIxMjU4ODUyNjM5OTk5O2g9Mjk1MzllNzlmMGE1Y2ViNjFjMGY3ZDhkNDYzNDJlZGE=; " +
                            "i=6fo9/MGmq89TG/b/1vYD5c+68zUj2Nxj8OSyJE9i0ZTRVZuBq4Fo2XxUo9b0X+waSGVJ23r2IL/WCO9AvqiTfDiKmbM=; yandex_gid=51; sae=0:4843521A-4F9C-4A18-BD22-838B43BE0183:p:23.1.5.708:w:d:RU:20230127; " +
                            "Session_id=3:1679890186.5.0.1674792992040:CBQhwg:2e.1.2:1|974789053.1480424.2.2:1480424.3:1676273416|3:10267521.18033.K3hOVQY0O2p1Bcz64L9d4a_akVQ; " +
                            "sessionid2=3:1679890186.5.0.1674792992040:CBQhwg:2e.1.2:1|974789053.1480424.2.2:1480424.3:1676273416|3:10267521.18033.fakesign0000000000000000000; _ym_isad=2; " +
                            "_ym_d=1679892232; cycada=qRdgkoZ20taO4dZxKBauq/2+C8vVCk4l8SgFjqY1uXY=; _ym_visorc=w; CONTEST_LANG=ru; Contest_update_user_info=1; " +
                            "_yasc=wyMHxFSNb2D6otHoNoZ9rPKL1ntprRAVi1EPzkXpNHu2ByrNf2Stnmc0u2V5EQNGg7nrUWuCPbettvJTGw==; " +
                            "yp=1679976585.uc.ru#1679976585.duc.ru#1706329013.cld.2270452#1706329013.brd.6301000000#1995252530.pcs.0#1991633416.udn.cDp5dmFucnlibmlrb3Y%3D#1709206468.stltp.serp_bk-map_1_1677670468#1681975683.ygu.1#1680064747.mcv.0#1680064747.mcl.1k5jspl#1680064747.szm.1:1920x1080:1872x964#1680089537.mct.null#1679899781.gpauto.53_195877:50_100201:100000:3:1679892581; " +
                            "ys=svt.1#def_bro.1#wprid.1679892266143044-2588279600413068563-sas2-0594-sas-l7-balancer-8080-BAL-2041#ybzcc.ru#newsca.native_cache; _yasc=7caXLEfsdcAXYcvkD3QfQlRkUJ3BmLAEhsvtLzODsdjwM3XwYHk+K/MJFeZLbjua0eZQVwvp7UL4bAjBig==")
                    .header("Referer", url)
                    .header("Sec-Fetch-Dest", "document")
                    .header("Sec-Fetch-Mode", "navigate")
                    .header("Sec-Fetch-Site", "same-origin")
                    .header("Sec-Fetch-User", "?1")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 YaBrowser/23.1.5.708 Yowser/2.5 Safari/537.36")
                    .header("sec-ch-ua", "\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Yandex\";v=\"23\"")
                    .header("sec-ch-ua-mobile", "?0")
                    .header("sec-ch-ua-platform", "\"Windows\"")
                    .asString();

        } catch (UnirestException ex) {
            log.error("Cannot get response");
        }
        return response;
    }

    private Map<String, String> getProperties() {
        Map<String, String> map = new HashMap<>();

        try (FileReader reader = new FileReader("src/main/resources/application.config")){
            Properties properties = new Properties();
            properties.load(reader);

            map.put("login", properties.getProperty("yandex.contest.login"));
            map.put("uuid", properties.getProperty("yandex.contest.uuid"));
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        return map;
    }
}
