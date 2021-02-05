package org.practice.java8.book01.ch04;

public class Dish {

    private String name;

    private boolean vegetarian;

    private Integer calories;

    private DishType type;

    private Dish() {
    }

    public Dish(String name, boolean vegetarian, Integer calories, DishType type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }
}
