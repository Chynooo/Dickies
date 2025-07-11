package cl.proyecto.dickies.service;

import java.util.List;

import cl.proyecto.dickies.model.dto.FormaPagoDTO;


public interface IFormaPagoService {

    FormaPagoDTO insertarFormaPago(FormaPagoDTO formaPago);

    List<FormaPagoDTO> getTodas();

    FormaPagoDTO getById(Integer codpago);

    boolean deleteById(Integer codpago);

    FormaPagoDTO updateFormaPago(FormaPagoDTO formaPago);
}

