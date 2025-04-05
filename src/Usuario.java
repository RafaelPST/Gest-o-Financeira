public class Usuario {
    //atributos
    private String email;
    private String senha;
    private String nome;

    //construtores
    public Usuario(String email, String senha, String nome){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    public Usuario(){
        email = " ";
        senha = " ";
        nome = " ";
    }

    // metodos get-set
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //metodos de logica de negocio
    //registrar, login, visualizarResump
    public void registrar(String email, String senha, String nome){

    }
    public void logar(String email, String senha){

    }
    public void visualizarResumo(){
        System.out.println("Resumo de Transações: \n");
        // Aqui, poderíamos exibir o histórico de transações desse usuário.
    }
}

