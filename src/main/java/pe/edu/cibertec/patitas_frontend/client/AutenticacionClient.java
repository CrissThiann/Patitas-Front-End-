package pe.edu.cibertec.patitas_frontend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.edu.cibertec.patitas_frontend.dto.LoginRequestDTO;
import pe.edu.cibertec.patitas_frontend.dto.LoginResponseDTO;

@FeignClient(name = "autenticacion", url = "http://localhost:8090/autenticacion")
public interface AutenticacionClient {

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO);
}
