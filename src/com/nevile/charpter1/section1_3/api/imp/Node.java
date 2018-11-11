package com.nevile.charpter1.section1_3.api.imp;

/**
* @ClassName: Node
* @Description: 用于练习的链表结点，在实际的使用中使用私有
* @author nevile
* @date 2018年10月19日 下午8:27:22
*
* @param <Iterm> 泛型参数
*/ 
public class Node<Iterm> {
	
	// @Fields iterm : 存储值的变量 
	public Iterm iterm;
	// @Fields node : 链接节点变量 
	public Node<Iterm> next;
	
	@Override
	public String toString() {
		return "Node [iterm=" + iterm + ", next=" + next + "]";
	}

}
