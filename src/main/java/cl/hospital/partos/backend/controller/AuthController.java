package cl.hospital.partos.backend.controller;

import cl.hospital.partos.backend.model.dto.AuthResponse;
import cl.hospital.partos.backend.model.dto.LoginRequest;
import cl.hospital.partos.backend.security.JwtTokenUtil;
import cl.hospital.partos.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para manejar las peticiones de autenticación.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthService authService;

    // Endpoint de Login (Paso 10)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // 1. Autenticar las credenciales
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            // 2. Cargar los detalles del usuario
            UserDetails userDetails = authService.loadUserByUsername(request.getUsername());

            // 3. Generar el token JWT
            String token = jwtTokenUtil.generateToken(userDetails);
            String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority().substring(5); // Quitar "ROLE_"

            // 4. Devolver la respuesta con el token
            return ResponseEntity.ok(new AuthResponse(token, role));

        } catch (Exception e) {
            // Manejar errores de autenticación (credenciales inválidas)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }
    }
}
