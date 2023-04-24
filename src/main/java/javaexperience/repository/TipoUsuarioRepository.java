package javaexperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javaexperience.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

}
