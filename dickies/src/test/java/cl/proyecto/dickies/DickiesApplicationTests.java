package cl.proyecto.dickies;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import cl.proyecto.dickies.model.dto.ProductoDTO;
import cl.proyecto.dickies.service.impl.ProductoService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DickiesApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
    void getAllZapatillas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/crud/zapatillas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                .content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                );
    }

    @SuppressWarnings("removal")
    @MockBean
    private ProductoService productoService;
    
    @Test
    public void testObtenerProducto_Existe() throws Exception {
        ProductoDTO producto = new ProductoDTO("P001", "Laptop", "Electrónica", 999.99);

        Mockito.when(productoService.getById("P001"))
             .thenReturn(producto);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/crud/productos/P001")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigoProducto").value("P001"))
                .andExpect(jsonPath("$.nombre").value("Laptop"))
                .andExpect(jsonPath("$.categoria").value("Electrónica"))
                .andExpect(jsonPath("$.precio").value(999.99));
    }

    @Test
    public void testInsertProducto() throws Exception {
        ProductoDTO producto = new ProductoDTO("P002", "Tablet", "Electrónica", 299.99);

        Mockito.when(productoService.insertarProducto(Mockito.any(ProductoDTO.class)))
               .thenReturn(producto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/crud/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "codigoProducto": "P002",
                                    "nombre": "Tablet",
                                    "categoria": "Electrónica",
                                    "precio": 299.99
                                }
                                """))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.codigoProducto").value("P002"))
                .andExpect(jsonPath("$.nombre").value("Tablet"))
                .andExpect(jsonPath("$.categoria").value("Electrónica"))
                .andExpect(jsonPath("$.precio").value(299.99));
    }

    @Test
    public void testEliminarProducto_Existe() throws Exception {
        Mockito.when(productoService.deleteById("P003")).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/crud/productos/P003"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

}
