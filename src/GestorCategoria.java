import java.util.ArrayList;
import java.util.List;

public class GestorCategoria {
    private List<Categoria> categorias;

    public GestorCategoria() {
        this.categorias = new ArrayList<>();
    }

    // Listar Categorias
    public List<Categoria> listarCategorias() {
        return categorias;
    }
}
