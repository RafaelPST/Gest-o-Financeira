public class Main {
    public static void main(String[] args) {
        // cria o gestor de usuários e transações
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        GestorTransacoes gestorTransacoes = new GestorTransacoes();
        GestorCategoria gestorCategoria = new GestorCategoria();

        // Adicionar o usuário admin (se não existir)
        gestorUsuarios.registrarUsuario("adm", "Admin4123", "Administrador");

        // tela de login
        CadastroLoginGUI loginGUI = new CadastroLoginGUI(gestorUsuarios);
        loginGUI.exibir();  // Exibe a tela de login

        // se  o login for bem-sucedido sera o redirecionado para o MenuPrincipalGUI onde será feito na classe CadastroLoginGUI
    }
}
