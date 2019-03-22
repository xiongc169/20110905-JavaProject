package org.practice.designPattern.behavior.ch18command.runoob;

/**
 * @author yoong
 * <br>
 * @desc SellStock
 * <br>
 * @date 2019/1/15 15:34
 */
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
