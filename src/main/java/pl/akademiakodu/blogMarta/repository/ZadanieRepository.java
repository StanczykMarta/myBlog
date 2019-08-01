package pl.akademiakodu.blogMarta.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.blogMarta.model.Zadanie;

public interface ZadanieRepository extends
        CrudRepository<Zadanie, Integer> {
}
