package br.com.gabriels.praticaleituraonline.usuario;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @Deprecated
    public Usuario() {
    }

    public Usuario(@NotBlank @Email String email) {
        Assert.hasText(email, "O email é obrigatório");

        this.email = email;
    }

    public Long getId() {
        return this.id;
    }
}
