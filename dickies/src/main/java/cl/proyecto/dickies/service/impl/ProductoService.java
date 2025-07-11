package cl.proyecto.dickies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.dickies.model.dto.ProductoDTO;
import cl.proyecto.dickies.repository.ProductoRepository;
import cl.proyecto.dickies.service.IProductoService;



@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository repo;

    @Override
    public ProductoDTO insertarProducto(ProductoDTO producto) {
        return repo.save(producto);
    }

    @Override
    public List<ProductoDTO> getTodos() {
        return (List<ProductoDTO>) repo.findAll();
    }


    @Override
    public ProductoDTO getById(String codigo) {
        return repo.findById(codigo).orElse(null);
    }

    @Override
    public boolean deleteById(String codigo) {
        repo.deleteById(codigo);
        return true;
    }

    @Override
    public ProductoDTO updateProducto(ProductoDTO producto) {
        return repo.save(producto);
    }
}


