package br.com.gabriels.praticaleituraonline.resumo;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
class Capitulo implements Comparable<Capitulo> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @Lob
    @NotBlank
    private String texto;

    @Positive
    private int ordem;

    @Deprecated
    public Capitulo() {
    }

    public Capitulo(String titulo, String texto, int ordem) {
        Assert.hasText(titulo, "O titulo é obrigatório!");
        Assert.hasText(texto, "O texto é obrigatório!");
        Assert.state(ordem > 0, "A ordem precisa ser positiva!");

        this.titulo = titulo;
        this.texto = texto;
        this.ordem = ordem;
    }

    public String getTextoLimitadoCinquentaCaracteres() {
        return this.texto.substring(0, Math.min(this.texto.length(), 50));
    }

    @Override
    public int compareTo(Capitulo segundoCapitulo) {
        return this.ordem - segundoCapitulo.ordem;
    }
}
