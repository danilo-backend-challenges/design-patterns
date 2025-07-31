package strategy.exemploDescontos.depois.strategy;

import strategy.exemploDescontos.depois.domain.Compra;

public class DescontoPercentual implements DescontoStrategy {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal() * (1 - percentual / 100);
    }
}
