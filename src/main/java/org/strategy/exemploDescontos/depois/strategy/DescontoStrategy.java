package org.strategy.exemploDescontos.depois.strategy;

import org.strategy.exemploDescontos.depois.domain.Compra;

public interface DescontoStrategy {
    double aplicarDesconto(Compra compra);
}
