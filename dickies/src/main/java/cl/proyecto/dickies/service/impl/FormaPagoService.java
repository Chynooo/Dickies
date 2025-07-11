package cl.proyecto.dickies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.dickies.model.dto.FormaPagoDTO;
import cl.proyecto.dickies.repository.FormaPagoRepository;
import cl.proyecto.dickies.service.IFormaPagoService; 



@Service
public class FormaPagoService implements IFormaPagoService {

    @Autowired
    FormaPagoRepository repo;

    @Override
    public FormaPagoDTO insertarFormaPago(FormaPagoDTO formaPago) {
        return repo.save(formaPago);
    }

    @Override
    public List<FormaPagoDTO> getTodas() {
        return (List<FormaPagoDTO>) repo.findAll();
    }

    @Override
    public FormaPagoDTO getById(Integer codpago) {
        return repo.findById(codpago).orElse(null);
    }

    @Override
    public boolean deleteById(Integer codpago) {
        repo.deleteById(codpago);
        return true;
    }

    @Override
    public FormaPagoDTO updateFormaPago(FormaPagoDTO formaPago) {
        return repo.save(formaPago);
    }
}
