package com301.RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	
	public static void main(String args[]){
		String str = "()(()()";
		System.out.println(new Solution().removeInvalidParentheses(str));
	}
	
	//利用BFS
	//思路：遍历每一个子字符串，看是否符合要求
    public List<String> removeInvalidParentheses(String s) {
        List<String> solu = new ArrayList<String>();
        if(s==null)return solu;
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()){
        	s = queue.poll();
        	if(isValid(s)==true){ //s可行，则加入到结果集
        		solu.add(s);
        		found = true;
        	}
        	if(found == true) continue; //找到了一个，就不用再添加新的了，因为新的肯定比当前结果短
        	int len = s.length();
        	for(int i = 0 ; i < len ; i++){
        		if(s.charAt(i)!='(' && s.charAt(i)!=')') continue;
        		String t = s.substring(0,i)+s.substring(i+1);
        		if(!visited.contains(t)){
        			queue.add(t);
        			visited.add(t);
        		}
        	}
        }
        return solu;
    }
    
    public boolean isValid(String s){
    	int len = s.length();
    	int k = 0;
    	for(int i = 0 ; i < len ; i++){
    		if(s.charAt(i)=='(')
    			k++;
    		else if(s.charAt(i)==')'){
    			k--;
    			if(k<0) return false;
    		}
    	}
    	
    	return k==0;
    }
    
/*
 * The idea is straightforward, with the input string s, we generate all possible states by removing one ( or ), check if they are valid, if found valid ones on the current level, put them to the final result list and we are done, otherwise, add them to a queue and carry on to the next level.
 * The good thing of using BFS is that we can guarantee the number of parentheses that need to removed is minimal, also no recursion call is needed in BFS.
 * Thanks to @peisi, we don't need stack to check valid parentheses.
 * Time complexity:
 * In BFS we handle the states level by level, in the worst case, we need to handle all the levels, we can analyze the time complexity level by level and add them up to get the final complexity.
 * On the first level, there's only one string which is the input string s, let's say the length of it is n, to check whether it's valid, we need O(n) time. On the second level, we remove one ( or ) from the first level, so there are C(n, n-1) new strings, each of them has n-1 characters, and for each string, we need to check whether it's valid or not, the total time complexity on this level is (n-1) x C(n, n-1). Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...
 * Finally we have this formula:
 * T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
 * */
}