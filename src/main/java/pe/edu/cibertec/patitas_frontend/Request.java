package pe.edu.cibertec.patitas_frontend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Request {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
