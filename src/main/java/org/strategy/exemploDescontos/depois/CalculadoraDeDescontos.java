package org.strategy.exemploDescontos.depois;

import org.strategy.exemploDescontos.depois.domain.Compra;
import org.strategy.exemploDescontos.depois.strategy.DescontoStrategy;

public class CalculadoraDeDescontos {
    private DescontoStrategy estrategia;

    public double calcular(Compra compra) {
        return estrategia.aplicarDesconto(compra);
    }

    public void setEstrategia(DescontoStrategy estrategia) {
        this.estrategia = estrategia;
    }
}
