import java.util.Date;
import java.util.List;

public class ResumoFinanceiro {
    private GestorTransacoes gestorTransacoes;  

    public ResumoFinanceiro(GestorTransacoes gestorTransacoes) {
        this.gestorTransacoes = gestorTransacoes;
    }

    public double calcularSaldo(Date inicio, Date fim) {              // Calcular o saldo total (receitas - despesas)
        double receitas = calcularReceitas(inicio, fim);
        double despesas = calcularDespesas(inicio, fim);
        return receitas - despesas;
    }

    public double calcularReceitas(Date inicio, Date fim) {            // Calcula soma em um período
        double somaReceitas = 0.0;
        List<Transacao> transacoes = gestorTransacoes.getTransacoes();

        for (Transacao t : transacoes) {
            if (t.getCategoria().getTipo().equals(TipoCategoria.RECEITA) && isWithinPeriod(t.getData(), inicio, fim)) {
                somaReceitas += t.getValor();
            }
        }
        return somaReceitas;
    }

    public double calcularDespesas(Date inicio, Date fim) {        // Calcula soma das despesas por período
        double somaDespesas = 0.0;
        List<Transacao> transacoes = gestorTransacoes.getTransacoes();

        for (Transacao t : transacoes) {
            if (t.getCategoria().getTipo().equals(TipoCategoria.DESPESA) && isWithinPeriod(t.getData(), inicio, fim)) {
                somaDespesas += t.getValor();
            }
        }
        return somaDespesas;
    }

    private boolean isWithinPeriod(Date data, Date inicio, Date fim) {                            // Verifica se a data está no período
        return (data.after(inicio) || data.equals(inicio)) && (data.before(fim) || data.equals(fim));
    }
    public void exibirResumo(Date inicio, Date fim) {
        double saldo = calcularSaldo(inicio, fim);
        double receitas = calcularReceitas(inicio, fim);             // Exibir o resumo financeiro
        double despesas = calcularDespesas(inicio, fim);

        System.out.println("Resumo Financeiro de " + inicio.toString() + " até " + fim.toString());
        System.out.println("Receitas: R$" + receitas);
        System.out.println("Despesas: R$" + despesas);
        System.out.println("Saldo: R$" + saldo);
    }
}
