package org.practice.designPattern.behavior.ch18command.runoob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoong
 * <br>
 * @desc Broker
 * <br>
 * @date 2019/1/15 15:35
 */
public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
