package strategy.exemploDescontos.depois.strategy;

import strategy.exemploDescontos.depois.domain.Compra;

public class DescontoCupom implements DescontoStrategy {
    private final Cupom cupom;

    public DescontoCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal() - cupom.getDesconto();
    }
}
