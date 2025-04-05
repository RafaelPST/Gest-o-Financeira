public class Categoria {
    private String nome;
    private TipoCategoria tipo;

    // Construtor
    public Categoria(String nome, TipoCategoria tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }

    // Sobrescreve o metodo toString para exibir o nome da categoria
    @Override
    public String toString() {
        return nome; // Retorna o nome da categoria para exibição
    }
}
