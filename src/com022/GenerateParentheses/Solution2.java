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
		System.out.println("��ջ������ࣺ"+list.size());
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		} 

	}

	////////////////////////����1/////////////////////////////////
	public static List<String> generateParenthesis(int n) {
		String str = "1234";
		orderList(new Stack(),new String() , str);
		return null;
	}

	public static void orderList(Stack<String> stack, String result,String input) {
		// ���ö����¡�ķ������Ȱ�ջ�����������������Ӱ������
		Stack<String> temp = (Stack<String>) stack.clone();
		String subStr = input.substring(0, 1); // ��õ�һ���ַ�
		input = input.substring(1); 	// ��ȥ��һ���ַ����ַ���
		temp.push(subStr); 				// ����һ���ַ���ջ
		if (input.length() == 0) {		// ���������ջ��Ϊ���һ���ַ�
			while (!temp.isEmpty()) { 	// ��ջ���գ�һֱ��ջ
				result += temp.pop();
			}
			System.out.println(result); // ������
		} else {	//������滹���ַ���
			orderList(temp, result, input);	//�ݹ鴦��ʣ���ַ�
			while (!temp.isEmpty()) {	//�����������ջ����
				result += temp.pop();	//�޸Ľ��
				orderList(temp, result, input);
			}
		}
	}
	
	////////////////////////����2/////////////////////////////////
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
	
	//q��ʾ�������stack��ʱջ��seq�������
	public static void inoutStack(List<String> result ,Deque<String> q , Stack<String> stack, Deque<String> seq,int innum , int outnum){
		if(innum==0&&outnum==0){ //����������Ҫ��ʱ
			result.add(q.toString()); //������
		}
		else{
			if(innum>0){//��ջ���������㣬����������	
				stack.push((String) seq.pollFirst()); //��ջ	
				inoutStack(result,q,stack,seq,innum-1,outnum); //����seqͷ����ջ����� 
				seq.addFirst(stack.pop()); 		//���������Ҫ��seq��ԭ
			}
			if(outnum>0&&innum<outnum){ //��ջ�������㣬ʣ�����ջ��<ʣ��ĳ�ջ��������ջ��>��ջ����
				q.addLast(stack.pop()); 
				inoutStack(result,q,stack,seq,innum,outnum-1);
				stack.push(q.pollLast());
			}
		}
	}
}
