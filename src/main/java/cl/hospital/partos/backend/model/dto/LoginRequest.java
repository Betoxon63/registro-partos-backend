package cl.hospital.partos.backend.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object para recibir las credenciales del usuario en el login.
 */
@Data
@NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
