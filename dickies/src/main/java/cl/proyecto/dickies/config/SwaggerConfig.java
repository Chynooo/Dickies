package cl.proyecto.dickies.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "Servicio de Inventario de Zapatillas",
                description = "API REST para la gestión de inventario de zapatillas deportivas",
                termsOfService = "http://localhost:8090/terminos_y_condiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Dickies Informática",
                        url = "https://www.mispymes.cl",
                        email = "edu.gaete@duocuc.cl"
                ),
                license = @License(
                        name = "Standard Software Use License for UnProgramadorNace",
                        url = "https://www.unprogramadornace.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "Servidor de Desarrollo",
                        url = "http://localhost:8090"
                ),
                @Server(
                        description = "Servidor de Producción",
                        url = "http://localhost:8090"
                )
        },
        security = @SecurityRequirement(name = "Inventario Zapatillas JWT")
)
@SecurityScheme(
        name = "Inventario Zapatillas JWT",
        description = "Autenticación con JWT para el sistema de zapatillas",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)

@Configuration
public class SwaggerConfig {

}
