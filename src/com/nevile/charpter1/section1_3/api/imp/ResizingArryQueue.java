/**  
* @Title: ResizingArryQueue.java
* @Package com.nevile.charpter1.section1_3.implement
* @Description: 可变数组的队列实现，通过实现可变数组的队列达到两个目的：
* 1、进一步熟悉顺序结构数据结构的使用，管理索引、变量的游离、改变数组容量的机制。
* 2、体会一下顺序结构的数组在构造其他数据类型中的工作量，后面与链式数据结构进行比较，体会到不同的数据结构在开发算法中的效率。
* @author nevile  
* @date 2018年10月13日 上午11:02:00
* @version V1.0  
*/
package com.nevile.charpter1.section1_3.api.imp;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Queue;

/**
 * @ClassName: ResizingArryQueue
 * @Description: 可变数组的队列实现。
 * @author nevile
 * @date 2018年10月13日 上午11:02:00
 *
 */
public class ResizingArryQueue<Item> implements Queue<Item> {
	// 数组变量
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[2];
	// 队列头
	private int head = 0;
	// 对列尾
	private int tail = 0;
	// 队列size
	private int size = 0;

	@SuppressWarnings("unchecked")
	private void ReSizeArry(int reSize) {
		Item[] expendArry = (Item[]) new Object[reSize];
		for (int i = 0; i < size; i++) {
			expendArry[i] = a[head++];
			head = (head) % a.length;
		}
		head = 0;
		tail = size;
		a = expendArry;
	}

	/**
	 * <p>
	 * Title: iterator
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ResizingArryQueueIterator();
	}

	public class ResizingArryQueueIterator implements Iterator<Item> {
		// 遍历队列变量指针
		int i = head;
		// 现存容量
		int _size = size;

		/**
		 * <p>
		 * Title: hasNext
		 * </p>
		 * <p>
		 * Description:
		 * </p>
		 * 
		 * @return
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {

			return _size > 0;
		}

		/**
		 * <p>
		 * Title: next
		 * </p>
		 * <p>
		 * Description:
		 * </p>
		 * 
		 * @return
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Item next() {
			// 使用遍历器过程中，代码之前判断了hasNext，这里直接取值，不会出现越界。
			_size--;
			// 使用取模，处理数组越界，循环使用数组。
			// 从if else 结构到 三目运算再到使用摸运算处理循环问题。
			i = i % (a.length);
			return a[i++];
		}
	}

	/**
	 * <p>
	 * Title: enqueue
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param item
	 * @see com.nevile.charpter1.section1_3.api.Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(Item item) {
		// 判断队列是否需要扩容
		if (a.length - size == 0)
			ReSizeArry(2 * a.length);
		a[tail] = item;
		size++;
		tail = (++tail) % a.length;

	}

	/**
	 * <p>
	 * Title: dequeue
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.nevile.charpter1.section1_3.api.Queue#dequeue()
	 */
	@Override
	public Item dequeue() {
		Item rn = null;
		// 判断队列是否满
		if (size > 0) {
			rn = a[head];
			a[head] = null;
			// 取摸循环使用数组
			// head = (head == a.length - 1) ? 0 : head + 1;
			head = (++head) % a.length;
			size--;
		}
		// 检查容量
		if (size == a.length / 4) {
			ReSizeArry(a.length / 2);
		}
		return rn;
	}

	/**
	 * <p>
	 * Title: isEmpty
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.nevile.charpter1.section1_3.api.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size > 0;
	}

	/**
	 * <p>
	 * Title: size
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.nevile.charpter1.section1_3.api.Queue#size()
	 */
	@Override
	public int size() {
		return size;
	}

}
