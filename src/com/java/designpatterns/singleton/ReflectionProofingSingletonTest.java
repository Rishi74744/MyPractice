package com.java.designpatterns.singleton;

import java.lang.reflect.Constructor;

public class ReflectionProofingSingletonTest {

	public static void main(String[] args) {
		ReflectionProofingSingleton reflectionProofingSingleton1 = ReflectionProofingSingleton.getInstance();
		System.out.println(reflectionProofingSingleton1.hashCode());
		ReflectionProofingSingleton reflectionProofingSingleton2 = null;
		ReflectionProofingSingleton reflectionProofingSingleton3 = null;	
		try{
			Constructor<?>[] constructors = ReflectionProofingSingleton.class.getDeclaredConstructors();
			for(Constructor<?> constructor : constructors){
				constructor.setAccessible(true);
				reflectionProofingSingleton2 = (ReflectionProofingSingleton) constructor.newInstance();
				break;
			}
			System.out.println(reflectionProofingSingleton2.hashCode());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			reflectionProofingSingleton3 = (ReflectionProofingSingleton) reflectionProofingSingleton1.clone();
			System.out.println(reflectionProofingSingleton3.hashCode());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
