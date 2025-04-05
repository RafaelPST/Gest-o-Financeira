import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorTransacoes {
    private List<Transacao> transacoes;

    public GestorTransacoes() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(double valor, Categoria categoria, Date data, String descricao) {           // adiciona transacao nova
    }

  
    public List<Transacao> filtrarTransacoes(Categoria categoria, TipoCategoria tipo, Date dataInicio, Date dataFim) {      // filtrar transacoes 
        List<Transacao> transacoesFiltradas = new ArrayList<>();

        for (Transacao t : transacoes) {
            boolean dentroDoPeriodo = isWithinPeriod(t.getData(), dataInicio, dataFim);
            boolean mesmaCategoria = t.getCategoria().equals(categoria);
            boolean mesmoTipo = t.getCategoria().getTipo().equals(tipo); 

            if (dentroDoPeriodo && mesmaCategoria && mesmoTipo) {                        // condicoes para exibicao
                transacoesFiltradas.add(t);
            }
        }

        return transacoesFiltradas;
    }

    private boolean isWithinPeriod(Date dataTransacao, Date dataInicio, Date dataFim) {          // verifica se a transacao esta dentro das datas selecionadas
        return (dataTransacao.after(dataInicio) || dataTransacao.equals(dataInicio)) &&
                (dataTransacao.before(dataFim) || dataTransacao.equals(dataFim));
    }

    public List<Transacao> getTransacoes() {
        return transacoes;                          // Lista todas as transacoes
    }
}
