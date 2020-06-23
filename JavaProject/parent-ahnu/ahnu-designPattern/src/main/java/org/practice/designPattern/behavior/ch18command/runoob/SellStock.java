package org.practice.designPattern.behavior.ch18command.runoob;

public class SellStock implements Order {

    private Stock stock;

    public SellStock() {
    }

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
