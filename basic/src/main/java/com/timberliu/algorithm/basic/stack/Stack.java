package com.timberliu.algorithm.basic.stack;

/**
 * @author liujie
 * @date 2021/9/7
 */

public interface Stack<E> {

	boolean isEmpty();

	void push(E e);

	E pop();

	E peek();
}
