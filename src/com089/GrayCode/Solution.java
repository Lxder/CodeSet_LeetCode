package com089.GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> grayCode(int n) {
		int num = 1<<n;
		List<Integer> solu = new ArrayList<Integer>();
		for(int i = 0 ; i < num ; i++){
			int temp = (i>>1)^i;
			solu.add(temp);
		}
		return solu;
	}
/**
 * 
 * Gray Code:  000, 001, 011, 010, 110, 111, 101, 100, ���ұ�ֵΪ ��1�� ��bit��������ˣ�������
 * Binary   :  000, 001, 010, 011, 100, 101, 110, 111
 * ���߾���Binary Code ת��ΪGray Code�ˡ�
 * �磺
 * Binary Code ��1011 Ҫת����Gray Code
 * 1011 = 1����д��һλ��, 1(��һλ��ڶ�λ��� 1^0 = 1), 1(�ڶ�λ������λ�� 0^1=1), 0 (1^1 =0) = 1110
 * ��ʵ�͵��� (1011 >> 1) ^ 1011 = 1110
 *  */

}
