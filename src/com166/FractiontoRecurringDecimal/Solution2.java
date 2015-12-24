package com166.FractiontoRecurringDecimal;

import java.util.HashMap;

public class Solution2 {

	public static void main(String[] args) {
		System.out.println(1/6.0);
		System.out.println(fractionToDecimal(1,5));
	}

	//��hashset��¼������������������ͬ��ʱ������һ��ѭ����ѭ������Ϊÿ�ε���
	public static String fractionToDecimal(int numerator, int denominator) {  
        if (numerator == 0) return "0";  
        if (denominator == 0) return "";  
          
        String ans = "";  
          
        //������Ϊ����  
        if ((numerator < 0) ^ (denominator < 0)) {  
            ans += "-";  
        }  
          
        //����Ҫ����������תΪ������Ϊ���������intתΪlong  
        long num = numerator, den = denominator;  
        num = Math.abs(num);  
        den = Math.abs(den);  
          
        //�������������  
        long res = num / den;  
        ans += String.valueOf(res);  
          
        //����ܹ����������ؽ��  
        long rem = (num % den) * 10;  
        if (rem == 0) return ans;  
          
        //�����С������  
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();  
        ans += ".";  
        while (rem != 0) {  
            //���ǰ���Ѿ����ֹ�����������ô˵��ѭ���忪ʼ  
            if (map.containsKey(rem)) {  
                int beg = map.get(rem); //ѭ���忪ʼ��λ��  
                String part1 = ans.substring(0, beg);  
                String part2 = ans.substring(beg, ans.length());  
                ans = part1 + "(" + part2 + ")";  
                return ans;  
            }  
     
            
            //�������³�
            System.out.println(res);
            map.put(rem, ans.length());  
            res = rem / den;  
            ans += String.valueOf(res);  
            rem = (rem % den) * 10;
            System.out.println(res);
        }  
          
        return ans;  
    }  

}
