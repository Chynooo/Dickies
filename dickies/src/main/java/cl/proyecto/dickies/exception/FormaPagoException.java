package cl.proyecto.dickies.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Getter   
@Setter
public class FormaPagoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpError;
    private String codigo;
    private String detalle;

    public FormaPagoException(HttpStatus httpError, String codigo, String detalle) {
        super("( " + codigo + " ) " + detalle);
        this.httpError = httpError;
        this.codigo = codigo;
        this.detalle = detalle;
    }
}
