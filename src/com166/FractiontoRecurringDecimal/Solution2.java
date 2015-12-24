package com166.FractiontoRecurringDecimal;

import java.util.HashMap;

public class Solution2 {

	public static void main(String[] args) {
		System.out.println(1/6.0);
		System.out.println(fractionToDecimal(1,5));
	}

	//用hashset记录，余数，当余数有相同的时候，则获得一个循环，循环内容为每次的商
	public static String fractionToDecimal(int numerator, int denominator) {  
        if (numerator == 0) return "0";  
        if (denominator == 0) return "";  
          
        String ans = "";  
          
        //如果结果为负数  
        if ((numerator < 0) ^ (denominator < 0)) {  
            ans += "-";  
        }  
          
        //下面要把两个数都转为正数，为避免溢出，int转为long  
        long num = numerator, den = denominator;  
        num = Math.abs(num);  
        den = Math.abs(den);  
          
        //结果的整数部分  
        long res = num / den;  
        ans += String.valueOf(res);  
          
        //如果能够整除，返回结果  
        long rem = (num % den) * 10;  
        if (rem == 0) return ans;  
          
        //结果的小数部分  
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();  
        ans += ".";  
        while (rem != 0) {  
            //如果前面已经出现过该余数，那么说明循环体开始  
            if (map.containsKey(rem)) {  
                int beg = map.get(rem); //循环体开始的位置  
                String part1 = ans.substring(0, beg);  
                String part2 = ans.substring(beg, ans.length());  
                ans = part1 + "(" + part2 + ")";  
                return ans;  
            }  
     
            
            //继续往下除
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
