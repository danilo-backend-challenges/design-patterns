package strategy.exemploFrete;

import strategy.exemploFrete.fretes.FreteComum;

public class Main {
    public static void main(String[] args) {
        FreteComum freteComum = new FreteComum();

        PedidoBrinquedo pedidoBrinquedo = new PedidoBrinquedo(100);
        PedidoEletronico pedidoEletronico = new PedidoEletronico(100);

        pedidoEletronico.setTipoFrete(freteComum);

        System.out.println(pedidoEletronico.calcularFrete());
    }
}
