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
@Table(name="inventario_zapatilla")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "DTO que representa a una zapatilla")
public class ZapatillaDTO {
    @Id 
    @Column(name="ZAPATILLA")
    @Schema(description = "Identificador único de la zapatilla", example = "ZAP001")
    private String codigoZapatilla;

    @Schema(description = "Nombre de la marca", example = "Nike")
    private String marca;

    @Schema(description = "Nombre del modelo", example = "Deportivo")
    private String modelo;

    @Schema(description = "Número de talla", example = "42")
    private int talla;
    
}
