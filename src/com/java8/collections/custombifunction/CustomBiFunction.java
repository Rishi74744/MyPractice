package com.java8.collections.custombifunction;

import java.util.Objects;

import com.java8.collections.customfunction.CustomFunction;

@FunctionalInterface
public interface CustomBiFunction<T, U, R> {

	R apply(T t, U u);

	default <V> CustomBiFunction<T, U, V> andThen(CustomFunction<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		return (T t, U u) -> after.apply(apply(t, u));

	}

}
