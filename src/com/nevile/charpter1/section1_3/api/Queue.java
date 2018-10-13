package com.nevile.charpter1.section1_3.api;


/**
* @ClassName: Queue
* @Description: 队列接口
* @author nevile
* @date 2018年10月13日 上午10:34:50
*
* @param <Item>
*/ 
public interface Queue<Item> extends Iterable<Item>{
	//添加一个元素
	void enqueue(Item item);
	//删除一个元素
	Item dequeue();
	//队列是否为空
	boolean isEmpty();
	//队列中元素数量
	int size();
}
