import java.util.List;

interface EstrategiaCalculoMensalidade {
    double calcularMensalidade(double saldo, List<Movimento> historicoMovs);
}
