package com.nevile.charpter1.section1_3.excise.test;

import com.nevile.charpter1.section1_3.api.Queue;
import com.nevile.charpter1.section1_3.api.imp.CycleQueue;
import com.nevile.charpter1.section1_3.api.imp.LinkNodes;
import com.nevile.charpter1.section1_3.api.imp.Node;

public class CreatNodes {
	public static void main(String[] args) {
		//创建测试用的链表
		LinkNodes ln = new LinkNodes();
		Node<Integer> linkNodes = ln.getLinkNodes();
		//打印测试链表
		System.out.println(linkNodes);
		
		//创建练习类
		LinkedListExcise20_28<Integer> le = new LinkedListExcise20_28<>();
		//删除第一个结点不成功
		//因为第一个结点被linkNodes制定，想要改变linkNodes制定到第别处，目前使用
		//函数无法处理。你无法改变这个变量的直接引用。
		//删除中间的节点是因为在内存中，中间的结点被改变，而linkNodes 引用地址没变，在
		//遍历的时候中间起作用了。
		//因为linkNodes 这个变量指向的变量一直没有变化。
		//指向的是 4 这个结点。
		le.delete(linkNodes, 10);
		System.out.println(linkNodes);
		
		
		System.out.println(le.find(linkNodes, "3"));
		
		System.out.println("Iterator:"+le.max(linkNodes));
		
		System.out.println("Recursive:"+le.recursiveMax(linkNodes));
		
		Queue cq = new CycleQueue<Integer>();
		
		for (int i = 0; i < 10; i++) {
			cq.enqueue(i);
		}
		
//		for (int i = 0; i < 6; i++) {
//			Integer dequeue = (Integer)cq.dequeue();
//			System.out.println(dequeue);
//		}
		
		while(!cq.isEmpty()) {
			Integer dequeue = (Integer)cq.dequeue();
			System.out.println(dequeue+":"+cq.size());
		}
	}

}
