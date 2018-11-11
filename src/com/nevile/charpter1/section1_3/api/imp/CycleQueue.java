package com.nevile.charpter1.section1_3.api.imp;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Queue;

public class CycleQueue<Iterm> implements Queue<Iterm> {

	@SuppressWarnings("hiding")
	private class Node<Iterm> {
		private Iterm iterm;
		private Node<Iterm> next;

	}

	private Node<Iterm> last;
	private int N = 0;

	@Override
	public Iterator<Iterm> iterator() {
		 return null;
	}
	

	@Override
	public void enqueue(Iterm iterm) {
		if (last == null) {
			last = new Node<Iterm>();
			last.iterm = iterm;
			last.next = last;
			N++;
		} else {
			Node<Iterm> oldFirst = last.next;
			Node<Iterm> first = new Node<Iterm>();
			first.iterm = iterm;
			first.next = oldFirst;
			last.next = first;
			N++;
		}

	}

	@Override
	public Iterm dequeue() {
		if (last == null) {
			return null;
		} else {
			Node<Iterm> first = last.next;
			Node<Iterm> tempNode = last.next;
			Iterm iterm = last.iterm;
			// 重新指定最后一个节点
			
			while (true) {
				if (last == tempNode.next) {
					tempNode.next = first;
					last.iterm = null;
					last.next = null;
					last = tempNode;
					break;
				}
				tempNode = tempNode.next;
				// 如果最后剩下两个点，两个节点容易形成死循环
				if (tempNode == tempNode.next) {
					tempNode = null;
					return iterm;
				}
			}
			N--;
			return iterm;
		}
	}

	@Override
	public boolean isEmpty() {
		return N == 0 ? true : false;
	}

	@Override
	public int size() {
		return N;
	}

}
