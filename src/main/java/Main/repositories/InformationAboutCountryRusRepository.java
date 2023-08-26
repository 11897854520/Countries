package Main.repositories;

import Main.Entities.InformationAboutCountryEng;
import Main.Entities.InformationAboutCountryRus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.TreeSet;

@Repository
public interface InformationAboutCountryRusRepository
        extends CrudRepository<InformationAboutCountryRus, Integer> {
    @Query(value = "SELECT country_name FROM information_about_country_rus", nativeQuery = true)
    TreeSet<String> findAllNames();

    InformationAboutCountryRus findByCountryName(String name);
}
