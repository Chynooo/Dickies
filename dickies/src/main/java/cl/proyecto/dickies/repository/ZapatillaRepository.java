package cl.proyecto.dickies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.dickies.model.dto.ZapatillaDTO;



@Repository
public interface ZapatillaRepository extends CrudRepository<ZapatillaDTO, String> {

}
