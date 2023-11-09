package sistema;
import sistema.Exceptions.*;

public class TestaSistema {

    public static void main(String[] args) {
        SistemaCadastro sistema = new SistemaCadastro();

        try {
            sistema.cadastrarLivro("A cinco passos de você", "Rachael Lippincott", 2018,
                    "Doença genética rara impede que os protagonistas fiquem muito próximos.",
                    Genero.ROMANCE, "Editora ait", "9788580419068", true,
                    new Filme("A cinco passos de você: O Filme", 2019, "Amazon Prime", true), "");
            System.out.println("Livro cadastrado com sucesso!");
        } catch (LivroJaExisteException e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }

        System.out.println("\nPesquisa por ISBN:");
        listarLivros(sistema.pesquisarPorIsbn("9788580419068"));

        try {
            sistema.removerLivro("987654321");  // numero errado para lançar exceção
            System.out.println("\nLivro removido com sucesso!");
        } catch (LivroNaoExisteException e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }

        System.out.println("\nPesquisa por Série:");
        try {
            listarLivros(sistema.pesquisarPorSerie("Série Coração"));
        } catch (NaoEhSerieException e) {
            System.out.println("Erro ao pesquisar por série: " + e.getMessage());//serie tá vazio, ele deve lançar exceção
        }
    }

    private static void listarLivros(java.util.List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }
}
