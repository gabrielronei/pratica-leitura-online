package br.com.gabriels.praticaleituraonline.resumo;

class ResumoOutputDTO {

    private final String titulo;
    private final int numeroCapitulos;
    private final String resumoPrimeiroCapitulo;

    public ResumoOutputDTO(Resumo resumo) {
        this.titulo = resumo.getTitulo();
        this.numeroCapitulos = resumo.getNumeroCapitulos();
        this.resumoPrimeiroCapitulo = resumo.getComecoDoPrimeiroCapitulo();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroCapitulos() {
        return numeroCapitulos;
    }

    public String getResumoPrimeiroCapitulo() {
        return resumoPrimeiroCapitulo;
    }
}
