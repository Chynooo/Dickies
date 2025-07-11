package cl.proyecto.dickies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.dickies.model.dto.VentaDTO;
import cl.proyecto.dickies.repository.VentaRepository;
import cl.proyecto.dickies.service.IVentaService;



@Service
public class VentaService implements IVentaService {

    @Autowired
    VentaRepository repo;

    @Override
    public VentaDTO insertarVenta(VentaDTO venta) {
        return repo.save(venta);
    }

    @Override
    public List<VentaDTO> getTodas() {
        return (List<VentaDTO>) repo.findAll();
    }

    @Override
    public VentaDTO getById(Long idVenta) {
        return repo.findById(idVenta).orElse(null);
    }

    @Override
    public boolean deleteById(Long idVenta) {
        repo.deleteById(idVenta);
        return true;
    }

    @Override
    public VentaDTO updateVenta(VentaDTO venta) {
        return repo.save(venta);
    }
}
