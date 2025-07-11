package cl.proyecto.dickies.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="forma_pago")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "DTO que representa la forma de pago")
public class FormaPagoDTO {
    @Id
    @Column(name = "CODPAGO")
    @Schema(description = "Identificador único del pago", example = "1")     
    private Integer codpago;

    @Column(name = "DESCRIPCION") 
    @Schema(description = "metodos de pago", example = "efectivo")
    private String descripcion;
}
