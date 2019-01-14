package org.practice.designPattern.create.builder;

import org.practice.designPattern.create.builder.runoob.Meal;
import org.practice.designPattern.create.builder.runoob.MealBuilder;

/**
 * @author yoong
 * <br>
 * @desc 建造者模式
 * http://www.runoob.com/design-pattern/builder-pattern.html
 * <br>
 * @date 2019/1/14 17:13
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            runoobTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void runoobTest() {
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
