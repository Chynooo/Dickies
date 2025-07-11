package cl.proyecto.dickies.service;

import java.util.List;

import cl.proyecto.dickies.model.dto.ZapatillaDTO;



public interface IZapatillaService {

    ZapatillaDTO insertarZapatilla(ZapatillaDTO zapatilla);

    List<ZapatillaDTO> getTodas();

    ZapatillaDTO getById(String codigo);

    boolean deleteById(String codigo);

    ZapatillaDTO updateZapatilla(ZapatillaDTO zapatilla);

}
