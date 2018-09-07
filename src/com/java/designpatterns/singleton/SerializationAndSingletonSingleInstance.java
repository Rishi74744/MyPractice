package com.java.designpatterns.singleton;

import java.io.Serializable;

public class SerializationAndSingletonSingleInstance implements Serializable {

	private static final long serialVersionUID = -8890609710519533215L;

	private SerializationAndSingletonSingleInstance() {
	}

	private static class SerializationAndSingletonSingleInstanceHelper {
		private static final SerializationAndSingletonSingleInstance SERIALIZATION_AND_SINGLETON = new SerializationAndSingletonSingleInstance();
	}

	public static SerializationAndSingletonSingleInstance getInstance() {
		return SerializationAndSingletonSingleInstanceHelper.SERIALIZATION_AND_SINGLETON;
	}

	protected Object readResolve() {
		return getInstance();
	}

}
