package pe.edu.cibertec.patitas_frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //Habilita el uso de Feign Client

public class PatitasFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatitasFrontendApplication.class, args);
	}

}
