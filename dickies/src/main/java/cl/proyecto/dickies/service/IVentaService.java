package cl.proyecto.dickies.service;

import java.util.List;

import cl.proyecto.dickies.model.dto.VentaDTO;


public interface IVentaService {

    VentaDTO insertarVenta(VentaDTO venta);

    List<VentaDTO> getTodas();

    VentaDTO getById(Long idVenta);

    boolean deleteById(Long idVenta);

    VentaDTO updateVenta(VentaDTO venta);

}

