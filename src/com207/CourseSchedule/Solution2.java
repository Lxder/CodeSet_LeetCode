package com207.CourseSchedule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length ;
        if(len <=1) return true;
        
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();

		for(int i = 0 ; i < numCourses ; i++){
			list.add(new HashSet<Integer>());
		}
		
		for(int i = 0 ; i < len ; i++){
			list.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		
        int[] preNums = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
        	Set<Integer> set = list.get(i);
        	preNums[i] = set.size();
        }
        
        boolean flag = false;
        for(int n = 0 ; n < numCourses ; n++){
	        int set_null = 0;
        	for(int i = 0 ; i < numCourses ; i++){
	        	if(preNums[i]==0){
	        		flag = true;
	        		preNums[i]= -1;
	        		set_null = i;
	        		break;
	        	}
	        }
        	for(int j = 0 ; j < numCourses ; j++){
    			Set<Integer> set = list.get(j);
    			if(set.contains(set_null)){
    				preNums[j]--;
    			}
    		}
	        if(flag == false) return false;
	        else flag = false;
        }
        return true;
    }
}