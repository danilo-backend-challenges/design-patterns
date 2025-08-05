package org.strategy.exemploDescontos.depois.strategy;

import org.strategy.exemploDescontos.depois.domain.Compra;

public class DescontoSem implements DescontoStrategy{
    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal();
    }
}
