package strategy.exemploDescontos.depois.strategy;

import strategy.exemploDescontos.depois.domain.Compra;

public interface DescontoStrategy {
    double aplicarDesconto(Compra compra);
}
