package org.strategy.exemploFrete.fretes;

public class FreteExpresso implements Frete {
    @Override
    public double calcular(double valor) {
        return valor * 0.05;
    }
}