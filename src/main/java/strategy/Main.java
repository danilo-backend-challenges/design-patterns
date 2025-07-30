package strategy;

import strategy.frete.FreteComum;
import strategy.frete.FreteExpresso;

public class Main {
    public static void main(String[] args) {
        Pedido pedidoEletronicos = new PedidoEletronicos(100, new FreteComum());
        Pedido pedidoBrinquedo = new PedidoBrinquedos(100, new FreteExpresso());

        System.out.println(pedidoBrinquedo.calculaFrete());

    }
}
