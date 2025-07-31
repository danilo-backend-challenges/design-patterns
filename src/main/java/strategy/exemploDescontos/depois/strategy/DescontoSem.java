package strategy.exemploDescontos.depois.strategy;

import strategy.exemploDescontos.depois.domain.Compra;

public class DescontoSem implements DescontoStrategy{
    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal();
    }
}
