package org.practice.designPattern.struct.ch08proxy.runoob;

public class RealImage implements Image {

	public String imageName;

	public RealImage(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public void display() {
		System.out.println("this is realImage " + imageName);
	}

}
