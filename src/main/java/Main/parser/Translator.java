package Main.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Translator {
    private static Document document(String page) throws IOException {
        return Jsoup.connect(page).ignoreContentType(true)
                .userAgent("Mozilla / 5.0 (Windows NT 10.0; Win64; x64) AppleWebKit /537.36 (KHTML, like Gecko)" +
                        " Chrome / 100.0.0.0 Safari / 537.36").referrer("http://www.google.com").get();
    }

    public static String translate(String word) {
        if (word != null) {
            try {
                String url = "https://www.translate.ru/перевод/английский-русский/" +
                        word.replaceAll("/[^A-z\\s'-']/", "");
                Elements elements = document(url).getElementsByClass("result_only sayWord");
                List<String> results = elements.stream().map(Element::ownText).toList();
                String result = results.size() != 0 ? results.get(0) : "";
                if (!result.isEmpty()) {
                    return result;
                }
            } catch (Exception e) {
                return word;
            }
        }
        return "";
    }

}
