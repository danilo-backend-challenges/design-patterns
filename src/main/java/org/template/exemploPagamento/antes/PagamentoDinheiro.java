package org.template.exemploPagamento.antes;

import org.template.exemploPagamento.depois.Gateway;
import org.template.exemploPagamento.depois.Pagamento;

public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro(double valor, Gateway gateway) {
        super(valor, gateway);
    }

    public double calcularDesconto() {
        return getValor() * 0.01;
    }
}
