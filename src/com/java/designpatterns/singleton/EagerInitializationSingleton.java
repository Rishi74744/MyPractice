package com.java.designpatterns.singleton;

/**
 * In Eager initialized singleton, the instance of singleton class is created
 * during the time of class loading. This method should be used if your
 * singleton class is not using many resources.
 * 
 * @author Rishi
 *
 */
public class EagerInitializationSingleton {

	private static final EagerInitializationSingleton EAGER_INITIALIZATION_SINGLETON = new EagerInitializationSingleton();

	private EagerInitializationSingleton() {
	}

	public static EagerInitializationSingleton getInstance() {
		return EAGER_INITIALIZATION_SINGLETON;
	}
}
