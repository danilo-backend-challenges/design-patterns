package org.template.exemploPagamento.depois;

public class PagamentoCredito {
    private double valor;
    private Gateway gateway;

    public PagamentoCredito(double valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    public double calcularTaxa() {
        return valor * 0.05;
    }

    public double calcularDesconto() {
        return valor > 300 ? valor * 0.02 : 0;
    }

    public boolean realizaCobranca() {
        return gateway.cobrar(valor);
    }
}
