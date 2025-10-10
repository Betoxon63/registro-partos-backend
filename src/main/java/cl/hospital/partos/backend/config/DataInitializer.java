package cl.hospital.partos.backend.config;

import cl.hospital.partos.backend.model.Rol;
import cl.hospital.partos.backend.model.Usuario;
import cl.hospital.partos.backend.repository.RolRepository;
import cl.hospital.partos.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Clase para inicializar datos esenciales (Roles y un Usuario ADMIN)
 * al iniciar la aplicación por primera vez.
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // 1. Inicializar Roles
        Rol adminRol = rolRepository.findByNombre("ADMIN")
                .orElseGet(() -> rolRepository.save(new Rol(null, "ADMIN")));

        Rol userRol = rolRepository.findByNombre("USER")
                .orElseGet(() -> rolRepository.save(new Rol(null, "USER")));

        // 2. Inicializar Usuario Administrador
        if (usuarioRepository.findByNombreUsuario("admin").isEmpty()) {
            Usuario adminUser = new Usuario();
            adminUser.setNombreUsuario("admin");
            // Contraseña: 'admin123'. Se codifica antes de guardar.
            adminUser.setContrasena(passwordEncoder.encode("admin123"));
            adminUser.setRol(adminRol);
            usuarioRepository.save(adminUser);
            System.out.println(">>> Usuario ADMIN creado: 'admin' / 'admin123'");
        }
    }
}
