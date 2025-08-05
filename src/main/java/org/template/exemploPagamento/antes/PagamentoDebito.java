package org.template.exemploPagamento.antes;

import org.template.exemploPagamento.depois.Gateway;
import org.template.exemploPagamento.depois.Pagamento;

public class PagamentoDebito extends Pagamento {
    public PagamentoDebito(double valor, Gateway gateway) {
        super(valor, gateway);
    }

    public double calcularTaxa() {
        return 4;
    }
    public double calcularDesconto() { return getValor() * 0.01; }
}
