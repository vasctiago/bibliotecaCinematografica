package sistema;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PersistenciaDeDadosLivros {
    private static final String ARQUIVO = "livros.txt";

    public static void salvarLivros(Map<String, Livro> livros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(livros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Livro> carregarLivros() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (Map<String, Livro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
}
