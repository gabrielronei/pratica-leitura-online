package br.com.gabriels.praticaleituraonline.resumo;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.*;

class NovoResumoRequest {

    @NotBlank
    private final String titulo;

    @Valid
    @Size(min = 1)
    private final Set<NovoCapituloRequest> capitulos;

    public NovoResumoRequest(String titulo, Set<NovoCapituloRequest> capitulos) {
        this.titulo = titulo;
        this.capitulos = capitulos;
    }

    public Resumo toModel() {
        List<Capitulo> capitulos = this.capitulos.stream()
                .map(NovoCapituloRequest::toModel)
                .toList();

        return new Resumo(this.titulo, new TreeSet(capitulos));
    }
}
