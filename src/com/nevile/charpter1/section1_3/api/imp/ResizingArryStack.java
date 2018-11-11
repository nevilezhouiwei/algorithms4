/**   
 * @Package: com.nevile.charpter1.section1_3.implement 
 * @author: Administrator   
 * @date: 2018年8月19日 下午1:06:04 
 */
package com.nevile.charpter1.section1_3.api.imp;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Stack;

/** 
 * @ClassName: ResizingArryStack 
 * @Description: TODO
 * @author: Administrator
 * @date: 2018年8月19日 下午1:06:04  
 */
public class ResizingArryStack<T> implements Stack<T> {
	@SuppressWarnings("unchecked")
	private T[] a = (T[]) new Object[16];
	private int N;


	@Override
	public boolean isEmpty() {
		return N==0;
	}


	@Override
	public int size() {
		return N;
	}

	/**
	* @Title: ReSizeArry
	* @Description: 数组扩容
	* @param @param reSize    设定文件
	* @return void    返回类型
	* @throws
	*/ 
	@SuppressWarnings("unchecked")
	private void ReSizeArry(int reSize) {
		T[] expendArry = (T[]) new Object[reSize];
		for(int i=0;i<N;i++) {
			expendArry[i] = a[i];
		}
		a = expendArry;
	}
	
	/** 
	* <p>Title: push</p>
	* <p>Description: 数据进栈，如果数组已满，则扩容到2倍。</p>
	* @param item
	* @see com.nevile.charpter1.section1_3.api.Stack#push(java.lang.Object)
	*/ 
	@Override
	public void push(T item) {
		//数组长度和索引相等，数据扩容一倍
		if (a.length==N) ReSizeArry(2*a.length);
		a[N++]=item;
	}

	/** 
	* <p>Title: pop</p>
	* <p>Description: 数据出栈，原存储数据的位置置空，防止游离数据。若当前存储数据的容量等于数组容量的1/4,则数组调整为当前容量的1/2.</p>
	* @return
	* @see com.nevile.charpter1.section1_3.api.Stack#pop()
	*/ 
	@Override
	public T pop() {
		T t = a[--N];
		a[N] = null;
		//
		if(N==a.length/4 ) {
			ReSizeArry(a.length/2);
		}
		return t;
	}



	@Override
	public Iterator<T> iterator() {
		
		return (Iterator<T>) new ResizingArryStackIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	private class ResizingArryStackIterator<T> implements Iterator<T>{

		private int i = N;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) a[--i];
		}
		
	}

}
