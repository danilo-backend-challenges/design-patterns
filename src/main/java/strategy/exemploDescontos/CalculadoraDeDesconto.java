package strategy.exemploDescontos;

import strategy.exemploDescontos.depois2.domain.Compra;
import strategy.exemploDescontos.depois2.descontos.Desconto;

public class CalculadoraDeDesconto {
    private final Compra compra;
    private final Desconto desconto;

    public CalculadoraDeDesconto(Compra compra, Desconto desconto) {
        this.compra = compra;
        this.desconto = desconto;
    }

    public double calcular() {
        return desconto.aplicarDesconto(compra);
    }
}
