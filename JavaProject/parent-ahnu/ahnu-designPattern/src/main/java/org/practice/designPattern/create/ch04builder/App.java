package org.practice.designPattern.create.ch04builder;

import org.practice.designPattern.create.ch04builder.runoob.Meal;
import org.practice.designPattern.create.ch04builder.runoob.MealBuilder;

/**
 * @Desc 建造者模式
 * http://www.runoob.com/design-pattern/builder-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            builder_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void builder_runoob() {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
