package com038.CountandSay;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("½á¹û"+countAndSay(6));
	}

	public static String countAndSay(int n) {
		int temp;
		StringBuffer sb = new StringBuffer();
		int countt = 0;
		int flag ;
		int tn = 1;
		while (n-1 > 0) {
			flag = -1;
			while (tn != 0) {
				temp = tn % 10;
				if (flag == -1) {
					countt = 0;
					flag = temp;
				}
				//System.out.println("temp:" + temp + ", flag:" + flag);
				if (temp == flag) {
					countt++;
					tn = tn / 10;
				} else {
					sb.append(flag);
					sb.append(countt);
					
					flag = -1;
				}
			}
			
			sb.append(flag);
			sb.append(countt);
			tn = Integer.valueOf(sb.reverse().toString());
			sb = new StringBuffer();
			n--;
			System.out.println(tn);
		}
		return String.valueOf(tn);
	}
}
