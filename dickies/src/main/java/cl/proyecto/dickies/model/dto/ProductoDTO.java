package cl.proyecto.dickies.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "DTO que representa a un producto")
public class ProductoDTO {
    @Id
    @Column(name="codigo_producto")
    @Schema(description = "Identificador único del producto", example = "P001")
    private String codigoProducto;

    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 13")
    private String nombre;

    @Schema(description = "Nombre de la categoria", example = "Electrónica")
    private String categoria;

    @Schema(description = "Precio que tiene el producto", example = "1200000")
    private double precio;
}


