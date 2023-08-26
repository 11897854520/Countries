package Main.controllers;

import Main.repositories.InformationAboutCountryEngRepository;
import Main.repositories.InformationAboutCountryRusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TreeSet;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    @Autowired
    private InformationAboutCountryRusRepository rusRepository;
    @Autowired
    private InformationAboutCountryEngRepository engRepository;


    @GetMapping("/get")
    public TreeSet<String> getCountries() {
        return engRepository.findAllNames();
    }

    @GetMapping("/get/{name}")
    public String getInformation(@PathVariable String name) {
        return engRepository.findByCountryName(name).toString();
    }

    @GetMapping("/get_rus")
    public TreeSet<String> getCountriesRus() {
        return rusRepository.findAllNames();
    }

    @GetMapping("/get_rus/{name}")
    public String getRusInformation(@PathVariable String name) {
        return rusRepository.findByCountryName(name).toString();
    }

}
