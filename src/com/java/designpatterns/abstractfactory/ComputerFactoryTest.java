package com.java.designpatterns.abstractfactory;

public class ComputerFactoryTest {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("12GB", "1TB", "2.4GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("128GB", "100TB", "5.9GHz"));
		System.out.println("PC : " + pc);
		System.out.println("Server : " + server);
	}

}
