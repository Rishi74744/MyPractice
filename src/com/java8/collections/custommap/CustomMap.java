package com.java8.collections.custommap;

import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.Set;

import com.java8.collections.custombiconsumer.CustomBiConsumer;
import com.java8.collections.custombifunction.CustomBiFunction;

import java.io.Serializable;

public interface CustomMap<K, V> {

	int size();

	boolean isEmpty();

	boolean containsKey(Object key);

	boolean containsValue(Object value);

	V get(Object key);

	V put(K key, V value);

	V remove(Object key);

	void putAll(CustomMap<? extends K, ? extends V> cm);

	void clear();

	Set<K> keySet();

	Collection<V> values();

	Set<CustomMap.CustomEntry<K, V>> entrySet();

	interface CustomEntry<K, V> {
		K getKey();

		V getValue();

		V setValue(V value);

		boolean equals(Object o);

		int hashCode();

		public static <K extends Comparable<? super K>, V> Comparator<CustomMap.CustomEntry<K, V>> comparingByKey() {
			return (Comparator<CustomMap.CustomEntry<K, V>> & Serializable) (c1, c2) -> c1.getKey()
					.compareTo(c2.getKey());
		}

		public static <K, V extends Comparable<? super V>> Comparator<CustomMap.CustomEntry<K, V>> comparingByValue() {
			return (Comparator<CustomMap.CustomEntry<K, V>> & Serializable) (c1, c2) -> c1.getValue()
					.compareTo(c2.getValue());
		}

		public static <K, V> Comparator<CustomMap.CustomEntry<K, V>> comparingByKey(Comparator<? super K> cmp) {
			Objects.requireNonNull(cmp);
			return (Comparator<CustomMap.CustomEntry<K, V>> & Serializable) (c1, c2) -> cmp.compare(c1.getKey(),
					c2.getKey());

		}

	}

	boolean equals(Object o);

	int hashCode();

	default V getOrDefault(Object key, V defaultValue) {
		V v;
		return ((v = get(key)) != null) ? v : defaultValue;
	}

	default void forEach(CustomBiConsumer<? super K, ? super V> action){
		Objects.requireNonNull(action);
		for(CustomMap.CustomEntry<K, V> entry : entrySet()){
			K k;
			V v;
			try{
				k = entry.getKey();
				v = entry.getValue();
			}catch(IllegalStateException ise){
				throw new ConcurrentModificationException();
			}
			action.accept(k, v);
		}
	}
	
	default void replaceAll(CustomBiFunction<? super K, ? super V, ? extends V> function){
		Objects.requireNonNull(function);
		for(CustomMap.CustomEntry<K, V> entry : entrySet()){
			K k;
			V v;
			try{
				k = entry.getKey();
				v = entry.getValue();
			}catch (IllegalStateException ise) {
				// TODO: handle exception
			}
			
		}
	}
}
