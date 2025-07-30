package strategy.frete;

public class FreteExpresso implements Frete {
    @Override
    public double calcular(double valor) {
        return valor * 0.1;
    }
}
