package com.java.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionProofingLazyInitializationSingletonTest {

	public static void main(String[] args) {
		ReflectionProofingLazyInitializationSingleton reflectionProofingLazyInitializationSingleton1 = ReflectionProofingLazyInitializationSingleton.getInstance();
		System.out.println("Calling get instance : "+reflectionProofingLazyInitializationSingleton1.hashCode());
		ReflectionProofingLazyInitializationSingleton reflectionProofingLazyInitializationSingleton2 = null;
		try {
			Constructor<?>[] constructors = ReflectionProofingLazyInitializationSingleton.class.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				constructor.setAccessible(true);
				reflectionProofingLazyInitializationSingleton2 = (ReflectionProofingLazyInitializationSingleton) constructor.newInstance();
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
