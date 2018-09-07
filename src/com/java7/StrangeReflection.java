package com.java7;

import java.lang.reflect.Field;

public class StrangeReflection {

	public Character character;

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		StrangeReflection strangeReflection = new StrangeReflection();
		Field field = StrangeReflection.class.getField("character");
		Field type = Field.class.getDeclaredField("type");
		type.setAccessible(true);
		type.set(field, Integer.class);
		field.set(strangeReflection, 4);
		System.out.println(strangeReflection.character);
	}

}