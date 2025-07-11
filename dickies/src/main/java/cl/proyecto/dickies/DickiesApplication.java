package cl.proyecto.dickies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DickiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DickiesApplication.class, args);
		System.out.println("Sistema en funcionamiento.");
	}

}