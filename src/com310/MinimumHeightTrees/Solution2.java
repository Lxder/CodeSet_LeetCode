package com310.MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//ע�⣺�������յ�����£�ֻ������1��������������
//������ÿ�ζ�ɾ��Ҷ�ӽڵ㣨Ҷ�ӽڵ����ֻ��һ������֮���ڵĽڵ㣩
public class Solution2 {
	public static void main(String args[]){
		int n = 6;
		int[][] edges =  {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> solu = findMinHeightTrees(n,edges);
		System.out.println(solu);
	}
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    if (n == 1) return Collections.singletonList(0);

	    //�����ڽӱ�
	    List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
	    for(int i = 0 ; i < n ; i++){
	    	adj.add(new HashSet<Integer>());
	    }
	    for(int[] edge : edges){
	    	adj.get(edge[0]).add(edge[1]);
	    	adj.get(edge[1]).add(edge[0]);
	    }
	    //����Ҷ�ӽ����±�
	    List<Integer> leaves = new ArrayList<Integer>();
	    for(int i = 0 ; i < n ; i++){
	    	if(adj.get(i).size()==1)
	    		leaves.add(i);
	    }
	    while(n>2){ //���ڵ���Ŀ�����ܴ���2
	    	n-=leaves.size();
	    	List<Integer> newLeaves = new ArrayList<Integer>();
	    	for(int i : leaves){	    		
	    		int j = adj.get(i).iterator().next(); //Ҷ�ӽڵ�ֻ��1���ڽӽڵ㣬���ֻ��һ�ξͿ�
	    		adj.get(j).remove(i);
	    		if(adj.get(j).size()==1) newLeaves.add(j);
	    	}
	    	leaves = newLeaves;
	    }
	    
	    return leaves;
	}

}