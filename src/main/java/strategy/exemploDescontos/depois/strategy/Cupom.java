package strategy.exemploDescontos.depois.strategy;

public enum Cupom {
    GAMER15(15),
    NATAL50(50);

    private final double desconto;

    Cupom(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
}
