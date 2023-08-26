package Main.services;

import Main.Entities.City;
import Main.Entities.Coordinates;
import Main.Entities.InformationAboutCountryEng;
import Main.Entities.InformationAboutCountryRus;
import Main.parser.Translator;
import Main.repositories.CityRepository;
import Main.repositories.InformationAboutCountryEngRepository;
import Main.repositories.InformationAboutCountryRusRepository;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CountryService {

    public CountryService(CityRepository cityRepository
            , InformationAboutCountryEngRepository engRepository
            , InformationAboutCountryRusRepository rusRepository)
            throws JsonException, FileNotFoundException {
        this.cityRepository.set(cityRepository);
        this.rusRepository.set(rusRepository);
        this.engRepository.set(engRepository);
        getCountriesInformation();
    }

    private final AtomicReference<CityRepository> cityRepository = new AtomicReference<>();
    private final AtomicReference<InformationAboutCountryEngRepository> engRepository = new AtomicReference<>();
    private final AtomicReference<InformationAboutCountryRusRepository> rusRepository = new AtomicReference<>();

    private void getCountriesInformation() throws FileNotFoundException, JsonException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        FileReader readerOne = new FileReader("src/main/resources/files/country_list (1).json");
        JsonArray countryArrayOne = (JsonArray) Jsoner.deserialize(readerOne);
        File dir = new File("src/main/resources/files/jsonFiles");
        List<File> files = new ArrayList<>(List.of(dir.listFiles()));
        System.out.println(engRepository.get().findAllNames().size());
        if (engRepository.get().findAllNames().size() < 143) {
            cityRepository.get().deleteAll();
        }
        if (cityRepository.get().findAllNames().isEmpty()) {
            countryArrayOne.forEach(o -> {
                JsonObject objectOne = (JsonObject) o;
                enumerateAllFiles(files, objectOne);
                service.submit(() -> {
                    try {
                        createCountryInformation(objectOne);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        }
        service.shutdown();
    }


    private void enumerateAllFiles(List<File> files, JsonObject objectOne) {
        files.forEach(file -> {
            try {
                FileReader readerTwo = new FileReader(file.getPath());
                JsonArray countryArrayTwo = (JsonArray) Jsoner.deserialize(readerTwo);
                countryArrayTwo.forEach(o1 -> {
                    JsonObject objectTwo = (JsonObject) o1;
                    addParametersInObject(objectOne, objectTwo);
                });
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (JsonException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void addParametersInObject(JsonObject objectOne, JsonObject objectTwo) {
        if (objectOne.get("country_name").equals(objectTwo.get("country"))) {
            objectTwo.entrySet().stream().filter(stringObjectEntry
                            -> !stringObjectEntry.getKey().equals("country"))
                    .forEach(stringObjectEntry
                            -> {
                        objectOne.put(stringObjectEntry.getKey()
                                , stringObjectEntry.getValue());
                    });
        }
    }

    private List<City> getCities(JsonArray array, InformationAboutCountryEng countryEng
            , InformationAboutCountryRus countryRus) {
        return array != null ? array.stream().map(o -> new City((String) o, countryEng
                , countryRus)).collect(Collectors.toList()) : new ArrayList<>();
    }

    private void createCountryInformation(JsonObject object) throws IOException {
        String countryName = (String) object.get("country_name");
        String countryCode = (String) object.get("country_code");
        String langName = (String) object.get("lang_name");
        String countryCodeName = (String) object.get("country_code_name");
        String langCode = (String) object.get("lang_code");
        String capitalCity = (String) object.get("city");
        String continent = (String) object.get("continent");
        String costLine = String.valueOf(object.get("costline"));
        String currencyName = (String) object.get("currency_name");
        String governmentType = (String) object.get("government");
        String independenceDate = String.valueOf(object.get("independence"));
        String lifeExpectancy = String.valueOf(object.get("expectancy"));
        String nationalDish = (String) object.get("dish");
        String population = String.valueOf(object.get("population"));
        String populationDensity = String.valueOf(object.get("density"));
        String region = (String) object.get("location");
        String religion = (String) object.get("religion");
        String surfaceArea = String.valueOf(object.get("area"));
        String averageTemperature = String.valueOf(object.get("temperature"));
        String flag = "assets/pictures/flag/" + countryCodeName + ".png";
        InformationAboutCountryEng countryEng = new InformationAboutCountryEng(countryName
                , countryCode, langName, countryCodeName, langCode, capitalCity, continent, costLine
                , currencyName, new Coordinates("North"
                , String.valueOf(object.get("north")), "South"
                , String.valueOf(object.get("south")), "West", String.valueOf(object.get("west"))
                , "East"
                , String.valueOf(object.get("east"))), governmentType, independenceDate, lifeExpectancy
                , nationalDish, population, populationDensity, region, religion
                , surfaceArea, averageTemperature, flag);
        InformationAboutCountryRus countryRus = new InformationAboutCountryRus(
                Translator.getTranslate(countryName)
                , countryCode, Translator.getTranslate(langName), countryCodeName, langCode
                , Translator.getTranslate(capitalCity), Translator.getTranslate(continent), costLine
                , Translator.getTranslate(currencyName), new Coordinates("Cевер"
                , String.valueOf(object.get("north")), "Юг"
                , String.valueOf(object.get("south")), "Запад", String.valueOf(object.get("west"))
                , "Восток"
                , String.valueOf(object.get("east"))), Translator.getTranslate(governmentType)
                , independenceDate, lifeExpectancy
                , Translator.getTranslate(nationalDish), population, populationDensity
                , Translator.getTranslate(region), Translator.getTranslate(religion)
                , surfaceArea, averageTemperature, flag);
        cityRepository.get().saveAll(getCities((JsonArray) object.get("cities"), countryEng, countryRus));
    }
}


