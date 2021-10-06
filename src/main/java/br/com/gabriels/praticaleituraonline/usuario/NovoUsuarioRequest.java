package br.com.gabriels.praticaleituraonline.usuario;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.*;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

class NovoUsuarioRequest {

    @NotBlank
    @Email
    private final String email;

    @JsonCreator(mode = PROPERTIES)
    public NovoUsuarioRequest(String email) {
        this.email = email;
    }

    public Usuario toModel() {
        return new Usuario(this.email);
    }
}
