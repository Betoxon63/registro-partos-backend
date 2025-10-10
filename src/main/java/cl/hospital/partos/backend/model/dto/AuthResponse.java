package cl.hospital.partos.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object para enviar el token y el rol de vuelta al cliente.
 */
@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String role;
}
