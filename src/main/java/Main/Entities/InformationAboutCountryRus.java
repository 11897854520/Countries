package Main.Entities;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class InformationAboutCountryRus extends InformationAboutCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "country_name")
    private final String countryName;
    @Column(name = "country_code")
    private final String countryCode;
    @Column(name = "lang_name")
    private final String langName;
    @Column(name = "country_code_name")
    private final String countryCodeName;
    @Column(name = "lang_code")
    private final String langCode;
    @Column(name = "capital_city")
    private final String capitalCity;
    @OneToMany(mappedBy = "countryRus", cascade = CascadeType.ALL)
    private List<City> cities;
    private final String continent;
    @Column(name = "cost_line")
    private final String costLine;
    @Column(name = "currency_name")
    private final String currencyName;
    @OneToOne(cascade = CascadeType.ALL)
    private final Coordinates geoCoordinates;
    @Column(name = "government_type")
    private final String governmentType;
    @Column(name = "independence_year")
    private final String independenceYear;
    @Column(name = "life_expectancy")
    private final String lifeExpectancy;
    @Column(name = "national_dish")
    private final String nationalDish;
    private final String population;
    @Column(name = "population_density")
    private final String populationDensity;
    private final String region;
    private final String religion;
    @Column(name = "surface_area")
    private final String surfaceArea;
    @Column(name = "average_temperature")
    private final String averageTemperature;
    private final String flag;


    @Override
    public String toString() {
        return "<img src = " + flag + "/>"
                + "<li class = 'u'>Название страны: " + parameter(countryName, "") + "</li>"
                + "<li class = 'u'>Код страны: " + parameter(countryCode, "") + "</li>"
                + "<li class = 'u'>Официальный язык: " + parameter(langName, "") + "</li>"
                + "<li class = 'u'>Код названия страны: " + parameter(countryCodeName, "") + "</li>"
                + "<li class = 'u'>Код языка: " + parameter(langCode, "") + "</li>"
                + "<li class = 'u'>Столица: " + "<a href = 'https://ru.wikipedia.org/wiki/"
                + capitalCity + "'>" + parameter(capitalCity, "") + "</a>" + "</li>"
                + "<li class = 'u'>Крупнейшие города: " + parameter(citiesEnum("", cities), "") + "</li>"
                + "<li class = 'u'>Континент: " + parameter(continent, "") + "</li>"
                + "<li class = 'u'>Длина береговой линии: " + parameter(costLine, "") + " Km" + "</li>"
                + "<li class = 'u'>Валюта: " + parameter(currencyName, "") + "</li>"
                + "<li class = 'u'>Координаты: " + parameter(geoCoordinates.toString(), "") + "</li>"
                + "<li class = 'u'>Государственное устройство: "
                + parameter(governmentType, "") + "</li>"
                + "<li class = 'u'>Год обретения независимости: " + parameter(independenceYear, "") + "</li>"
                + "<li class = 'u'>Продолжительность жизни: "
                + parameter(lifeExpectancy, "") + " лет" + "</li>"
                + "<li class = 'u'>Национальное блюдо: " + parameter(nationalDish, "") + "</li>"
                + "<li class = 'u'>Население: " + parameter(population, "") + " чел" + "</li>"
                + "<li class = 'u'>Плотность населения: " + parameter(populationDensity, "")
                + " чел/Км2" + "</li>"
                + "<li class = 'u'>Регион: " + region + "</li>"
                + "<li class = 'u'>Гос. религия: " + parameter(religion, "") + "</li>"
                + "<li class = 'u'>Площадь територии: " + parameter(surfaceArea, "") + "Км2" + "</li>"
                + "<li class = 'u'>Средняя температура: " + parameter(averageTemperature, "")
                + " Градусов" + "</li>";

    }

}
