package com.java.designpatterns.factory;

public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if ("PC".equals(type)) {
			return new PC(ram, hdd, cpu);
		} else if ("Server".equals(type)) {
			return new Server(ram, hdd, cpu);
		}
		return null;
	}

}
