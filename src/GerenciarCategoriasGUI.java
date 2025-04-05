import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GerenciarCategoriasGUI extends JFrame {
    // Add Referencia, lista de categorias, modelo de armazenamento, botões, campo do nome
    private GestorCategoria gestorCategoria;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JButton editButton;
    private JButton removeButton;
    private JButton addButton;
    private JTextField nameField;
    private JComboBox<String> typeComboBox;
    private List<Categoria> categorias; // armazenadas

    public GerenciarCategoriasGUI(GestorCategoria gestorCategoria) {        // Recebe referencia
        this.gestorCategoria = gestorCategoria;
        categorias = gestorCategoria.getCategorias();    // puxa as categorias
        initialize();         // init na interface
    }

    private void initialize() {
        setTitle("Gerenciar Categorias");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha a janela sem fechar tudo
        setLayout(new BorderLayout());

        
        listModel = new DefaultListModel<>();        // modelo das categoras
        atualizarListaCategorias();

        
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);    // scroll na lista
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());        // tela pra editar a categoria

        nameField = new JTextField(15);
        typeComboBox = new JComboBox<>(new String[]{"DESPEZA", "RECEITA"});    

        panel.add(new JLabel("Nome:"));
        panel.add(nameField);
        panel.add(new JLabel("Tipo:"));
        panel.add(typeComboBox);

        add(panel, BorderLayout.NORTH);

        // Botões
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Adicionar");
        editButton = new JButton("Editar");
        removeButton = new JButton("Remover");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

  
        addButton.addActionListener(new ActionListener() {            // Add Categoria
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();                    // get nome da categoria
                TipoCategoria type = TipoCategoria.valueOf(typeComboBox.getSelectedItem().toString());

                
                gestorCategoria.adicionarCategoria(name, type);    
                atualizarListaCategorias(); // Att lista
                JOptionPane.showMessageDialog(null, "Categoria adicionada com sucesso!");
            }
        });

        editButton.addActionListener(new ActionListener() {    // editar categorias
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    // Pega a categoria selecionada
                    Categoria selectedCategory = categorias.get(selectedIndex);

                    // Preenche o campo de texto com o nome da categoria selecionada
                    nameField.setText(selectedCategory.getNome());
                    typeComboBox.setSelectedItem(selectedCategory.getTipo().toString());
 
                    addButton.setText("Atualizar");      // quando seleciona uma categoria ele muda pra editar (está com problema pq não volta pra adicionar)
                    addButton.removeActionListener(addButton.getActionListeners()[0]); 
                    addButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String newName = nameField.getText();             // get nome novo
                            TipoCategoria newType = TipoCategoria.valueOf(typeComboBox.getSelectedItem().toString());

                            
                            gestorCategoria.removerCategoria(selectedCategory.getNome());        // Atualiza a categoria no gestor
                            gestorCategoria.adicionarCategoria(newName, newType);

                            atualizarListaCategorias();
                            JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!");
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma categoria para editar.");
                }
            }
        });

        // Ação para remover categoria
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    Categoria selectedCategory = categorias.get(selectedIndex);         // Pega a categoria selecionada

                    gestorCategoria.removerCategoria(selectedCategory.getNome());
                    atualizarListaCategorias();
                    JOptionPane.showMessageDialog(null, "Categoria removida com sucesso!");            // Remove a categoria
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma categoria para remover.");
                }
            }
        });
    }

    private void atualizarListaCategorias() {             // Atualiza a lista de categorias na interface (Teste)
        listModel.clear();
        for (Categoria categoria : categorias) {
            listModel.addElement(categoria.getNome() + " - " + categoria.getTipo());
        }
    }

    public void exibir() {
        setVisible(true);
    }
}
