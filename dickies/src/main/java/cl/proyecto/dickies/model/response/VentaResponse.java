package cl.proyecto.dickies.model.response;


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
@Table(name = "venta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Respuesta genérica de la API")
public class VentaResponse {

    @Id
    @Column(name = "id_venta")
    @Schema(description = "Identificador único de la venta", example = "1")
    private Long idVenta;

    @Column(name = "codigo_zapatilla")
    @Schema(description = "Código de la zapatilla vendida", example = "ZAP001")
    private String codigoZapatilla;

    @Column(name = "marca")
    @Schema(description = "Marca de la zapatilla", example = "Nike")
    private String marca;

    @Column(name = "modelo")
    @Schema(description = "Modelo de la zapatilla", example = "Deportivo")
    private String modelo;

    @Column(name = "talla")
    @Schema(description = "Talla de la zapatilla", example = "42")
    private int talla;

    @Column(name = "cliente")
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    private String cliente;

    @Column(name = "fecha_venta")
    @Schema(description = "Fecha de la venta", example = "2025-06-23T15:30:00")
    private String fechaVenta; 
}   
