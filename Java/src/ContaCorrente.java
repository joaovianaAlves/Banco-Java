import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ContaCorrente {
    private Cliente cliente;
    private EstrategiaCalculoMensalidade estrategiaCalculo;
    private List<Movimento> historicoMovs;
    private Log log;
    public ContaCorrente(Cliente cliente, EstrategiaCalculoMensalidade estrategiaCalculo) {
        this.historicoMovs = new ArrayList<>();
        this.cliente = cliente;
        this.estrategiaCalculo = estrategiaCalculo;
    }

    public void depositar(String descricao, double valor) {
        historicoMovs.add(new Movimento(valor, descricao));
        Log.getInstance().log("Depósito de " + valor + " realizado: " + descricao);
    }

    public void saque(String descricao, double valor) {
        historicoMovs.add(new Movimento(-valor, descricao));
        Log.getInstance().log("Saque de " + valor + " realizado: " + descricao);
    }

    public double getSaldo() {
        return historicoMovs.stream().mapToDouble(Movimento::getValor).sum();
    }

    public String exibirMensalidade() {
        double saldo = getSaldo();
        double mensalidade = estrategiaCalculo.calcularMensalidade(saldo, historicoMovs);
        return String.format("Mensalidade: R$ %.2f", mensalidade);
    }

    public void trocarEstrategia(EstrategiaCalculoMensalidade novaEstrategia) {
        this.estrategiaCalculo = novaEstrategia;
    }

    public EstrategiaCalculoMensalidade getEstrategia() {
        return estrategiaCalculo;
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Breno");
        ContaCorrente conta = new ContaCorrente(cliente, new EstrategiaTotal());

        conta.depositar("Depósito 1", 1000);

        System.out.println("Cliente: " + cliente.getName());

        System.out.println("Mensalidade Conta Total: " + conta.exibirMensalidade());

        conta.trocarEstrategia(new EstrategiaSimples());
        System.out.println("Mensalidade Conta Simples: " + conta.exibirMensalidade());

        conta.trocarEstrategia(new EstrategiaEconomica());
        System.out.println("Mensalidade Conta Econômica: " + conta.exibirMensalidade());

        System.out.println("Atualização de Saldo");

        conta.saque("Saque 1", 500);

        System.out.println("Mensalidade Conta Total: " + conta.exibirMensalidade());

        conta.trocarEstrategia(new EstrategiaSimples());
        System.out.println("Mensalidade Conta Simples: " + conta.exibirMensalidade());

        conta.trocarEstrategia(new EstrategiaEconomica());
        System.out.println("Mensalidade Conta Econômica: " + conta.exibirMensalidade());


        List<String> logMessages = Log.getInstance().getLogMessages();
        System.out.println("Log de atividades:");
        for (String message : logMessages) {
            System.out.println(message);
        }
    }
}

