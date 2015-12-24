package com038.CountandSay;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("½á¹û"+countAndSay(9));
	}

	public static String countAndSay(int n) {
		int temp;
		int countt = 0;
		int flag ;
		List<Integer> tn = new ArrayList<Integer>();
		tn.add(1);
		while (n-1 > 0) {
			flag = -1;
			int len = tn.size();
			int i = 0 ; 
			List<Integer> templist = new ArrayList<Integer>();
			while(i<len){
				temp = tn.get(i);
				if (flag == -1) {
					countt = 0;
					flag = temp;
				}
				//System.out.println("temp:" + temp + ", flag:" + flag);
				if (temp == flag) {
					countt++;
					i++;
				} else {
					templist.add(countt);
					templist.add(flag);
					
					flag = -1;
				}
			}
			templist.add(countt);
			templist.add(flag);
			
			tn = templist;
			n--;
			System.out.println(tn);
		}
		StringBuffer sb = new StringBuffer();
		int len = tn.size();
		for(int i = 0 ; i < len ; i++){
			sb.append(tn.get(i));
		}
		return sb.toString();
	}
}
