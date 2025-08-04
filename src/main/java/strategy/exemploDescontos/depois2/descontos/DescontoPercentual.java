package strategy.exemploDescontos.depois2.descontos;

import strategy.exemploDescontos.depois2.domain.Compra;

public class DescontoPercentual implements Desconto {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(Compra compra) {
        return compra.getValorTotal() * (1 - percentual / 100);
    }
}
