package org.practice.designPattern.behavior.ch18command.runoob;

public class BuyStock implements Order {

    private Stock stock;

    public BuyStock() {
    }

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
