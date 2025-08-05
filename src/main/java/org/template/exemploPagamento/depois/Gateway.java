package org.template.exemploPagamento.depois;

public class Gateway {
    public boolean cobrar(double valor) {
        System.out.println("Valor cobrado: " + valor);
        return new boolean[]{true, false}[(int) Math.round(Math.random())];
    }
}
