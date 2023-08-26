package Main.repositories;

import Main.Entities.InformationAboutCountryEng;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

@Repository
public interface InformationAboutCountryEngRepository
        extends CrudRepository<InformationAboutCountryEng, Integer> {

    @Query(value = "SELECT country_name FROM information_about_country_eng", nativeQuery = true)
    TreeSet<String> findAllNames();

    InformationAboutCountryEng findByCountryName(String name);
}
