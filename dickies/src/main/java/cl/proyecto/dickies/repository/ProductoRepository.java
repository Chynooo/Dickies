package cl.proyecto.dickies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.dickies.model.dto.ProductoDTO;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoDTO, String> {
}
