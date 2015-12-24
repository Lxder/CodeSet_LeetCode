package com299.BullsandCows;
public class Solution {
	public static void main(String args[]){
		System.out.println(getHint("1123","0111"));
	}
	
    public static String getHint(String secret, String guess) {
        int num_a = 0;
        int len = secret.length();
        if(len==0) return "0A0B";
        int[] arr = new int[10];
        for(int i = 0 ; i < len ; i++){
    		if(secret.charAt(i)==guess.charAt(i)){
    			num_a++;
    		}
    		arr[secret.charAt(i)-'0']++;
    	}
        
        int num_b = 0;
        for(int i = 0 ; i < len ; i++){
        	if(arr[guess.charAt(i)-'0']!=0){
        		num_b++;
        		arr[guess.charAt(i)-'0']--;
        	}
        }
        num_b = num_b - num_a;
        String str = num_a+"A" + num_b + "B";
        return str;
        		
    	
    	
    }
}