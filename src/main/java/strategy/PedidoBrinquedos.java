package strategy;

import strategy.frete.Frete;

public class PedidoBrinquedos extends Pedido {
    private String nomeDoSetor;

    public PedidoBrinquedos(double valor, Frete tipoFrete) {
        super(valor, tipoFrete);
        this.nomeDoSetor = "Brinquedos";
    }

    public String getNomeDoSetor() {
        return nomeDoSetor;
    }

    public void setNomeDoSetor(String nomeDoSetor) {
        this.nomeDoSetor = nomeDoSetor;
    }
}