package org.strategy.exemploDescontos.depois2.descontos;

import org.strategy.exemploDescontos.depois2.domain.Compra;

public interface Desconto {
    double aplicarDesconto(Compra compra);
}
