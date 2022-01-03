package com.java.concepts.design.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color {
	RED, GREEN, BLUE
}

enum Size {
	SMALL, MEDIUM, LARGE, HUGE
}

class Product {
	public String name;
	public Color color;
	public Size size;

	public Product(String name, Color color, Size size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

}

class ProductFilter {
	public Stream<Product> filterByColor(List<Product> products, Color color) {
		return products.stream().filter(p -> p.color == color);
	}

	public Stream<Product> filterBySize(List<Product> products, Size size) {
		return products.stream().filter(p -> p.size == size);
	}

	public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
		return products.stream().filter(p -> p.size == size && p.color == color
				);
	}

}

public class OpenClosePrinciple {

	public static void main(String[] args) {
		Product apple = new Product("apple", Color.GREEN, Size.SMALL);
		Product tree = new Product("tree", Color.GREEN, Size.LARGE);
		Product house = new Product("house", Color.BLUE, Size.LARGE);
		
		List<Product> products = Arrays.asList(apple, tree, house);
		
		Demo d = new Demo();
//		d.
		
	}
	
}
