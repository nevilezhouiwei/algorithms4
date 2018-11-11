package com.nevile.charpter1.section1_3.excise.test;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.imp.FixArrayQueue;

public class FixArrayQueueOfStringTest {
	public static void main(String[] args) {
		FixArrayQueue<String> queue = new FixArrayQueue<String>(4);
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue("5");
		queue.enqueue("6");
		queue.enqueue("7");
		Iterator<String> iterator = queue.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}
		
	}

}
