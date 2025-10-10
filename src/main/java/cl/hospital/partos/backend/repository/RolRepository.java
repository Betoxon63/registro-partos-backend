package cl.hospital.partos.backend.repository;

import cl.hospital.partos.backend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends  JpaRepository<Rol, Long> {
    // Metodo para buscar un Rol por su nombre (necesario para la inicialización)
    Optional<Rol> findByNombre(String nombre);
}
