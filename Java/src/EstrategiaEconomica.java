import java.util.List;

class EstrategiaEconomica implements EstrategiaCalculoMensalidade {
    public double calcularMensalidade(double saldo, List<Movimento> historicoMovs) {
        double custoMov = historicoMovs.size() * 1.5;
        return custoMov + 10;
    }
}
