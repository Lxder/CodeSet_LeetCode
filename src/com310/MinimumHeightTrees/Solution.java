package com310.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//-------------------大数据超时------------------
//思路：以每个节点为根，用广搜求出高度
public class Solution {
	public static void main(String args[]){
		int n = 6;
		int[][] edges =  {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> solu = findMinHeightTrees(n,edges);
		System.out.println(solu);
	}
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {    	
    	int[] arr_high = new int[n];    		
    	for(int i = 0 ; i < n ; i++){
    		HashMap<Integer , Set<Integer>> map = init(n,edges);
    		boolean[] flag = new boolean[n];
    		Queue<Set<Integer>> queue = new LinkedList<Set<Integer>>();
        	Queue<Integer> qhigh = new LinkedList<Integer>();
        	Queue<Integer> key = new LinkedList<Integer>();
        	
        	Set<Integer> snext = map.get(i);
        	flag[i] = true; //设定该点已经访问
        	
        	queue.add(snext);
        	key.add(i);
        	qhigh.add(1);
        	
        	while(!queue.isEmpty()){
        		Set<Integer> set = queue.poll();
        		Integer currkey = key.poll();
        		Integer high = qhigh.poll();
        		
        		if(set.size()==0) {
        			System.out.println("哈哈！！");
        			continue;
        		}

        		System.out.println("当前高度"+high);
        		
        		for(Integer curr : set){
        			System.out.println(map);
        			map.get(curr).remove(currkey);
        			System.out.println(map);
        			
        			queue.add(map.get(curr));
        			qhigh.add(high+1);
        			key.add(curr);
        			if(high>arr_high[i])
        				arr_high[i] = high;
        		}
        	}
    	}
    	List<Integer> solu = new ArrayList<Integer>();
    	int min = Integer.MAX_VALUE;
    	for(int i = 0 ; i < n ; i++){
    		if(arr_high[i]<min){
    			min = arr_high[i];
    			solu.clear();
    			solu.add(i);
    		}else if(arr_high[i]==min){
    			solu.add(i);
    		}
    	}
    	return solu;
    }
    public static HashMap<Integer , Set<Integer>> init(int n, int[][] edges){
    	
    	HashMap<Integer , Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
    	for(int i = 0 ; i < n ; i ++){
    		map.put(i, new HashSet<Integer>());
    	}
    	int len = edges.length;
    	for(int i = 0 ; i < len ; i++){
    		map.get(edges[i][0]).add(edges[i][1]);
    		map.get(edges[i][1]).add(edges[i][0]);
    	}
    	return map;
    }
}