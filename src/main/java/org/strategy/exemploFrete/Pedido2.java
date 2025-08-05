package org.strategy.exemploFrete;

public abstract class Pedido2 {
    private double valor;
    private String setor;

    public Pedido2(double valor, String setor) {
        this.valor = valor;
        this.setor = setor;
    }

    public double calcularFreteComum() {
        return switch (setor) {
            case "brinquedos" -> valor * 0.1;
            case "eletronicos" -> valor * 0.05;
            case "jardinagem" -> valor * 0.2;
            default -> 0;
        };
    }

     public double calcularFreteExpresso() {
        return switch (setor) {
            case "brinquedos" -> valor * 0.1;
            case "eletronicos" -> valor * 0.05;
            case "jardinagem" -> valor * 0.2;
            default -> 0;
        };
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
