package com.java.designpatterns.singleton;

import java.io.Serializable;

public class SerializationAndSingleton implements Serializable {

	private static final long serialVersionUID = -8890609710519533215L;

	private SerializationAndSingleton() {
	}

	private static class SerializationAndSingletonHelper {
		private static final SerializationAndSingleton SERIALIZATION_AND_SINGLETON = new SerializationAndSingleton();
	}

	public static SerializationAndSingleton getInstance() {
		return SerializationAndSingletonHelper.SERIALIZATION_AND_SINGLETON;
	}

}
