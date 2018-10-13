/**   
 * @Package: com.nevile.charpter1.section1_3.implement 
 * @author: Administrator   
 * @date: 2018年8月19日 上午11:55:51 
 */
package com.nevile.charpter1.section1_3.implement;

import java.util.Iterator;

import com.nevile.charpter1.section1_3.api.Stack;

import edu.princeton.cs.algs4.StdIn;

/** 
 * @ClassName: test13 
 * @Description: TODO
 * @author: Administrator
 * @date: 2018年8月19日 上午11:55:51  
 */
public class test13 {
	
	public static void main(String[] arg) {
		String[] a = new String[5];
		
		Stack<String> stack = new LinkListStack<String>();
		int i=0;
		while(i<34) {
			stack.push(i+"+");
			i++;
		}
		
		Iterator<String> iterator = stack.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

		while(i>0) {
			System.out.println(stack.size());
			stack.pop();
			--i;
		}
		
		while(!StdIn.isEmpty()) {
			String str = StdIn.readString();
			System.out.println(str);
		}
		
	}

}
