package org.practice.designPattern.create.abstractFactory;

import org.practice.designPattern.create.factory.FruitFactory;

/**
 * 抽象工厂模式<br>
 * http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 * 
 * @author Administrator
 *
 */
public class SuperFactory {

	public AbstractFactory produceFactory(String factoryName) {

		AbstractFactory factory = null;
		switch (factoryName.toLowerCase()) {
		case "shape":
			factory = new ShapeFactory();
			break;
		case "fruit":
			factory = (AbstractFactory) new FruitFactory();
			break;
		}
		return factory;
	}
}
