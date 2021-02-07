package com.yoong.designPattern.struct.ch08proxy.runoob;

public class ProxyImage implements Image {

	public String imageName;

	private RealImage realImage;

	public ProxyImage(String imageName) {
		this.imageName = imageName;
		realImage = new RealImage(imageName);
	}

	@Override
	public void display() {
		this.realImage.display();
	}

}
