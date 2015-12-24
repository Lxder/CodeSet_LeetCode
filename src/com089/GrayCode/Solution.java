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
 * Gray Code:  000, 001, 011, 010, 110, 111, 101, 100, 最右边值为 “1” 的bit在最左边了，结束。
 * Binary   :  000, 001, 010, 011, 100, 101, 110, 111
 * 再者就是Binary Code 转换为Gray Code了。
 * 如：
 * Binary Code ：1011 要转换成Gray Code
 * 1011 = 1（照写第一位）, 1(第一位与第二位异或 1^0 = 1), 1(第二位异或第三位， 0^1=1), 0 (1^1 =0) = 1110
 * 其实就等于 (1011 >> 1) ^ 1011 = 1110
 *  */

}
