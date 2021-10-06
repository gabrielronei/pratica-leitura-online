package br.com.gabriels.praticaleituraonline.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.validation.Valid;

@RestController
public class NovoUsuarioController {

    @PersistenceContext
    private final EntityManager entityManager;

    public NovoUsuarioController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping("/usuarios")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid NovoUsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequest.toModel();
        entityManager.persist(usuario);
        return ResponseEntity.ok(usuario.getId());
    }
}
