package cl.proyecto.dickies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.dickies.model.dto.FormaPagoDTO;

@Repository
public interface FormaPagoRepository extends CrudRepository<FormaPagoDTO, Integer> {

}
