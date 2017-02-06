package com.java8.collections.custombiconsumer;

import java.util.Objects;
import java.util.function.BiConsumer;

@FunctionalInterface
public interface CustomBiConsumer<T, U> {

	void accept(T t, U u);

	default BiConsumer<T, U> andThen(CustomBiConsumer<? super T, ? super U> after) {
		Objects.requireNonNull(after);
		return (l, r) -> {
			accept(l, r);
			after.accept(l, r);
		};

	}
}
