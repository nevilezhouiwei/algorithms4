/**   
 * @Package: com.nevile.charpter1.section1_3.api 
 * @author: Administrator   
 * @date: 2018年8月19日 上午10:49:30 
 */
package com.nevile.charpter1.section1_3.api;

 /** 
 * @ClassName: Stack 
 * @Description: 栈API
 * @author: Administrator
 * @date: 2018年8月19日 上午10:49:30  
 */
public interface Stack<T> extends Iterable<T>{
	public boolean isEmpty();
	public int size();
	public void push(T item);
	public T pop();
}
