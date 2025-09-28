package cl.hospital.registro_partos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de prueba para verificar la comunicación entre el frontend y el backend.
 * Expone un endpoint simple.
 **/

@RestController // Indica que esta clase es un controlador REST y los métodos devuelven datos JSON/texto directamente.
@RequestMapping("/api/test") // Mapea todas las rutas de esta clase a /api/test.
@CrossOrigin(origins = "http://localhost:4200") // Permite peticiones CORS (Cross-Origin) desde el frontend de Angular.
public class TestController {

    /**
     * Endpoint GET que devuelve un mensaje simple.
     * Accessible en: http://localhost:8080/api/test
     * @return String de estado.
     **/

    @GetMapping // Mapea peticiones GET a la ruta base definida en @RequestMapping.
    public String hello() {
        return "Sistema de Registro de Partos Funcionando Correctamente 🚀";
    }
}
