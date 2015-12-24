package com241.DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class MyTrueNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str  ="1^0|0|1";
		System.out.println(TrueNum(str,false));

	}
	
	
	public static int TrueNum(String input,boolean mater){
		List<Boolean> solu = helper(input);

		int num = 0;
		for(boolean curr:solu){
			if(curr==mater)
				num++;
		}
		return num;
	}
	
	public static List<Boolean> helper(String input){
		List<Boolean> solu = new ArrayList<Boolean> ();
		
		for(int i = 1 ; i < input.length() ; i+=2){
			String part1 = input.substring(0,i);
			String part2 = input.substring(i+1);
			List<Boolean> solupart1 = helper(part1);
			List<Boolean> solupart2 = helper(part2);

			for(Boolean b1 : solupart1){
				for(Boolean b2 : solupart2){
					switch(input.charAt(i)){
					case '|': solu.add(b1|b2); break;
					case '^': solu.add(b1^b2); break;
					case '&': solu.add(b1&b2); break;					
					}
				}
			}
		}
		
		if(solu.size()==0){
			if(input=="0") solu.add(false);
			else solu.add(true);
		}

		
		return solu;
	}

}
