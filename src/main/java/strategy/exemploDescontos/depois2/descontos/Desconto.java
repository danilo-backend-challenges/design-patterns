package strategy.exemploDescontos.depois2.descontos;

import strategy.exemploDescontos.depois2.domain.Compra;

public interface Desconto {
    double aplicarDesconto(Compra compra);
}
