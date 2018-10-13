/**   
 * @Package: com.nevile.charpter1.section1_3.implement 
 * @author: Administrator   
 * @date: 2018年8月19日 下午3:02:25 
 */
package com.nevile.charpter1.section1_3.implement;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Stack;

/** 
 * @ClassName: LinkListStack 
 * @Description: 链表实现栈
 * @author: Administrator
 * @date: 2018年8月19日 下午3:02:25  
 */
public class LinkListStack<T> implements Stack<T> {
	
	// @Fields first : 定义链表头节点 
	private Node<T> first = new Node<T>();
	private int N;
	
	//定义链表，嵌套类
	@SuppressWarnings("hiding")
	private class Node<T>{
		public T t;
		public Node<T> next;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkListStackIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	private class LinkListStackIterator<T> implements Iterator<T>{
		@SuppressWarnings("unchecked")
		private LinkListStack<T>.Node<T> before = (LinkListStack<T>.Node<T>) first;

		@Override
		public boolean hasNext() {
			if(before.next!=null) {
				before = before.next;
				return true;
			}else {
				return false;
			}
		}



		@Override
		public T next() {
			return (T) before.t;
		}
		
	}



	@Override
	public boolean isEmpty() {
		return N==0;
	}


	@Override
	public int size() {
		return N;
	}


	/*
	 * 栈顶的节点为first，下一个为之前进栈的node
	 * */
	@Override
	public void push(T item) {
		first.t = item;
		Node<T> node = new Node<T>();
		node.next = first;
		first = node;
		N++;
	}



	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		Node<T> before = first.next;
		Object t = before.t;
		first = before;
		N--;
		return (T) t;
	}

}
