package strategy.exemploDescontos.depois;

import strategy.exemploDescontos.depois.domain.Compra;
import strategy.exemploDescontos.depois.strategy.DescontoStrategy;

public class CalculadoraDeDescontos {
    private DescontoStrategy estrategia;

    public double calcular(Compra compra) {
        return estrategia.aplicarDesconto(compra);
    }

    public void setEstrategia(DescontoStrategy estrategia) {
        this.estrategia = estrategia;
    }
}
