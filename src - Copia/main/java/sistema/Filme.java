package sistema;

public class Filme {
    private String titulo;
    private int anoDeLancamento;
    private String plataforma;

    public Filme(String titulo, int anoDeLancamento, String plataforma, boolean temAdaptacao) {
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.plataforma = plataforma;
    }

    public Filme() {
        this("", 0, "", false);
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Filme [titulo=" + titulo + ", anoDeLancamento=" + anoDeLancamento + ", plataforma=" + plataforma + "]";
    }
}
