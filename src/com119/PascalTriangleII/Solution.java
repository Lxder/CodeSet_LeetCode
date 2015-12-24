package com119.PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = getRow(0);
		System.out.println(list);

	}
	public  static List<Integer> getRow(int rowIndex) {
		rowIndex ++;
		if (rowIndex == 1) {
		    List list = new ArrayList<Integer>();
		    list.add(1);
			return list;
		}
		
		List list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(1);
		if (rowIndex == 2) {
			return list2;
		}

        List ilist = list2;
        List mlist = null ;
		for (int i = 3; i <= rowIndex; i++) {
			mlist = new ArrayList();
			mlist.add(1);
			int num = i-2; 
			int start = 0;
			while(num>0){
				mlist.add((int)ilist.get(start)+(int)ilist.get(start+1));
				start++;
				num--;
			}
			mlist.add(1);
			ilist = mlist;
		}
		
		return mlist;
    }

}
