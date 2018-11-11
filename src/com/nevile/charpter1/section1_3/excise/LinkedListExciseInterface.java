package com.nevile.charpter1.section1_3.excise;

import com.nevile.charpter1.section1_3.api.imp.Node;

/**
* @ClassName: LinkedListExciseInterface
* @Description: 链表练习接口
* @author nevile
* @date 2018年10月19日 下午8:19:33
*
*/ 

public interface LinkedListExciseInterface<Iterm> {


	/**
	* @Title: delete
	* @Description: 接受一个int 参数k ,删除链表的第k 个元素（如果它存在）
	* @param k   
	* void
	*/ 
	void delete(Node<Iterm> node,int k);

	
	/**
	* @Title: find
	* @Description: 接受一个链表node和一个字符串key,如果链表中某个结点的iterm域的值
	* 				 key，则返回true 否则返回false
	* @param node
	* @param key
	* @return
	* boolean
	*/ 
	boolean find(Node<Iterm> node,String key);
	/**
	* @Title: removeAfter
	* @Description: 接受一个链表结点为参数，删除该节点的后续结点。
	* @param node
	* @return    设定文件
	* boolean
	*/ 
	boolean removeAfter(Node<Iterm> node);
	
	/**
	* @Title: insertAfter
	* @Description: 将第二个结点插入到第一个结点的后面，如果两个结点为空
	* 				 则什么都不做。
	* @param node1
	* @param node2    
	* void
	*/ 
	void insertAfter(Node<Iterm> node1,Node<Iterm> node2);
	
	/**
	* @Title: remove
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param node
	* @param key    
	* void
	*/ 
	void remove(Node<Iterm> node,Iterm key);
	

	/**
	* @Title: max
	* @Description: 使用遍历节点的方法，返回结点中个最大的iterm值。
	* @param node
	* @return
	* int
	*/ 
	int max(Node<Integer> node);
	
	/**
	* @Title: recursiveMax
	* @Description: 使用递归取得链表中最大值
	* @param node
	* @return 
	* int
	*/ 
	int recursiveMax(Node<Integer> node);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
