package com077.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine(5,3);

	}
	
	
	//��1��n��ѡ��k��������list
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> solu = new ArrayList<List<Integer>>();
		if(k==0) return solu;
		int[] tag = new int[k]; //ÿһλ�����趨һ��tag
		int[] start = new int[k]; //ÿλ���ֵ���Сֵ
		int[] end = new int[k]; //ÿλ���ֵ����ֵ����������ѡ�����Ͻ��ÿһλ������С�������У�
		
		for(int i = 0 ; i < k ; i++){
			start[i] = i+1;
			end[i] = n-k+1 +i;
			tag[i] = i+1;
			
			System.out.println(i+" "+start[i]+" "+end[i]);
		}
		
		

		while(tag[0]<=end[0]){
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0 ; i < k ; i++){
				list.add(tag[i]);
			}
			solu.add(list);				
			System.out.println(list);
			
			tag[k-1]++;
			int i ;
			for(i = k-1 ; i >0  ; i--){
				if(tag[i]>end[i]){ //����ǰ�����Ѿ���ͷ�ˣ��ǰ��ͷ��ʼ��ǰһ�����ּ�1
					tag[i-1]++; 
				}
				else break;
			}
			//�������forѭ����ֻ�ǵõ�����ǰ��仯���Ǹ�Ԫ�أ�������ڸ��¹����ж���������
			//������������ǰ��仯��Ԫ������������Ԫ�ء�������Ԫ�ص�����ԭ��ֻ�������ı�ǰ��Ĵ�1����
			for(int j = i ; j <k-1 ; j++){ 
				tag[j+1] = tag[j]+1;
			}
		}
		
		return solu;
    }

}
