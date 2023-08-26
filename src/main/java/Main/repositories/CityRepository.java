package Main.repositories;

import Main.Entities.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Integer> {
    @Query(value = "SELECT name FROM city", nativeQuery = true)
    List<String> findAllNames();
}
