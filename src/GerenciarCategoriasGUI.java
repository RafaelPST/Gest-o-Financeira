public class GerenciarCategoriasGUI {
    private JFrame frame;                            //Janela
    private JList<String> listaCategorias;
    private JButton btnAdicionar, btnEditar, btnRemover;        //Botoes
    private GestorCategoria gestorCategoria;


    public GerenciarCategoriasGUI(GestorCategoria gestorCategoria) {
        this.gestorCategoria = gestorCategoria;
        initalize(); 

    }
}
