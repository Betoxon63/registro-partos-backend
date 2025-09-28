package cl.hospital.registro_partos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.web.cors.CorsConfiguration;

@Configuration // Indica que esta clase contiene métodos de configuración de Spring.
@EnableWebSecurity // Habilita la integración de Spring Security en el proyecto.
public class SecurityConfig {

    /**
     * Define la cadena de filtros de seguridad HTTP para toda la aplicación.
     * Es donde configuramos CORS, CSRF y las reglas de autorización.
     **/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Deshabilitar CSRF (Crucial para APIs REST stateless, ya que no usamos sesiones).
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Configuración de CORS.
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("http://localhost:4200"); // Definir explícitamente el origen permitido (el puerto del frontend).
                    config.addAllowedMethod("*"); // Permitir todos los métodos HTTP (GET, POST, PUT, DELETE).
                    config.addAllowedHeader("*"); // Permitir todos los headers.
                    return config;
                }))

                // 3. Autorización de solicitudes HTTP
                .authorizeHttpRequests(authorize -> authorize
                        // Permitir acceso a todas las rutas bajo /api/** sin necesidad de autenticación.
                        // Esto expone nuestra API REST.
                        .requestMatchers("/api/**").permitAll()
                        // Cualquier otra petición (ej. /login) debe estar autenticada (comportamiento por defecto).
                        .anyRequest().authenticated()
                )

                // 4. Deshabilitar la autenticación basada en formulario de login por defecto.
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
