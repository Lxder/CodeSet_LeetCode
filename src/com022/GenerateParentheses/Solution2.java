package com022.GenerateParentheses;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {

		
		List<String> list = generateinputStack("asdf");
		System.out.println("出栈情况种类："+list.size());
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		} 

	}

	////////////////////////方法1/////////////////////////////////
	public static List<String> generateParenthesis(int n) {
		String str = "1234";
		orderList(new Stack(),new String() , str);
		return null;
	}

	public static void orderList(Stack<String> stack, String result,String input) {
		// 利用对象克隆的方法，先把栈复制下来以免操作后影响下面
		Stack<String> temp = (Stack<String>) stack.clone();
		String subStr = input.substring(0, 1); // 获得第一个字符
		input = input.substring(1); 	// 除去第一个字符的字符串
		temp.push(subStr); 				// 将第一个字符入栈
		if (input.length() == 0) {		// 如果上面入栈的为最后一个字符
			while (!temp.isEmpty()) { 	// 若栈不空，一直出栈
				result += temp.pop();
			}
			System.out.println(result); // 输出结果
		} else {	//如果后面还有字符串
			orderList(temp, result, input);	//递归处理剩余字符
			while (!temp.isEmpty()) {	//处理结束后，若栈不空
				result += temp.pop();	//修改结果
				orderList(temp, result, input);
			}
		}
	}
	
	////////////////////////方法2/////////////////////////////////
	public static List<String> generateinputStack(String str) {
        List<String> result = new ArrayList<String>();
        Deque<String> q = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        Deque<String> seq = new LinkedList<String>();
        int len = str.length();
        for(int i = 0 ; i < len ; i++){
        	seq.add(str.substring(i, i+1));
        }
        
        inoutStack(result,q,stack,seq, len,len);
		return result;
		
    }
	
	//q表示结果集，stack临时栈，seq输入队列
	public static void inoutStack(List<String> result ,Deque<String> q , Stack<String> stack, Deque<String> seq,int innum , int outnum){
		if(innum==0&&outnum==0){ //当数量满足要求时
			result.add(q.toString()); //保存结果
		}
		else{
			if(innum>0){//入栈数量不满足，可以随便添加	
				stack.push((String) seq.pollFirst()); //入栈	
				inoutStack(result,q,stack,seq,innum-1,outnum); //处理seq头部入栈的情况 
				seq.addFirst(stack.pop()); 		//处理完后需要将seq复原
			}
			if(outnum>0&&innum<outnum){ //出栈数量不足，剩余的入栈数<剩余的出栈数（即入栈数>出栈数）
				q.addLast(stack.pop()); 
				inoutStack(result,q,stack,seq,innum,outnum-1);
				stack.push(q.pollLast());
			}
		}
	}
}
