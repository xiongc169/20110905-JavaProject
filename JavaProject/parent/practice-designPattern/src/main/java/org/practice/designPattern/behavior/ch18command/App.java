package org.practice.designPattern.behavior.ch18command;

import org.practice.designPattern.behavior.ch18command.runoob.*;

/**
 * 命令模式
 * http://www.runoob.com/design-pattern/command-pattern.html
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            runoob_command();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void runoob_command() {
        Stock abcStock = new Stock("002230");

        Order buyStockOrder = new BuyStock(abcStock);
        Order sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
