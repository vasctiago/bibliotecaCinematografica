package sistema;

public class Livro {
    private String titulo;
    private String autor;
    private int anoDeLancamento;
    private String sinopse;
    private Genero genero;
    private String editora;
    private String isbn;
    private Filme filme;
    private String serie;
    private boolean temAdaptacao;
    public Livro(String titulo, String autor, int anoDeLancamento, String sinopse, Genero genero, String editora, String isbn, boolean temAdaptacao, Filme filme,String serie){
        this.titulo = titulo;
        this.autor = autor;
        this.anoDeLancamento = anoDeLancamento;
        this.sinopse = sinopse;
        this.genero = genero;
        this.editora = editora;
        this.isbn = isbn;
        this.temAdaptacao = temAdaptacao;
        this.filme = filme;
        this.serie = serie;
        
    }
    public Livro(){
        this("","",0,"", null, "", "",false, null,null);
    }
    public void setSerie(String serie){
        this.serie = serie;
    }
    public String getSerie(){
        return this.serie;
    }
    public void setFilme(Filme filme){
        this.filme = filme;
    }
    public Filme getFilme(){
        return this.filme;
    }
    public boolean getTemAdaptacao(){
        return this.temAdaptacao;
    }
    public void setTemAdaptacao(boolean temAdaptacao){
        this.temAdaptacao = temAdaptacao;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", sinopse='" + sinopse + '\'' +
                ", genero=" + genero +
                ", editora='" + editora + '\'' +
                ", isbn='" + isbn + '\'' +
                ", TemAdaptacao="+temAdaptacao+
                '}';
    }
}
