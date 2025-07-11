package cl.proyecto.dickies.service;

import java.util.List;

import cl.proyecto.dickies.model.dto.ProductoDTO;

public interface IProductoService {

    ProductoDTO insertarProducto(ProductoDTO producto);

    List<ProductoDTO> getTodos(); 

    ProductoDTO getById(String codigo);

    boolean deleteById(String codigo); 

    ProductoDTO updateProducto(ProductoDTO producto);

    

}
