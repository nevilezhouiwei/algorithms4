package com.nevile.charpter1.section1_3.excise.test;

import com.nevile.charpter1.section1_3.api.imp.Node;
import com.nevile.charpter1.section1_3.excise.LinkedListExciseInterface;

/**
 * @ClassName: LinkedListExcise20_28
 * @Description:
 * @author nevile
 * @date 2018年10月30日 下午10:38:55
 *
 * @param <Iterm>
 * 
 *        把对象传入进来，对对象的操作又改变了对象。又不会写了。。。
 */
public class LinkedListExcise20_28<Iterm>
		implements LinkedListExciseInterface<Iterm> {

	/**
	 * <p>
	 * Title: delete
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param node
	 * @param k
	 * @see com.nevile.charpter1.section1_3.excise.LinkedListExciseInterface#delete(com.nevile.charpter1.section1_3.api.imp.Node,
	 *      int) 1、采用局部变量查询要操作的变量。 2、最后使用节点操作，删除第K个元素。
	 */
	@Override
	public void delete(Node<Iterm> node, int k) {
		if (node != null && k > 0) {
			Node<Iterm> n = node;
			Node<Iterm> before = null;
			// 实现 1、采用局部变量查询要操作的变量。
			/**
			 * 定义对头是第一个节点 当K超过链表的长度，不删除队列中的节点，因为此节点不存在。
			 */
			boolean flag = true;
			// 删除第一个结点
			if (k == 1) {
				flag = false;
				node = node.next;
				System.out.println(
						"test nodes has defect ,cant delete the first");
			} else {
				for (int i = 0; i < k - 1; i++) {
					if (n.next != null) {
						before = n;
						n = n.next;
					} else {
						flag = false;
						System.out.println("not delete any node");
						break;
					}
				}
				if (flag) {
					before.next = n.next;
				}
			}

		}

	}

	@Override
	public boolean find(Node<Iterm> node, String key) {
		boolean flag = false;
		while (true) {
			flag = key.equals(node.iterm.toString()) ? true : false;
			if (flag || node.next == null) {
				break;
			} else {
				node = node.next;
			}
		}
		return flag;
	}

	@Override
	public boolean removeAfter(Node<Iterm> node) {
		node.next = null;
		return false;
	}

	@Override
	public void insertAfter(Node<Iterm> node1, Node<Iterm> node2) {
		node2.next = node2;
	}

	@Override
	public void remove(Node<Iterm> node, Iterm key) {
		// TODO Auto-generated method stub

	}

	@Override
	public int max(Node<Integer> node) {
		int max = node.iterm;
		while (node.next != null) {
			node = node.next;
			max = max > (int) node.iterm ? max : (int) node.iterm;
		}
		return max;

	}

	@Override
	public int recursiveMax(Node<Integer> node) {
		int max = 0;
		if (node == null) {
			return max;
		}else {
			int nextMax = recursiveMax(node.next);
			max = node.iterm>nextMax?node.iterm:nextMax;
			return max;
		}
	}
	
	

}
