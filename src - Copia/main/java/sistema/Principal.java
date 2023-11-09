package sistema;

import javax.swing.JOptionPane;
import java.util.List;
import sistema.Exceptions.*;


public class Principal {
    public static void main(String[] args) {
        SistemaCadastro sistema = new SistemaCadastro();

        while (true) {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                    "1 - Cadastrar Livro\n" +
                    "2 - Remover Livro\n" +
                    "3 - Pesquisar por ISBN\n" +
                    "4 - Listar Livros com Adaptação\n" +
                    "5 - Pesquisar por Série\n" +
                    "0 - Sair"
            ));

            switch (escolha) {
                case 1:
                    // Cadastro de Livro
                    String titulo = JOptionPane.showInputDialog("Título do Livro:");
                    String autor = JOptionPane.showInputDialog("Autor:");
                    int anoDeLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de Lançamento:"));
                    String sinopse = JOptionPane.showInputDialog("Sinopse:");

                    // Usando caixa de diálogo de botões para "Tem Adaptação"
                    int adaptacaoEscolhida = JOptionPane.showOptionDialog(
                            null,
                            "Tem Adaptação?",
                            "Escolha",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"Sim", "Não"},
                            "Sim"
                    );
                    boolean temAdaptacao = adaptacaoEscolhida == 0;

                    // Usando caixa de diálogo de seleção para o gênero
                    Genero[] generos = Genero.values();
                    Genero genero = (Genero) JOptionPane.showInputDialog(
                            null,
                            "Selecione o Gênero:",
                            "Seleção de Gênero",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            generos,
                            generos[0]
                    );

                    String editora = JOptionPane.showInputDialog("Editora:");
                    String isbn = JOptionPane.showInputDialog("ISBN:");
                    String nomeFilme = JOptionPane.showInputDialog("Título do Filme (ou deixe em branco se não houver filme):");
                    String serie = JOptionPane.showInputDialog("Série do Livro (ou deixe em branco se não fizer parte de uma série):");

                    Filme filme = null;
                    if (!nomeFilme.isEmpty()) {
                        int anoFilme = Integer.parseInt(JOptionPane.showInputDialog("Ano de Lançamento do Filme:"));
                        String plataforma = JOptionPane.showInputDialog("Plataforma do Filme:");
                        filme = new Filme(nomeFilme, anoFilme, plataforma, temAdaptacao);
                    }

                    try {
                        sistema.cadastrarLivro(titulo, autor, anoDeLancamento, sinopse, genero, editora, isbn, temAdaptacao, filme, serie);
                        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                    } catch (LivroJaExisteException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Remoção de Livro
                    String isbnRemover = JOptionPane.showInputDialog("ISBN do Livro a ser removido:");
                    try {
                        sistema.removerLivro(isbnRemover);
                        JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
                    } catch (LivroNaoExisteException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao remover livro: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Pesquisa por ISBN
                    String isbnPesquisar = JOptionPane.showInputDialog("ISBN a ser pesquisado:");
                    List<Livro> livrosEncontrados = sistema.pesquisarPorIsbn(isbnPesquisar);
                    if (livrosEncontrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com o ISBN fornecido.");
                    } else {
                        StringBuilder result = new StringBuilder("Livros encontrados por ISBN:\n");
                        for (Livro livro : livrosEncontrados) {
                            result.append("Título: ").append(livro.getTitulo()).append("\n");
                            result.append("Autor: ").append(livro.getAutor()).append("\n");
                            result.append("Ano de Lançamento: ").append(livro.getAnoDeLancamento()).append("\n");
                            result.append("Sinopse: ").append(livro.getSinopse()).append("\n");
                            result.append("Gênero: ").append(livro.getGenero()).append("\n");
                            result.append("Editora: ").append(livro.getEditora()).append("\n");
                            result.append("Série: ").append(livro.getSerie()).append("\n");
                            result.append("Tem Adaptação: ").append(livro.getTemAdaptacao()).append("\n");
                            if (livro.getTemAdaptacao() && livro.getFilme() != null) {
                                result.append("Filme: ").append(livro.getFilme().getTitulo()).append("\n");
                                result.append("Ano de Lançamento do Filme: ").append(livro.getFilme().getAnoDeLancamento()).append("\n");
                                result.append("Plataforma do Filme: ").append(livro.getFilme().getPlataforma()).append("\n");
                            }
                            result.append("\n");
                        }
                        JOptionPane.showMessageDialog(null, result.toString());
                    }
                    break;

                case 4:
                    // Lista de Livros com Adaptação
                    List<Livro> livrosComAdaptacao = sistema.livrosComAdaptacao();
                    if (livrosComAdaptacao.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro com adaptação encontrado.");
                    } else {
                        StringBuilder result = new StringBuilder("Livros com adaptação:\n");
                        for (Livro livro : livrosComAdaptacao) {
                            result.append("Título: ").append(livro.getTitulo()).append("\n");
                            result.append("Autor: ").append(livro.getAutor()).append("\n");
                            result.append("Ano de Lançamento: ").append(livro.getAnoDeLancamento()).append("\n");
                            result.append("Sinopse: ").append(livro.getSinopse()).append("\n");
                            result.append("Gênero: ").append(livro.getGenero()).append("\n");
                            result.append("Editora: ").append(livro.getEditora()).append("\n");
                            result.append("Série: ").append(livro.getSerie()).append("\n");
                            result.append("Tem Adaptação: ").append(livro.getTemAdaptacao()).append("\n");
                            if (livro.getTemAdaptacao() && livro.getFilme() != null) {
                                result.append("Filme: ").append(livro.getFilme().getTitulo()).append("\n");
                                result.append("Ano de Lançamento do Filme: ").append(livro.getFilme().getAnoDeLancamento()).append("\n");
                                result.append("Plataforma do Filme: ").append(livro.getFilme().getPlataforma()).append("\n");
                            }
                            result.append("\n");
                        }
                        JOptionPane.showMessageDialog(null, result.toString());
                    }
                    break;

                case 5:
                    // Pesquisa por Série
                    String seriePesquisar = JOptionPane.showInputDialog("Série a ser pesquisada:");
                    try {
                        List<Livro> livrosDaSerie = sistema.pesquisarPorSerie(seriePesquisar);
                        if (livrosDaSerie.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado nessa série.");
                        } else {
                            StringBuilder result = new StringBuilder("Livros da série '" + seriePesquisar + "':\n");
                            for (Livro livro : livrosDaSerie) {
                                result.append("Título: ").append(livro.getTitulo()).append("\n");
                                result.append("Autor: ").append(livro.getAutor()).append("\n");
                                result.append("Ano de Lançamento: ").append(livro.getAnoDeLancamento()).append("\n");
                                result.append("Sinopse: ").append(livro.getSinopse()).append("\n");
                                result.append("Gênero: ").append(livro.getGenero()).append("\n");
                                result.append("Editora: ").append(livro.getEditora()).append("\n");
                                result.append("Tem Adaptação: ").append(livro.getTemAdaptacao()).append("\n");
                                if (livro.getTemAdaptacao() && livro.getFilme() != null) {
                                    result.append("Filme: ").append(livro.getFilme().getTitulo()).append("\n");
                                    result.append("Ano de Lançamento do Filme: ").append(livro.getFilme().getAnoDeLancamento()).append("\n");
                                    result.append("Plataforma do Filme: ").append(livro.getFilme().getPlataforma()).append("\n");
                                }
                                result.append("\n");
                            }
                            JOptionPane.showMessageDialog(null, result.toString());
                        }
                    } catch (NaoEhSerieException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao pesquisar por série: " + e.getMessage());
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}