package com204.CountPrimes;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

	public static void main(String args[]){
		System.out.println("½á¹û£º"+countPrimes(100));
	}
	public static int countPrimes(int n) {		
		if(n<=2) return 0;
		
		List<Integer> list = new LinkedList<Integer>();		
		for(int i = 2 ; i < n ; i++){
			list.add(i);
		}
		
		int first ;
		int i = 0;
		int len = 0;
		while(i<list.size()){
			first = (int) list.get(i);			
			len = list.size();
			int itemp = 0;
			for(int j = i+1 ; j<len ; j++){
				if((int)list.get(j-itemp)%first == 0){
					list.remove(j-itemp);
					itemp++;
				}
			}
			i++;
		}
		
		
		return list.size();
	}
}
