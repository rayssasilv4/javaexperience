package javaexperience.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javaexperience.model.Usuario;
import javaexperience.repository.UsuarioRepository;

@RestController
public class UsuarioController {

    @PostMapping(value = "/Usuarios")
    public Usuario criarNovoUsuario(@RequestBody Usuario Usuario) {
        return usuarioRepository.save(Usuario);
    }

    @GetMapping(value = "/usuarios")
    public List<Usuario> obterUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/usuarios/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable(value = "id") Long id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping(value = "/usuarios/{email}")
    public Optional<Usuario> obterUsuarioPeloEmail(@PathVariable(value = "email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @DeleteMapping(value = "/usuarios/{id}")
    public String deletarUsuarioPeloId(@PathVariable(value = "id") Long id) {
        usuarioRepository.deleteById(id);

        return "Usuário deletado com sucesso!";
    }

    // Ver aqui se o tipo dod id é esse mesmo já que nos models tá long.

    @PutMapping(value = "/usuarios")
    public Usuario atualizarTipo(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

}
