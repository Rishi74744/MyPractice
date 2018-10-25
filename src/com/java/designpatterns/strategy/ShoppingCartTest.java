package com.java.designpatterns.strategy;

public class ShoppingCartTest {

	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();

		Item item1 = new Item("123214", 1200);
		Item item2 = new Item("5516", 3400);
		Item item3 = new Item("2557", 2800);
		Item item4 = new Item("9523", 5500);

		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item3);
		shoppingCart.addItem(item4);

		shoppingCart.pay(new CreditCard("ABCD", "22342345324235", "325", "01/21"));

		shoppingCart.removeItem(item3);

		shoppingCart.pay(new PayPal("asd@saadfo.com", "123124124"));

	}

}
