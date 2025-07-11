package cl.proyecto.dickies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.dickies.model.dto.ZapatillaDTO;
import cl.proyecto.dickies.repository.ZapatillaRepository;
import cl.proyecto.dickies.service.IZapatillaService;



@Service
public class ZapatillaService implements IZapatillaService {

    @Autowired
    ZapatillaRepository repo;

    @Override
    public ZapatillaDTO insertarZapatilla(ZapatillaDTO zapatilla) {
        return repo.save(zapatilla);
    }

    @Override
    public List<ZapatillaDTO> getTodas() {
        return (List<ZapatillaDTO>) repo.findAll();
    }

    @Override
    public ZapatillaDTO getById(String codigo) {
        return repo.findById(codigo).orElse(null);
    }

    @Override
    public boolean deleteById(String codigo) {
        repo.deleteById(codigo);
        return true;
    }

    @Override
    public ZapatillaDTO updateZapatilla(ZapatillaDTO zapatilla) {
        return repo.save(zapatilla);
    }
}
