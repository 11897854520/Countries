package Main.Entities;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class InformationAboutCountryEng extends InformationAboutCountry {

    private static final String lang = "eng";

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
    @OneToMany(mappedBy = "countryEng", cascade = CascadeType.ALL)
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

    public String toString() {
        return "<img src = " + flag + "/>"
                + "<li class = 'u'>Country name: " + parameter(countryName, lang) + "</li>"
                + "<li class = 'u'>Country code: " + parameter(countryCode, lang) + "</li>"
                + "<li class = 'u'>Lang name: " + parameter(langName, lang) + "</li>"
                + "<li class = 'u'>Name code: " + parameter(countryCodeName, lang) + "</li>"
                + "<li class = 'u'>Lang code: " + parameter(langCode, lang) + "</li>"
                + "<li class = 'u'>Capital: " + "<a href = 'https://en.wikipedia.org/wiki/"
                + capitalCity + "'>" + parameter(capitalCity, lang) + "</a>" + "</li>"
                + "<li class = 'u'>Largest cities: " + parameter(citiesEnum(lang, cities), lang) + "</li>"
                + "<li class = 'u'>Continent: " + parameter(continent, lang) + "</li>"
                + "<li class = 'u'>Cost line: " + parameter(costLine, lang) + " Km" + "</li>"
                + "<li class = 'u'>Currency: " + parameter(currencyName, lang) + "</li>"
                + "<li class = 'u'>Coordinates: " + parameter(geoCoordinates.toString(), lang) + "</li>"
                + "<li class = 'u'>Government type: " + parameter(governmentType, lang) + "</li>"
                + "<li class = 'u'>Independence year: " + parameter(independenceYear, lang) + "</li>"
                + "<li class = 'u'>Life expectancy: " + parameter(lifeExpectancy, lang) + " years" + "</li>"
                + "<li class = 'u'>National dish: " + parameter(nationalDish, lang) + "</li>"
                + "<li class = 'u'>Population: " + parameter(population, lang) + " people" + "</li>"
                + "<li class = 'u'>Population density: " + parameter(populationDensity, lang) + " people/Km2" + "</li>"
                + "<li class = 'u'>Region: " + parameter(region, lang) + "</li>"
                + "<li class = 'u'>Religion: " + parameter(religion, lang) + "</li>"
                + "<li class = 'u'>Surface area: " + parameter(surfaceArea, lang) + " Km2" + "</li>"
                + "<li class = 'u'>Temperature: " + parameter(averageTemperature, lang) + " degrees" + "</li>";
    }


}

