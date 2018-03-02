package org.practice.primary.utility;

import org.practice.primary.domain.Dictionary;

/**
 * 泛型类
 * 
 * @author Administrator
 * @since 2015-10-30 10:56:55
 * @param <T>
 */
public class TClass<T extends Dictionary> {

	private T current;

	public void Set(T t) {
		this.current = t;
	}

	public T get() {
		return this.current;
	}
}
