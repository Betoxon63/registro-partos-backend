package cl.hospital.partos.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Usuario: Mapea la tabla 'usuario' de PostgreSQL.
 * Contiene la información básica del usuario y su relación con un Rol.
 */
@Entity
@Table(name = "usuario")
@Data // Genera getters, setters, toString, equals y hashCode (Lombok)
@NoArgsConstructor // Genera constructor sin argumentos (Lombok)
@AllArgsConstructor // Genera constructor con todos los argumentos (Lombok)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Se asegura que el nombre de usuario sea único a nivel de BD
    @Column(name = "nombre_usuario", unique = true, nullable = false)
    private String nombreUsuario;

    // La contraseña debe ser robusta (aquí se almacenará el hash)
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    // Relación Many-to-One: Muchos Usuarios a un solo Rol
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false) // Columna de la clave foránea
    private Rol rol;
}
