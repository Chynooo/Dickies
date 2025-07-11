package cl.proyecto.dickies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.proyecto.dickies.model.dto.FormaPagoDTO;
import cl.proyecto.dickies.model.dto.ProductoDTO;
import cl.proyecto.dickies.model.dto.VentaDTO;
import cl.proyecto.dickies.model.dto.ZapatillaDTO;
import cl.proyecto.dickies.model.response.FormaPagoResponse;
import cl.proyecto.dickies.model.response.ProductoResponse;
import cl.proyecto.dickies.model.response.ZapatillaResponse;
import cl.proyecto.dickies.service.IFormaPagoService;
import cl.proyecto.dickies.service.IProductoService;
import cl.proyecto.dickies.service.IVentaService;
import cl.proyecto.dickies.service.IZapatillaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/crud")
@Tag(name = "ZapatillasTag", description = "API para gestionar zapatillas TAG")
public class ZapatillaController {

    @Autowired
    private IZapatillaService zapatillaService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IFormaPagoService formaPagoService;

    @Autowired
    private IVentaService ventaService;

    // Endpoints para zapatillas
    @Operation(summary = "Crear una nueva zapatilla", description = "Agrega una nueva zapatilla a la lista")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Zapatilla creada correctamente"),
        @ApiResponse(responseCode = "409 Conflict", description = "Zapatilla ya Existe")
    })
    @PostMapping("/zapatillas")
    public ZapatillaDTO insertZapatilla(@RequestBody ZapatillaDTO zapatilla) {
        System.out.println("DEBUG - codigoZapatilla recibido: " + zapatilla.getCodigoZapatilla());
        return zapatillaService.insertarZapatilla(zapatilla);
    }

    @Operation(summary = "Listar todas las zapatillas", description = "Devuelve la lista completa de las zapatillas")
    @ApiResponse(responseCode = "200", description = "Lista de zapatillas obtenida correctamente")
    @GetMapping("/zapatillas")
    public List<ZapatillaDTO> getTodasZapatillas() {
        return zapatillaService.getTodas();
    }

    @Operation(summary = "Obtener zapatilla por ID", description = "Devuelve una zapatilla por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Zapatilla encontrada"),
        @ApiResponse(responseCode = "404", description = "Zapatilla no encontrada")
    })
    @GetMapping("/zapatillas/{codigo}")
    public ZapatillaDTO getZapatillaByCodigo(@PathVariable String codigo) {
        return zapatillaService.getById(codigo);
    }

    @Operation(summary = "Actualizar zapatilla existente"
             , description = "Actualiza los datos de una zapatilla por ID"
             , tags = {"Crear Zapatilla Tag"}
             ,requestBody= @io.swagger.v3.oas.annotations.parameters.RequestBody(
                   description= "Campos de Zapatilla" 
                   ,required = true
                   ,content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ZapatillaDTO.class)
                   )
                )
             ,responses = {
                @ApiResponse(
                    responseCode = "201"
                    ,description = "Successful Creaction"
                    ,content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ZapatillaResponse.class)
                    )
                )
             }
             )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Zapatilla actualizada correctamente"),
        @ApiResponse(responseCode = "404", description = "Zapatilla no encontrada")
    })
    @PutMapping("/zapatillas/{codigo}")
    public ZapatillaDTO updateZapatilla(@PathVariable String codigo, @RequestBody ZapatillaDTO zapatilla) {
        zapatilla.setCodigoZapatilla(codigo);
        return zapatillaService.updateZapatilla(zapatilla);
    }

    @Operation(summary = "Eliminar zapatilla", description = "Elimina una zapatilla por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Zapatilla eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Zapatilla no encontrada")
    })
    @DeleteMapping("/zapatillas/{codigo}")
    public boolean deleteZapatillaByCodigo(@PathVariable String codigo) {
        return zapatillaService.deleteById(codigo);
    }

    // Endpoints para productos
    @Operation(summary = "Crear un nuevo producto ", description = "Agrega un nuevo producto a la lista")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Producto creado correctamente"),
        @ApiResponse(responseCode = "505", description = "Producto ya Existe")
    })
    @PostMapping("/productos")
    public ProductoDTO insertProducto(@RequestBody ProductoDTO producto) {
        return productoService.insertarProducto(producto);
    }

    @Operation(summary = "Listar todos los productos", description = "Devuelve la lista completa de los productos")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente")
    @GetMapping("/productos")
    public List<ProductoDTO> getTodosProductos() {
        return productoService.getTodos();
    }

    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/productos/{codigo}")
    public ProductoDTO getProductoByCodigo(@PathVariable String codigo) {
        return productoService.getById(codigo);
    }

    @Operation(summary = "Actualizar producto existente"
             , description = "Actualiza los datos de un producto por ID"
             , tags = {"Crear Producto Tag"}
             ,requestBody= @io.swagger.v3.oas.annotations.parameters.RequestBody(
                   description= "Campos de producto" 
                   ,required = true
                   ,content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ProductoDTO.class)
                   )
                )
             ,responses = {
                @ApiResponse(
                    responseCode = "201"
                    ,description = "Successful Creaction"
                    ,content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ProductoResponse.class)
                    )
                )
             }
             )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto actualizada correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrada")
    })
    @PutMapping("/productos/{codigo}")
    public ProductoDTO updateProducto(@PathVariable String codigo, @RequestBody ProductoDTO producto) {
        producto.setCodigoProducto(codigo);
        return productoService.updateProducto(producto);
    }

    @Operation(summary = "Eliminar producto", description = "Elimina un producto por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/productos/{codigo}")
    public boolean deleteProductoByCodigo(@PathVariable String codigo) {
        return productoService.deleteById(codigo);
    }

    // Endpoints para forma de pago
    @Operation(summary = "Actualizar forma de pago existente"
             , description = "Actualiza los datos de una forma de pago por ID"
             , tags = {"Crear Forma de pago Tag"}
             ,requestBody= @io.swagger.v3.oas.annotations.parameters.RequestBody(
                   description= "Campos de la forma de pago" 
                   ,required = true
                   ,content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = FormaPagoDTO.class)
                   )
                )
             ,responses = {
                @ApiResponse(
                    responseCode = "201"
                    ,description = "Successful Creaction"
                    ,content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = FormaPagoResponse.class)
                    )
                )
             }
             )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Forma de pago actualizada correctamente"),
        @ApiResponse(responseCode = "404", description = "Forma de pago no encontrada")
    })
    @PutMapping("/formapago/{codpago}")
    public FormaPagoDTO updateFormaPago(@PathVariable Integer codpago, @RequestBody FormaPagoDTO formaPago) {
        formaPago.setCodpago(codpago);
        return formaPagoService.updateFormaPago(formaPago);
    }
    
    @Operation(summary = "Crear una nueva forma de pago", description = "Agrega una nueva forma de pago a la lista")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Forma de pago creada correctamente"),
        @ApiResponse(responseCode = "505", description = "Forma de pago ya Existe")
    })
    @PostMapping("/formapago")
    public FormaPagoDTO insertFormaPago(@RequestBody FormaPagoDTO formaPago) {
        return formaPagoService.insertarFormaPago(formaPago);
    }

    @Operation(summary = "Listar todas las formas de pago", description = "Devuelve la lista completa de formas de pago")
    @ApiResponse(responseCode = "200", description = "Lista de formas de pago obtenida correctamente")
    @GetMapping("/formapago")
    public List<FormaPagoDTO> getTodasFormasPago() {
        return formaPagoService.getTodas();
    }

    @Operation(summary = "Obtener forma de pago por ID", description = "Devuelve una forma de pago por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Forma de pago encontrada"),
        @ApiResponse(responseCode = "404", description = "Forma de pago no encontrada")
    })
    @GetMapping("/formapago/{codpago}")
    public FormaPagoDTO getByCodpago(@PathVariable Integer codpago) {
        return formaPagoService.getById(codpago);
    }

    @Operation(summary = "Eliminar forma de pago", description = "Elimina una forma de pago por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Forma de pago eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Forma de pago no encontrada")
    })
    @DeleteMapping("/formapago/{codpago}")
    public boolean deleteByCodpago(@PathVariable Integer codpago) {
        return formaPagoService.deleteById(codpago);
    }


    @Operation(summary = "Crear una nueva venta", description = "Registra una nueva venta de zapatilla")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Venta creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PostMapping("/ventas")
    public VentaDTO insertVenta(@RequestBody VentaDTO venta) {
        return ventaService.insertarVenta(venta);     
    }

    @Operation(summary = "Listar todas las ventas", description = "Devuelve la lista completa de ventas realizadas")
    @ApiResponse(responseCode = "200", description = "Lista de ventas obtenida correctamente")
    @GetMapping("/ventas")
    public List<VentaDTO> getTodasVentas() {
        return ventaService.getTodas();
    }

    @Operation(summary = "Obtener venta por ID", description = "Devuelve una venta por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Venta encontrada"),
        @ApiResponse(responseCode = "404", description = "Venta no encontrada")
    })
    @GetMapping("/ventas/{id}")
    public VentaDTO getVentaById(@PathVariable Long id) {
        return ventaService.getById(id);
    }

    @Operation(
        summary = "Actualizar venta existente",
        description = "Actualiza los datos de una venta por ID",
        tags = {"Actualizar Venta"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Campos de Venta",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = VentaDTO.class)
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Venta actualizada correctamente",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VentaDTO.class)
                )
            )
        }
    )
    @PutMapping("/ventas/{id}")
    public VentaDTO updateVenta(@PathVariable Long id, @RequestBody VentaDTO venta) {
        venta.setIdVenta(id);
        return ventaService.updateVenta(venta);
    }


    @Operation(summary = "Eliminar venta", description = "Elimina una venta por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Venta eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Venta no encontrada")
    })

    @DeleteMapping("/ventas/{id}")
    public boolean deleteVentaById(@PathVariable Long id) {
        return ventaService.deleteById(id); 
    }  


}
