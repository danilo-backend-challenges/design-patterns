package strategy;

import strategy.frete.Frete;

public class PedidoEletronicos extends Pedido {
    private String nomeDoSetor;

    public PedidoEletronicos(double valor, Frete tipoFrete) {
        super(valor, tipoFrete);
        this.nomeDoSetor = "Eletrônicos";
    }

    public String getNomeDoSetor() {
        return nomeDoSetor;
    }

    public void setNomeDoSetor(String nomeDoSetor) {
        this.nomeDoSetor = nomeDoSetor;
    }
}

