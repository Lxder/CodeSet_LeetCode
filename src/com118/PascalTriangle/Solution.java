package com118.PascalTriangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
	public static void main(String args[]){
		
		List l = generate(2);
		System.out.println(l.size());
		Iterator itr = l.iterator();
		while(itr.hasNext()){
			List list= (List)itr.next();
			System.out.println(list);
		}
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return solu;

		List list = new ArrayList<Integer>();
		list.add(1);
		solu.add(list);
		if (numRows == 1) {
			return solu;
		}

		List list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(1);
		solu.add(list2);
		if (numRows == 2) {
			return solu;
		}

		for (int i = 3; i <= numRows; i++) {
			List mlist = new ArrayList();
			mlist.add(1);
			int num = i-2; 
			int start = 0;
			List ilist;
			while(num>0){
				ilist = solu.get(i-2);
				mlist.add((int)ilist.get(start)+(int)ilist.get(start+1));
				start++;
				num--;
			}
			mlist.add(1);
			solu.add(mlist);
		}
		
		return solu;
	}
}
