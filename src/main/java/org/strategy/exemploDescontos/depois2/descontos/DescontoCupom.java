package org.strategy.exemploDescontos.depois2.descontos;

import org.strategy.exemploDescontos.depois2.domain.Compra;

public class DescontoCupom implements Desconto {
    private final Cupom cupom;

    public DescontoCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal() - cupom.getDesconto();
    }
}
