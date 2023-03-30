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
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("Accept-Language", "ru,en;q=0.9")
                    .header("Cache-Control", "max-age=0")
                    .header("Connection", "keep-alive")
                    .header("Cookie", "is_gdpr=0; yabs-frequency=/5/0000000000000000/Cu0D6mrbN6-KIYFT_4lBOD0FPvHA8qFughr34BPvbqhy____rv3nU6rbAa6KIY7Rhd4u2UHwHfHAfm00/; yandexuid=9549387331674792958; yuidss=9549387331674792958; ymex=1990152959.yrts.1674792959#1990152959.yrtsi.1674792959; _ym_uid=1674792960592612356; is_gdpr_b=CMjpUhCXowEoAg==; yandex_login=yvanrybnikov; gdpr=0; font_loaded=YSv1; L=ZX0Gf1hUYXZMSQN+eVh1fHAEcnhACFVzKANXJyoyECgiKQBG.1676273416.15252.321191.71a7ed15ded42b444fe1938a891b9d84; spravka=dD0xNjQ2MTIxMjU4O2k9MTk0LjMzLjIwLjg7RD0wMjk5MzBDQjc4QUQ0MEE5NjMwMjYzQ0IyMkIzMDdERDU1NjQxRkJDRERCQzE0NjZFQjNBNjZBOUY4ODI7dT0xNjQ2MTIxMjU4ODUyNjM5OTk5O2g9Mjk1MzllNzlmMGE1Y2ViNjFjMGY3ZDhkNDYzNDJlZGE=; i=6fo9/MGmq89TG/b/1vYD5c+68zUj2Nxj8OSyJE9i0ZTRVZuBq4Fo2XxUo9b0X+waSGVJ23r2IL/WCO9AvqiTfDiKmbM=; yandex_gid=51; Contest_update_user_info=1; sae=0:4843521A-4F9C-4A18-BD22-838B43BE0183:p:23.3.0.2246:w:d:RU:20230127; _ym_isad=2; Session_id=3:1680150693.5.0.1674792992040:CBQhwg:2e.1.2:1|974789053.1480424.2.2:1480424.3:1676273416|3:10267667.674451.PwIoUelfMXBe-i2ZfYvXhRG-5wQ; sessionid2=3:1680150693.5.0.1674792992040:CBQhwg:2e.1.2:1|974789053.1480424.2.2:1480424.3:1676273416|3:10267667.674451.fakesign0000000000000000000; cycada=Ca/Set0DNLuYc4XRoz4n0BotNr4sIi7rTJTDHWwCqcE=; ys=svt.1#def_bro.1#wprid.1680161119190416-2097670774987932835-vla1-3708-vla-l7-balancer-8080-BAL-6321#ybzcc.ru#newsca.native_cache; yp=1680235859.uc.ru#1680235859.duc.ru#1706329013.cld.2270452#1706329013.brd.6301000000#1995527515.pcs.0#1991633416.udn.cDp5dmFucnlibmlrb3Y%3D#1709206468.stltp.serp_bk-map_1_1677670468#1681975683.ygu.1#1680177030.gpauto.53_195877:50_100201:100000:3:1680169830#1680673656.mcv.0#1680673656.mcl.1k5jspl#1680673656.szm.1:1920x1080:1872x964#1682759626.hdrc.1; CONTEST_LANG=ru; _ym_d=1680170263; _yasc=cviIU9bo59zTlrlttZGZ7tYNwM5+r3LjIFSgwYalz5JNB0137YEhFpd4he9nkUGouDs0RKzQ9bYGcODyOw==; Cookie_check=HBx7ERSU; Session_id=3:1680167480.5.0.1674792992040:CBQhwg:2e.1.2:1|974789053.1480424.2.2:1480424.3:1676273416|3:10267677.591839.nMcgG2FYnsGpvY2C4PEfes_JJ5g; _yasc=AYL1nNO5+NnesxAfbX9vWTy9XarIw0lfb1zX5FpmDuH0aVd6ZrbntqyH5T9NxtimCJZfr8ifFbPLBhhcjw==; sessionid2=3:1680167480.5.0.1674792992040:CBQhwg:2e.1.2:1|974789053.1480424.2.2:1480424.3:1676273416|3:10267677.591839.fakesign0000000000000000000; yandex_login=yvanrybnikov")
                    .header("Sec-Fetch-Dest", "document")
                    .header("Sec-Fetch-Mode", "navigate")
                    .header("Sec-Fetch-Site", "cross-site")
                    .header("Sec-Fetch-User", "?1")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 YaBrowser/23.3.0.2246 Yowser/2.5 Safari/537.36")
                    .header("sec-ch-ua", "\"Chromium\";v=\"110\", \"Not A(Brand\";v=\"24\", \"Yandex\";v=\"23\"")
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
