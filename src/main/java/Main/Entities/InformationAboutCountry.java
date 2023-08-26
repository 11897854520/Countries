package Main.Entities;

import java.util.List;


public abstract class InformationAboutCountry {

    String citiesEnum(String lang, List<City> cities) {
        final String[] result = {""};
        if (cities != null) {
            cities.forEach(city -> result[0] = result[0].concat("<li>"
                    + "<a href = 'https://en.wikipedia.org/wiki/"
                    + city.getName() + "'>" + city.getName() + "</a>" + "</li>"));
        }
        return !result[0].isEmpty() ? "<ul class = 'towns'>" + result[0] + "</ul>"
                : (lang == "eng" ? "No information" : "Нет информации");
    }

    String parameter(String s, String lang) {
        if (s != null) {
            return !s.equals("null") && !s.isEmpty()
                    ? s : (lang.equals("eng") ? "No information" : "Нет информации");
        }
        return lang.equals("eng") ? "No information" : "Нет информации";
    }
}
