/**   
 * @Package: com.nevile.charpter1.section1_3.api 
 * @author: Administrator   
 * @date: 2018年8月19日 上午10:38:24 
 */
package com.nevile.charpter1.section1_3.api;

 /** 
 * @ClassName: Bag 
 * @Description: 背包api
 * @author: Administrator
 * @date: 2018年8月19日 上午10:38:24  
 */
public interface Bag<Item> {
	public void add(Item item);
	public boolean isEmpty();
	public int size();
}
