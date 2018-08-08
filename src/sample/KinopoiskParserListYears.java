package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class KinopoiskParserListYears {

    public void start() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.kinopoisk.ru/lists/m_act%5Byear%5D/2016/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements divs = doc.select("div[class=name]");

        for (Element element: divs) {
            Elements elementsFilm = element.getElementsByTag("a");
            System.out.println("https://www.kinopoisk.ru" + elementsFilm.attr("href"));
        }
    }
}
