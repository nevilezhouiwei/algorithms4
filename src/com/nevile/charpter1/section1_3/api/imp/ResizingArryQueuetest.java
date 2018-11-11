/**  
* @Title: test2.java
* @Package com.nevile.charpter1.section1_3.implement
* @Description: TODO(用一句话描述该文件做什么)
* @author nevile  
* @date 2018年10月13日 上午11:45:41
* @version V1.0  
*/ 
package com.nevile.charpter1.section1_3.api.imp;

/**
* @ClassName: test2
* @Description: TODO(这里用一句话描述这个类的作用)
* @author nevile
* @date 2018年10月13日 上午11:45:41
*
*/
public class ResizingArryQueuetest {
public static void main(String[] args) {
//	int i = 13;
//	int j ,n;
//	j = ++i;
//	
//	i = (i++)%3;
//	System.out.println(i);
	ResizingArryQueue<String> queue = new ResizingArryQueue<String>();
	for(int i =0 ;i<16;i++) {
		queue.enqueue(i+"");
		
	}
	for(int i =0 ;i<16;i++) {
		System.out.println(queue.dequeue());
		
	}
}
}
