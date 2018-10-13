/**   
 * @Package: com.nevile.charpter1.section1_3.implement 
 * @author: Administrator   
 * @date: 2018年8月19日 上午11:21:08 
 */
package com.nevile.charpter1.section1_3.implement;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Stack;

/**
 * @ClassName: FixedCapacityStack
 * @Description: 数组的方式实现
 * @author: Administrator
 * @date: 2018年8月19日 上午11:21:08
 */
public class FixedCapacityStack<T> implements Stack<T> {

	// 泛型数组变量
	private T[] a;
	// 栈的长度
	private int N;

	// 定容构造器
	public FixedCapacityStack(int cap) {
		a = (T[]) new Object[cap];
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public void push(T item) {
		if (N < a.length - 1)
			//若发生越界，程序会自己抛出异常
			a[N++] = item;
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public T pop() {
		//若发生越界，程序会自己抛出异常
		T t = a[--N];
		a[N] = null;
		return t;
	}

	@Override
	public Iterator<T> iterator() {
		// 引用遍历器的实现
		return new FixedCapacityStackIterator<T>();
	}

	// 嵌套类,也称内部类
	private class FixedCapacityStackIterator<T> implements Iterator<T> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			// 使用遍历器过程中，代码之前判断了hasNext，这里直接取值，不会出现越界。
			return (T) a[--i];
		}

	}

}