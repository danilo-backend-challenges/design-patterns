package org.strategy.exemploDescontos.depois.strategy;

import org.strategy.exemploDescontos.depois.domain.Compra;

public class DescontoFixo implements DescontoStrategy {
    private double desconto;

    public DescontoFixo(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double aplicarDesconto(Compra compra) {
        double valorTotal = compra.getValorTotal();

        if (desconto > valorTotal) {
            throw new RuntimeException("Desconto não pode ser maior que o valor total");
        }

        return valorTotal - desconto;
    }
}
