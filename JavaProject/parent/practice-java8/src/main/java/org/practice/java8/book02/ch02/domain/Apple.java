package org.practice.java8.book02.ch02.domain;

public class Apple {

	private String id;

	private String color;

	private Integer weight;

	public Apple() {
	}

	public Apple(String id, String color, Integer weight) {
		this.id = id;
		this.color = color;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
