package org.practice.designPattern.create.builder.runoob;

import org.practice.designPattern.create.builder.runoob.api.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoong
 * <br>
 * @desc Meal
 * <br>
 * @date 2019/1/14 17:22
 */
public class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
