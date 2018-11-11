package com.nevile.charpter1.section1_3.api.imp;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Queue;


/**
* @ClassName: FixArrayQueue
* @Description: 使用数组实现固定长度队列
* @author nevile
* @date 2018年10月12日 下午10:47:30
* @param <Item>
* 此固定的队列，作为练习 
* 1、处理队列中元素使用数组十分的不方便。 固定数组要考虑数组的越界。
* 2、不固定数组要考虑数组的扩容和收缩问题，避免内存浪费。
*/ 
public class FixArrayQueue<Item> implements Queue<Item> {
	// 数组变量
	private Item[] a;
	// 队列头
	private int head = 0;
	// 对列尾
	private int tail = 0;
	// 队列size
	private int size=0;

	// 构造器固定队列的大小
	
	/**
	 * @param cap 初始化队列大小
	 */
	public FixArrayQueue(int cap) {
		a = (Item[]) new Object[cap];
	}

	/** 
	* <p>Title: enqueue</p>
	* <p>Description: 添加对象到队列</p>
	* @param item 泛型参数
	* @see com.nevile.charpter1.section1_3.api.Queue#enqueue(java.lang.Object)
	*/ 
	@Override
	public void enqueue(Item item) {
		// 判断队列是否空
		if (a.length - size > 0) {
			a[tail] = item;
			size++;
			tail = (++tail)%a.length;
//			if (tail == a.length - 1) {
//				tail = 0;
//			} else {
//				tail++;
//			}

		} else {
			throw new NullPointerException("Queue is full！");
		}
	}

	/** 
	* <p>Title: dequeue</p>
	* <p>Description: 出队列</p>
	* @return Item 返回泛型
	* @see com.nevile.charpter1.section1_3.api.Queue#dequeue()
	*/ 
	@Override
	public Item dequeue() {
		Item rn = null;
		// 判断队列是否满
		if (size > 0) {
			rn = a[head];
			a[head] = null;
			//取摸循环使用数组
			//head = (head == a.length - 1) ? 0 : head + 1;
			head = (++head)%a.length;
			size--;
		}
		return rn;
	}

	/** 
	* <p>Title: isEmpty</p>
	* <p>Description: 队列是否为空</p>
	* @return boolean 
	* @see com.nevile.charpter1.section1_3.api.Queue#isEmpty()
	*/ 
	@Override
	public boolean isEmpty() {
		return size > 0;
	}

	/** 
	* <p>Title: size</p>
	* <p>Description: 队列大小</p>
	* @return int 整数
	* @see com.nevile.charpter1.section1_3.api.Queue#size()
	*/ 
	@Override
	public int size() {
		return size;
	}

	/** 
	* <p>Title: iterator</p>
	* <p>Description: 返回队列遍历器</p>
	* @return Iterator<Item> 含有泛型的遍历器对象
	* @see java.lang.Iterable#iterator()
	*/ 
	@Override
	public Iterator<Item> iterator() {
		// 返回遍历器
		return new FixArrayQueueIterator();
	}
	
	/**
	* @ClassName: FixArrayQueueIterator
	* @Description: 变量器的嵌套类
	* @author nevile
	* @date 2018年10月12日 下午10:56:02
	*  使用嵌套类
	*/ 
	private class FixArrayQueueIterator implements Iterator<Item> {
		// 遍历队列变量指针
		int i = head;
		// 现存容量
		int _size = size;

		@Override
		public boolean hasNext() {
			return _size > 0;
		}

		@Override
		public Item next() {
			// 使用遍历器过程中，代码之前判断了hasNext，这里直接取值，不会出现越界。
			_size--;
			//使用取模，处理数组越界，循环使用数组。
			//从if else 结构到 三目运算再到使用摸运算处理循环问题。
			i = i % (a.length);
			return a[i++];
		}
	}

}
