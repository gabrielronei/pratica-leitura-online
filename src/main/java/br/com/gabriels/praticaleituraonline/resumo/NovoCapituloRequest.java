package br.com.gabriels.praticaleituraonline.resumo;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

class NovoCapituloRequest {

    @NotBlank
    private final String titulo;

    @Lob
    @NotBlank
    private final String texto;

    @Positive
    private final int ordem;

    public NovoCapituloRequest(String titulo, String texto, int ordem) {
        this.titulo = titulo;
        this.texto = texto;
        this.ordem = ordem;
    }

    public Capitulo toModel() {
        return new Capitulo(this.titulo, this.texto, this.ordem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovoCapituloRequest that = (NovoCapituloRequest) o;
        return ordem == that.ordem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordem);
    }
}
