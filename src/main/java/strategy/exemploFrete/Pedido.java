package strategy.exemploFrete;

import strategy.exemploFrete.fretes.Frete;

public abstract class Pedido {
    private double valor;
    private Frete tipoFrete;

    public Pedido(double valor) {
        this.valor = valor;
    }

    public double calcularFrete() {
        return tipoFrete.calcular(valor);
    }

    public void setTipoFrete(Frete tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
