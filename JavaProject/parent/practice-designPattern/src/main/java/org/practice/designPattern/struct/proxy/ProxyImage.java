package org.practice.designPattern.struct.proxy;

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
