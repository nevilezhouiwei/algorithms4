/**   
 * @Package: com.nevile.charpter1.section1_3.excise 
 * @author: Administrator   
 * @date: 2018年8月20日 下午10:57:15 
 */
package com.nevile.charpter1.section1_3.excise;

import com.nevile.charpter1.section1_3.api.Stack;
import com.nevile.charpter1.section1_3.implement.ResizingArryStack;

import edu.princeton.cs.algs4.StdIn;

/** 
 * @ClassName: AddLeftBraket 
 * @Description: 假设运算没有优先级,用括号代替优先级,每一步都有括号指导计算
 * @author: Administrator
 * @date: 2018年8月20日 下午10:57:15  
 */
public class AddLeftBraket {
	public static void main(String[] args) {
		Stack<String> ops = new ResizingArryStack<String>();
		Stack<String> vals = new ResizingArryStack<String>();
		while(!StdIn.isEmpty()) {
			String rs = StdIn.readString();
			if(rs.equals("quit")) {
				System.out.println("结束输入");
				break;
			}else if(rs.equals("+")) {
				ops.push(rs);
			}else if (rs.equals("-")) {
				ops.push(rs);
			}else if (rs.equals("*")) {
				ops.push(rs);
			}else if (rs.equals("/")) {
				ops.push(rs);
			}else if (rs.equals(")")) {
				String op = ops.pop();
				String val = vals.pop();
				if(op.equals("+")) {
					val = "("+vals.pop()+"+"+val+")";
					//vals.push(val);
				}else if(op.equals("-")) {
					val = "("+vals.pop()+"-"+val+")";
					//vals.push(val);
				}else if(op.equals("*")) {
					val = "("+vals.pop()+"*"+val+")";
					//vals.push(val);
				}
				vals.push(val);
			}else {
				vals.push(rs);
			}
			
		}
		System.out.println(vals.pop());
	}

}
