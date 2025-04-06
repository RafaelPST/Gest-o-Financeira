import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConsultaTransacoesGUI {
    private JFrame frame;
    private GestorTransacoes gestorTransacoes;
    private GestorCategoria gestorCategoria;

    public ConsultaTransacoesGUI(GestorTransacoes gestorTransacoes, GestorCategoria gestorCategoria) {
        this.gestorTransacoes = gestorTransacoes;
        this.gestorCategoria = gestorCategoria;
        initialize();
    }

    private void initialize() {
        // configura o frame
        frame = new JFrame("Consulta de Transações");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // add componentes, tabela etc
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // exibe transações -> verificar qual é melhor para usar o TextArea ou o JTable
        List<Transacao> transacoes = gestorTransacoes.getTransacoes();
        for (Transacao transacao : transacoes) {
            textArea.append("Valor: " + transacao.getValor() + ", Categoria: " + transacao.getCategoria().getNome() +
                    ", Data: " + transacao.getData() + ", Descrição: " + transacao.getDescricao() + "\n");
        }

        frame.setVisible(true);
    }

    // Metodo que  exibir a tela
    public void exibir() {
        frame.setVisible(true);
    }
}
