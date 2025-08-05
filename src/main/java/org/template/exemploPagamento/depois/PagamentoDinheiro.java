package org.template.exemploPagamento.depois;

public class PagamentoDinheiro {
    private double valor;
    private Gateway gateway;

    public PagamentoDinheiro(double valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    public double calcularDesconto() {
        return valor * 0.01;
    }

    public boolean realizaCobranca() {
        return gateway.cobrar(valor);
    }
}
