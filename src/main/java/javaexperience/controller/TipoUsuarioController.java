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

import javaexperience.model.TipoUsuario;
import javaexperience.repository.TipoUsuarioRepository;

@RestController
public class TipoUsuarioController {

    @PostMapping(value = "/tipoUsuarios")
    public TipoUsuario criarNovoTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @GetMapping(value = "/tipoUsuarios")
    public List<TipoUsuario> obterTipoUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    @GetMapping(value = "/tipoUsuarios/{id}")
    public Optional<TipoUsuario> obterTipoPeloId(@PathVariable(value = "id") Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    @DeleteMapping(value = "/tipoUsuarios/{id}")
    public String deletarTiposPeloId(@PathVariable(value = "id") Long id) {
        tipoUsuarioRepository.deleteById(id);

        return "Tipo deletado com sucesso!";
    }

    // Ver aqui se o tipo do id é esse mesmo já que nos models tá long.

    @PutMapping(value = "/tipoUsuarios")
    public TipoUsuario atualizarTipo(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

}
