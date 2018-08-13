package sample.Logics;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KinopoiskParserListYears {
    public ArrayList<String> listFilms = new ArrayList<>();

    public void start(String url) {
        Document doc = null;
        try {
/*            //set HTTP proxy host to 127.0.0.1 (localhost)
            System.setProperty("http.proxyHost", "127.0.0.1");

            //set HTTP proxy port to 3128
            System.setProperty("http.proxyPort", "8081");*/

            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements divs = doc.select("div[class=name]");

        for (Element element: divs) {
            Elements elementsFilm = element.getElementsByTag("a");
            listFilms.add("https://www.kinopoisk.ru" + elementsFilm.attr("href"));
            System.out.println(listFilms.get(listFilms.size()-1));
        }

    }
}
