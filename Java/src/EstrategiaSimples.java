import java.util.List;

class EstrategiaSimples implements EstrategiaCalculoMensalidade {
    public double calcularMensalidade(double saldo, List<Movimento> historicoMovs) {
        double custoMov = historicoMovs.size() <= 5 ? 0 : (historicoMovs.size() - 5) * 1;
        double percertualDisconto = saldo <= 100 ? 0 : saldo >= 1500 ? 1 : (saldo - 100) / 1400;
        return (20 + custoMov) * (1 - percertualDisconto);
    }
}
