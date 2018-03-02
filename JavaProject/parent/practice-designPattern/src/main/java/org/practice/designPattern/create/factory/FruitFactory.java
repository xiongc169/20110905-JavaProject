package org.practice.designPattern.create.factory;

import org.practice.designPattern.create.abstractFactory.AbstractFactory;

public class FruitFactory implements AbstractFactory {

	public Fruit produceFruit(String fruitName) {
		Fruit fruit = null;
		switch (fruitName.toLowerCase()) {
		case "orange":
			fruit = new Orange();
			break;
		case "pear":
			fruit = new Pear();
			break;
		case "strawberry":
			fruit = new Strawberry();
			break;
		}
		return fruit;
	}

	public Fruit produceOrange() {
		Fruit fruit = new Orange();
		return fruit;
	}

	public Fruit producePear() {
		Fruit fruit = new Pear();
		return fruit;
	}

	public Fruit produceStrawberry() {
		Fruit fruit = new Strawberry();
		return fruit;
	}

	public Object produceFruitByClass(Class<? extends Fruit> clazz) {
		Object obj = null;

		try {
			obj = Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return obj;

	}
}
