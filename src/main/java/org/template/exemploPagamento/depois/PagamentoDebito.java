package org.template.exemploPagamento.depois;

public class PagamentoDebito {
    private double valor;
    private Gateway gateway;

    public PagamentoDebito(double valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    public double calcularTaxa() {
        return 4;
    }

    public double calcularDesconto() {
        return valor * 0.02;
    }

    public boolean realizaCobranca() {
        return gateway.cobrar(valor);
    }
}
