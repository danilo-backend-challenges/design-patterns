package strategy.exemploDescontos.depois2.descontos;

public enum Cupom {
    GAMER15(15),
    NATAL50(50);

    private double desconto;

    Cupom(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
}
