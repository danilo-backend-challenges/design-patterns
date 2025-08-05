package org.strategy.exemploDescontos.depois2.descontos;

import org.strategy.exemploDescontos.depois2.domain.Compra;

public class DescontoFixo implements Desconto {
    private double desconto;

    public DescontoFixo(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal() - desconto;
    }
}
