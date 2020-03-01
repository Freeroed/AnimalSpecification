package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vlsu.animalSpecification.domain.Region;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {

    @Query(value = "SELECT c from Region c WHERE c.name LIKE :keyword ")
    public List<Region> search(@Param("keyword") String keyword);

}
