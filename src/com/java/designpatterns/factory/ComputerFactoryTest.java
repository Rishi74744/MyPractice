package com.java.designpatterns.factory;

public class ComputerFactoryTest {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", "12GB", "1TB", "2.4GHz");
		Computer server = ComputerFactory.getComputer("Server", "128GB", "100TB", "5.9GHz");
		System.out.println("PC : " + pc);
		System.out.println("Server : " + server);
	}

}
