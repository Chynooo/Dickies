package cl.proyecto.dickies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.dickies.model.dto.VentaDTO;



@Repository
public interface VentaRepository extends CrudRepository<VentaDTO, Long> {

}

