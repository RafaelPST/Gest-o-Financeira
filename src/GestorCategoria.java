import java.util.ArrayList;
import java.util.List;

public class GestorCategoria {
    private List<Categoria> categorias;

    public GestorCategoria() {
        this.categorias = new ArrayList<>();
    }

    public List<Categoria> listarCategorias() {                 
        return categorias;
    }
    
    public void adicionarCategoria(String nome, TipoCategoria tipo) {           
        Categoria categoria = new Categoria(nome, tipo);                          // Adiciona categoria nova
        categorias.add(categoria);                                                    
        System.out.println("Categoria '" + nome + "' adicionada com sucesso!");
    }

    public void removerCategoria(String nome) {
        categorias.removeIf(categoria -> categoria.getNome().equals(nome));         // Remove uma categoria
    }

    public List<Categoria> listarCategorias() {
    return categorias;                                                           // Lista as Categorias
    }

    public void editarCategoria(String nomeAntigo, String nomeNovo, TipoCategoria tipoNovo) {
    for (Categoria categoria : categorias) {
        if (categoria.getNome().equals(nomeAntigo)) {
            categoria.setNome(nomeNovo);                    // Editar uma categoria
            categoria.setTipo(tipoNovo);
            break;
            }
        }
    }
}
