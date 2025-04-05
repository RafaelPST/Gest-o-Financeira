import java.util.ArrayList;
import java.util.List;

public class GestorCategoria {
    private List<Categoria> categorias;

    public GestorCategoria() {
        this.categorias = new ArrayList<>();
    }

    public List<Categoria> listarCategorias() {               // Lista categoria              
        return categorias;
    }
    
    public void adicionarCategoria(String nome, TipoCategoria tipo) {           
        Categoria categoria = new Categoria(nome, tipo);                          // Adiciona categoria nova
        categorias.add(categoria);                                                    
        System.out.println("Categoria '" + nome + "' adicionada com sucesso!");
    }
}
