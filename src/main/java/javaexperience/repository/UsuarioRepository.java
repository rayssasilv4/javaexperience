package javaexperience.repository;

import java.util.Optional;

import org.hibernate.type.descriptor.java.LongJavaType;
import org.springframework.data.jpa.repository.JpaRepository;

import javaexperience.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, LongJ> {

    Optional<Usuario> findByEmail(String email);

}
