package com.java8.collections.customfunction;

import java.util.Objects;

@FunctionalInterface
public interface CustomFunction<T, R> {

	R apply(T t);

	default <V> CustomFunction<V, R> compose(CustomFunction<? super V, ? extends T> before) {
		Objects.requireNonNull(before);
		return (V v) -> apply(before.apply(v));
	}

	default <V> CustomFunction<T, V> andThen(CustomFunction<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (T t) -> after.apply(apply(t));
	}

	static <T> CustomFunction<T, T> identity() {
		return t -> t;
	}

}
