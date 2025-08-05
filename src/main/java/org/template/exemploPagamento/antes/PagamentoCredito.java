package org.template.exemploPagamento.antes;

import org.template.exemploPagamento.depois.Gateway;
import org.template.exemploPagamento.depois.Pagamento;

public class PagamentoCredito extends Pagamento {
    public PagamentoCredito(double valor, Gateway gateway) {
        super(valor, gateway);
    }

    public double calcularTaxa() { return getValor() * 0.05; }
    public double calcularDesconto() {return getValor() > 300 ? getValor() * 0.02 : 0; }
}
