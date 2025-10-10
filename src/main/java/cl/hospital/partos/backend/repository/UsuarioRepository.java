package cl.hospital.partos.backend.repository;

import cl.hospital.partos.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Metodo para buscar un Usuario por su nombre de usuario (necesario para login)
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
