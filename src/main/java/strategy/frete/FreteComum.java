package strategy.frete;

public class FreteComum implements Frete {
    @Override
    public double calcular(double valor) {
        return valor * 0.05;
    }
}
