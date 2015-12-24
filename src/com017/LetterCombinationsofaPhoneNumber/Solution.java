package com017.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) {
		List list = letterCombinations("123");
		Iterator itr = list .iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println(list.size());
	}

	public static  List<String> letterCombinations(String digits) {
		if(digits.length()==0||digits==null){
			List<String> solu = new ArrayList<String>();
			return solu;
		}		
			
		String[][] c = { {}, // 0
				{}, // 1
				{ "a", "b", "c" }, // 2
				{ "d", "e", "f" }, // 3
				{ "g", "h", "i" }, // 4
				{ "j", "k", "l" }, // 5
				{ "m", "n", "o" }, // 6
				{ "p", "q", "r", "s" }, // 7
				{ "t", "u", "v" }, // 8
				{ "w", "x", "y", "z" } // 9
		};
		int[] total = {0,0,3,3,3,3,3,4,3,4};//表示每个数字能代表几个字母
	    
		Vector<Integer> Number = new Vector();
		for(int i = 0, len = digits.length() ; i <len ; i++){
			Number.add(digits.charAt(i)-'0');
		}
		
//	    List<Integer> numlist = new ArrayList();
//	    for(int i = 0, len = digits.length() ; i <len ; i++){
//	    	numlist.add(digits.charAt(i)-'0');
//	    	//System.out.println(digits.charAt(i)-'0');	    	
//	    }
//	    
//	    Object[] Number = numlist.toArray(); //输入的电话号码
	    int n = Number.size();
	    
	    int[] answer = new int[n]; //代表每一位电话号码的代表的数字对应字母是哪一个

	    List<String> solu = new ArrayList<String>(); //存储结果
	    
	    while(true){ //电话号码数量变化的时候，不需要变换循环的数量。原来的方法必须改变for循环的数量
	        StringBuilder sb = new StringBuilder();	        
	    	for(int i = 0 ; i < n ; i++){
	        	if(Number.get(i)==0||Number.get(i)==1 )continue;
	        	sb.append(c[Number.get(i)][answer[i]]);
	        	//solu.add(c[(int) Number[i]][answer[i]]);
	            //System.out.print(c[(int) Number[i]][answer[i]]);
	        }
	    	solu.add(sb.toString());
	       // System.out.print(" ");
	        int k = n-1;
	        while(k>=0){
	            if(answer[k]<total[Number.get(k)]-1){
	                answer[k]++;
	                break;
	            }
	            else{ //本层的字母遍历完了，需要改变上一层的一个字母，然后再遍历一次
	                answer[k]=0;  
	                k--;
	                //System.out.println();
	            }
	        }
	        if(k<0)
	            break;
	    }
	    
	    return solu;
		
	}

}
