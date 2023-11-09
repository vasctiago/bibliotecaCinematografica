package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sistema.Exceptions.LivroJaExisteException;
import sistema.Exceptions.LivroNaoExisteException;
import sistema.Exceptions.NaoEhSerieException;

public class SistemaCadastro {
    private Map<String, Livro> livros;

    SistemaCadastro(){
        this.livros =  PersistenciaDeDadosLivros.carregarLivros();
    }
    public void cadastrarLivro(String titulo, String autor, int anoDeLancamento, String sinopse, Genero genero, String editora, String isbn, boolean temAdaptacao, Filme filme,String serie) throws LivroJaExisteException{
        if(!livros.containsKey(isbn)){
            livros.put(isbn,new Livro(titulo, autor, anoDeLancamento, sinopse, genero, editora, isbn, temAdaptacao, filme, serie));
        }
        else{
            throw new LivroJaExisteException("Já xiste um livro de código ISBN"+isbn);
        }
    }
    public void removerLivro(String isbn) throws LivroNaoExisteException{
        if(livros.containsKey(isbn)){
            livros.remove(isbn);
        }
        else{
            throw new LivroNaoExisteException("O livro com o ISBN "+ isbn +" não existe");
        }
    }
    //Métodos para pesquisar livros com base em diferentes critérios (ISBN, título, autor, editora, anoDeLancamento, tituloFilme
    public List<Livro> pesquisarPorIsbn(String isbn){
        List<Livro> livros = new ArrayList<>();
        for(Livro c:this.livros.values()){
            if(c.getIsbn().equalsIgnoreCase(isbn)){
                livros.add(c);
            }
        }
        return livros;
    }
    public List<Livro> pesquisarPorTitulo(String tituloLivro){
        List<Livro> livros = new ArrayList<>();
        for(Livro c:this.livros.values()){
            if(c.getTitulo().equalsIgnoreCase(tituloLivro)){
                livros.add(c);
            }
        }
        return livros;
    }
    public List<Livro> pesquisarPorAutor(String nomeAutor){
        List<Livro> livros = new ArrayList<>();
        for(Livro c:this.livros.values()){
            if(c.getAutor().equalsIgnoreCase(nomeAutor)){
                livros.add(c);
            }
        }
        return livros;
    }
    public List<Livro> pesquisarPorEditora(String nomeEditora){
        List<Livro> livros = new ArrayList<>();
        for(Livro c:this.livros.values()){
            if(c.getEditora().equalsIgnoreCase(nomeEditora)){
                livros.add(c);
            }
        }
        return livros;
    }
    public List<Livro> pesquisarPorAnoDeLancamento(int anoLancamento){
        List<Livro> livros = new ArrayList<>();
        for(Livro c:this.livros.values()){
            if(c.getAnoDeLancamento() == (anoLancamento)){
                livros.add(c);
            }
        }
        return livros;
    }
    public List<Livro> pesquisarPorTituloDeFilme(String tituloFilme){
        List<Livro> livros = new ArrayList<>();
        for(Livro c:this.livros.values()){
            if(c.getFilme().getTitulo().equalsIgnoreCase(tituloFilme)){
                livros.add(c);
            }
        }
        return livros;
    }
    //lista de todos os livros sem adaptações
    public List<Livro> livrosSemAdaptacao(){
        List<Livro> livrosSelecionados = new ArrayList<>();
        for(Livro c : this.livros.values()){
            if(!c.getTemAdaptacao()){
                livrosSelecionados.add(c);
            }
        }return livrosSelecionados;
    }
    //lista de livros com adaptacoes
    public List<Livro> livrosComAdaptacao(){
        List<Livro> livrosSelecionados = new ArrayList<>();
        for(Livro c : this.livros.values()){
            if(c.getTemAdaptacao()){
                livrosSelecionados.add(c);
            }
        }return livrosSelecionados;
    }
    //livros que fazem parte de uma serie de livros
    public List<Livro> pesquisarPorSerie(String nomeSerie) throws NaoEhSerieException{
        List<Livro> livrosDaSerie = new ArrayList<>();
        for (Livro c : this.livros.values()) {
            if (c.getSerie()!=null && c.getSerie().equalsIgnoreCase(nomeSerie)) {
                livrosDaSerie.add(c);
            }
        }
        return livrosDaSerie;
    }

    
}