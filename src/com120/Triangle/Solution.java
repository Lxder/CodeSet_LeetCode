package com120.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);l2.add(4);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);l3.add(5);l3.add(7);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);l4.add(1);l4.add(8);l4.add(3);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		triangle.add(l4);
		System.out.println(minimumTotal(triangle));

	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null) return 0;
		List<Integer> sum = new ArrayList<Integer>();
		int len = triangle.size();
		if(len==0) return 0;
		List<Integer> curr = triangle.get(0);
		int currlen;
		sum.add(curr.get(0));
		System.out.println(sum);
		for(int i = 1 ; i  < len ; i++){
			curr = triangle.get(i); //��ȡ��i��
			currlen = curr.size();
			System.out.println("��ǰ����:"+currlen);
			
			List<Integer> next = new ArrayList<Integer>(); //�������·����·��
			next.add(curr.get(0)+sum.get(0)); //�����һ��·��
			for(int j = 1 ; j < currlen-1 ; j++){
				next.add(Math.min(sum.get(j-1),sum.get(j))+curr.get(j)); //�����м�����·��
			}
			
			next.add(curr.get(currlen-1)+sum.get(currlen-2));//�������һ��·��
			
			sum = next;
			System.out.println(next);
		}
		len = sum.size();
		int min = sum.get(0);
		for(int i = 1 ; i < len ; i++){
			if(sum.get(i)<min)
				min = sum.get(i);
		}
		return min;
		
	}
}
