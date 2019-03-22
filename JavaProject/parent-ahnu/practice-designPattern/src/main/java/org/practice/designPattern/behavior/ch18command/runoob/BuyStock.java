package org.practice.designPattern.behavior.ch18command.runoob;

/**
 * @author yoong
 * <br>
 * @desc BuyStock
 * <br>
 * @date 2019/1/15 15:34
 */
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
