package com.java.designpatterns.singleton;

public class ReflectionProofingSingleton implements Cloneable {

	private static ReflectionProofingSingleton reflectionProofingSingleton;

	private ReflectionProofingSingleton() {
		if (reflectionProofingSingleton != null) {
			throw new IllegalStateException("Instance already exists!");
		}
	}

	public static ReflectionProofingSingleton getInstance() {
		if (reflectionProofingSingleton == null) {
			synchronized (ReflectionProofingSingleton.class) {
				if (reflectionProofingSingleton == null) {
					reflectionProofingSingleton = new ReflectionProofingSingleton();
				}
			}
		}
		return reflectionProofingSingleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning not possible!");
	}

}
