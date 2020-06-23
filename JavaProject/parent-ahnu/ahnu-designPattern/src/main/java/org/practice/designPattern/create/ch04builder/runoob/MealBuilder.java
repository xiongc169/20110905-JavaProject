package org.practice.designPattern.create.ch04builder.runoob;

import org.practice.designPattern.create.ch04builder.runoob.item.BurgerChicken;
import org.practice.designPattern.create.ch04builder.runoob.item.BurgerVeg;
import org.practice.designPattern.create.ch04builder.runoob.item.ColdDrinkCoke;
import org.practice.designPattern.create.ch04builder.runoob.item.ColdDrinkPepsi;

public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new BurgerVeg());
        meal.addItem(new ColdDrinkCoke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new BurgerChicken());
        meal.addItem(new ColdDrinkPepsi());
        return meal;
    }
}
