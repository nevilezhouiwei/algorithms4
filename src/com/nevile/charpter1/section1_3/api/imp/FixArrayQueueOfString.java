package com.nevile.charpter1.section1_3.api.imp;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Queue;

/**
 * @author nevile
 * 此固定的队列，作为练习
 * 1、处理队列中元素使用数组十分的不方便。
 * 固定数组要考虑数组的越界。
 * 不固定数组要考虑数组的扩容和收缩问题，避免内存浪费。
 *
 */
public class FixArrayQueueOfString<Item> implements Queue<Item>
{
	// 数组变量
	private Item[] a;
	// 队列头
	private int head = 0;
	// 对列尾
	private int tail = 0;
	//队列size
	private int size;

	// 构造器固定队列的大小
	public FixArrayQueueOfString(int cap) {
		a = (Item[]) new Object[cap];
		size = 0;
	}

	@Override
	public void enqueue(Item item) {
		//判断队列是否空
		if (a.length-size > 0) {
			a[tail]=item;
			size++;
			if (tail == a.length - 1) {
				tail = 0;
			} else {
				tail++;
			}

		}else {
			throw new NullPointerException("Queue is full！");
		}
	}

	@Override
	public Item dequeue() {
		Item rn = null ;
		//判断队列是否满
		if(size>0) {			
			rn = a[head];
			a[head] = null;
			head = (head==a.length-1)?0:head+1;
			size--;
		}
		return rn;
	}

	@Override
	public boolean isEmpty() {
		return (size>0)?true:false;
	}

	@Override
	public int size() {
		return size;
	}

	/** 
	* <p>Title: iterator</p>
	* <p>Description: </p>
	* @return
	* @see java.lang.Iterable#iterator()
	*/ 
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
