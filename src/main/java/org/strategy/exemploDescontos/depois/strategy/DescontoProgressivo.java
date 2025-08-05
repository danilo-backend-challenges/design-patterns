package org.strategy.exemploDescontos.depois.strategy;

import org.strategy.exemploDescontos.depois.domain.Compra;

public class DescontoProgressivo implements DescontoStrategy{
    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal() < 500 ? compra.getValorTotal() * 0.1 : compra.getValorTotal() * 0.2;
    }
}
