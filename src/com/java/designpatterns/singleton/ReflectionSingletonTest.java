package com.java.designpatterns.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {

	public static void main(String[] args) {
		EagerInitializationSingleton eagerInitializationSingleton1 =  EagerInitializationSingleton.getInstance();
		EagerInitializationSingleton eagerInitializationSingleton2 = null;
		try{
			Constructor<?>[] constructors = EagerInitializationSingleton.class.getDeclaredConstructors();
			for(Constructor<?> constructor : constructors){
				constructor.setAccessible(true);
				eagerInitializationSingleton2 = (EagerInitializationSingleton) constructor.newInstance();
				break;
			}
			System.out.println(eagerInitializationSingleton1.hashCode());
			System.out.println(eagerInitializationSingleton2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
