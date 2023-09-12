import java.util.List;

class EstrategiaTotal implements EstrategiaCalculoMensalidade {
    public double calcularMensalidade(double saldo, List<Movimento> historicoMovs) {
        double percertualDisconto = saldo <= 200 ? 0 : saldo >= 2000 ? 1 : (saldo - 200) / 1800;
        return 50 * (1 - percertualDisconto);
    }
}

