public class Categoria {
    //atributos
    private String nome;
    private String tipo;

    //construtores
    public Categoria(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
    public Categoria(){

    }

    //métodos

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
