package cl.proyecto.dickies.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Respuesta genérica de la API")
public class ZapatillaResponse {

    @Schema(description = "Identificador único de la zapatilla", example = "ZAP001")
    private String codigoZapatilla;

    @Schema(description = "Nombre de la marca", example = "Nike")
    private String marca;

    @Schema(description = "Nombre del modelo", example = "Deportivo")
    private String modelo;

    @Schema(description = "Número de talla", example = "42")
    private int talla;
    
}