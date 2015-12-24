package com310.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//注意：在树不空的情况下，只可能有1个或者两个根。
//方法：每次都删除叶子节点（叶子节点就是只有一个点与之相邻的节点）
public class Solution2 {
	public static void main(String args[]){
		int n = 6;
		int[][] edges =  {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> solu = findMinHeightTrees(n,edges);
		System.out.println(solu);
	}
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    if (n == 1) return Collections.singletonList(0);

	    //创建邻接表
	    List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
	    for(int i = 0 ; i < n ; i++){
	    	adj.add(new HashSet<Integer>());
	    }
	    for(int[] edge : edges){
	    	adj.get(edge[0]).add(edge[1]);
	    	adj.get(edge[1]).add(edge[0]);
	    }
	    //保存叶子结点的下标
	    List<Integer> leaves = new ArrayList<Integer>();
	    for(int i = 0 ; i < n ; i++){
	    	if(adj.get(i).size()==1)
	    		leaves.add(i);
	    }
	    while(n>2){ //根节点数目不可能大于2
	    	n-=leaves.size();
	    	List<Integer> newLeaves = new ArrayList<Integer>();
	    	for(int i : leaves){	    		
	    		int j = adj.get(i).iterator().next(); //叶子节点只有1个邻接节点，因此只读一次就可
	    		adj.get(j).remove(i);
	    		if(adj.get(j).size()==1) newLeaves.add(j);
	    	}
	    	leaves = newLeaves;
	    }
	    
	    return leaves;
	}

}