package com022.GenerateParentheses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
	public static void main(String[] args) {

		List list = generateParenthesis(3);
		System.out.println(list.size());
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
		generate(result,new String(), n,n);
		return result;
    }

	public static void  generate(List<String> result,String str ,int leftnum, int rightnum){
		if(leftnum==0&&rightnum==0){ //����������Ҫ��ʱ
			result.add(str);
		}
		else{
			if(leftnum>0){//���������������㣬����������
				generate(result,str+"(",leftnum-1,rightnum);
			}
			if(rightnum>0&&leftnum<rightnum){ //������������������������ʣ����������������
				generate(result,str+")",leftnum,rightnum-1);
			}
		}
		
	}
}
