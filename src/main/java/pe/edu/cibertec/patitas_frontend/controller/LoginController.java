package pe.edu.cibertec.patitas_frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.patitas_frontend.viewmodel.LoginModel;
import pe.edu.cibertec.patitas_frontend.viewmodel.LoginRq;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/inicio")
    public String inicio(Model model){
        LoginModel loginModel = new LoginModel("00","","");
        model.addAttribute("loginModel",loginModel);
        return "inicio";

    }

    @PostMapping("/autenticar")
    public String autenticar(@RequestParam("tipoDocumento") String tipoDocumento,
                             @RequestParam("numeroDocumento") String numeroDocumento,
                             @RequestParam("password") String password,
                             Model model) {

        // Validar campos de entrada
        if (tipoDocumento == null || tipoDocumento.trim().length() == 0 ||
                numeroDocumento == null || numeroDocumento.trim().length() == 0 ||
                password == null || password.trim().length() == 0) {
            LoginModel loginModel = new LoginModel("01", "Error: Debe completar correctamente sus credenciales", "");
            model.addAttribute("loginModel", loginModel);
            return "inicio";

        }

        //Llamada al servicio de auntenticacion del backend
        String backendurl = "http://localhost:8090/autenticacion/login";
        LoginRq loginRq = new LoginRq(tipoDocumento, numeroDocumento, password);
        LoginModel loginModel = restTemplate.postForObject(backendurl, loginRq, LoginModel.class);

        if (loginModel != null && "00".equals(loginModel.codigo())) {
            model.addAttribute("loginModel", loginModel);
            return "principal";
        }
        model.addAttribute("loginModel", new LoginModel("01", "Credenciales erroneas..", ""));
        return "inicio";




    }
}
