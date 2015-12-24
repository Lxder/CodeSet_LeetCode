package com207.CourseSchedule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		
		int[][] prerequisites = {
				{1,0},
				{2,0},
				{0,1}
		};
		System.out.println(canFinish(3,prerequisites));

	}

	//拓扑排序
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int len = prerequisites.length ;
		if(len <=1) return true;

		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		List<Set<Integer>> list2 = new ArrayList<Set<Integer>>();			
		//建表
		for(int i = 0 ; i < numCourses ; i++){
			list.add(new HashSet<Integer>());
			list2.add(new HashSet<Integer>());
		}				
		for(int i = 0 ; i < len ; i++){
			list.get(prerequisites[i][0]).add(prerequisites[i][1]);
			list2.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}		  
	  
		
        // count the pre-courses   计算先导课程数量
        int[] preNums = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
        	Set<Integer> set = list.get(i);
        	preNums[i] = set.size();
        }
        
        for(int i = 0 ; i  < numCourses ; i++){
        	System.out.print(preNums[i]);
        }
        System.out.println();
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
        	
        	System.out.println(flag + " "+set_null);
        	Set<Integer> set = list2.get(set_null);
        	Iterator<Integer> itr = set.iterator();
        	while(itr.hasNext()){
        		preNums[itr.next()]--;
        	}
        	
	        if(flag == false) return false;
	        else flag = false;
	        System.out.println(list);
        }
        return true;
	}
}
