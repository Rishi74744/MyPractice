package com.java.designpatterns.singleton;

import java.lang.reflect.ReflectPermission;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ReflectionProofingLazyInitializationSingleton {

	private static ReflectionProofingLazyInitializationSingleton reflectionProofingLazyInitializationSingleton = null;
	private static int instanceCount = 0;

	private ReflectionProofingLazyInitializationSingleton() {
		ReflectPermission reflectPermission = new ReflectPermission("suppressAccessChecks", "");
		AccessController.checkPermission(reflectPermission);
		++instanceCount;
		System.out.println("Instance # : " + instanceCount);
	}

	synchronized public static final ReflectionProofingLazyInitializationSingleton getInstance() {
		if (reflectionProofingLazyInitializationSingleton == null) {
			AccessController.doPrivileged(new PrivilegedAction<Object>() {
				@Override
				public Object run() {
					reflectionProofingLazyInitializationSingleton = new ReflectionProofingLazyInitializationSingleton();
					return null;
				}
			});
		}
		return reflectionProofingLazyInitializationSingleton;
	}

}
