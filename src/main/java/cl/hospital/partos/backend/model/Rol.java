package cl.hospital.partos.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Rol: Mapea la tabla 'rol' de PostgreSQL.
 * Contiene los roles de seguridad del sistema (ADMIN, MEDICO, etc.).
 */
@Entity
@Table(name = "rol")
@Data // Genera getters, setters, toString, equals y hashCode (Lombok)
@NoArgsConstructor // Genera constructor sin argumentos (Lombok)
@AllArgsConstructor // Genera constructor con todos los argumentos (Lombok)
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El nombre del rol debe ser único (configurado en la BD y por JPA)
    private String nombre;
}
