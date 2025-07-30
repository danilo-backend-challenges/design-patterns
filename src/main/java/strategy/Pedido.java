package strategy;

import strategy.frete.Frete;

public abstract class Pedido {
    private double valor;
    private Frete tipoFrete;

    public Pedido(double valor, Frete tipoFrete) {
        this.valor = valor;
        this.tipoFrete = tipoFrete;
    }

    public double calculaFrete() {
        return tipoFrete.calcular(valor);
    };

    public Frete getTipoFrete() {
        return tipoFrete;
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