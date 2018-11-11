package com.nevile.charpter1.section1_3.api.imp;


/**
* @ClassName: LinkNodes
* @Description: 自动构造一个链表
* @author nevile
* @date 2018年10月30日 下午10:09:14
*很搞笑，尽然不会写了。。
*/ 
public class LinkNodes{
	
	private Node<Integer> first = new Node<Integer>();
	/**
	* @Title: getLinkNodes
	* @Description: 用代码生产一个链表测试数据
	* @return 
	* Node<Integer>
	*/ 
	public Node<Integer> getLinkNodes(){
		first.iterm = 0;
		for (int i = 1; i <2; i++) {
			Node<Integer> oldFirst = first; 
			first = new Node<Integer>();
			first.iterm = i;
			first.next = oldFirst;
		}
		return first;
	}
	
	

}
