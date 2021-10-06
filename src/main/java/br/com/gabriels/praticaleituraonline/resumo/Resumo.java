package br.com.gabriels.praticaleituraonline.resumo;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
class Resumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @OrderBy("ordem")
    @Size(min = 1)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resumo_id")
    private SortedSet<Capitulo> capitulos = new TreeSet<>();

    @Deprecated
    public Resumo() {
    }

    public Resumo(String titulo, SortedSet<Capitulo> capitulos) {
        Assert.hasText(titulo, "O titulo é obrigatório");
        Assert.isTrue(capitulos.size() > 0, "Você precisa ter ao menos um capitulo");

        this.titulo = titulo;
        this.capitulos = capitulos;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getNumeroCapitulos() {
        return this.capitulos.size();
    }

    public String getComecoDoPrimeiroCapitulo() {
        return this.capitulos.first().getTextoLimitadoCinquentaCaracteres();
    }
}
