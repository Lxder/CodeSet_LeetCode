package com018.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {-2,0,1,1,2};
		//int[] nums ={1, 0, -1 ,0 ,-2 ,2};
		int[] nums ={0,0,0,0};
		//int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		//int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		List<List<Integer>> list = fourSum(nums,0);
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			List l = (List)itr.next();
			System.out.println(l);
		}		
	}
	
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		int twotarg ; //��ŵ�ǰĿ���
		int start  ,end; 
		int sum ;
		List<List<Integer>> solu = new ArrayList<List<Integer>> (); 
		for(int m = 0 ; m < len-3 ; m++){
			if(m!=0&&nums[m]==nums[m-1]) //�����һ��m�͵�ǰ��m��һ���ģ�ֱ�Ӵ�����һ��i�����ˣ������
				continue;
		
			for(int i = m+1 ; i < len-2 ; i++){
				if(i!=m+1&&nums[i]==nums[i-1]) //�����һ��i�͵�ǰ��i��һ���ģ�ֱ�Ӵ�����һ��i�����ˣ������
					continue;
				
				twotarg =  target -(nums[m]+ nums[i]); //ֻҪ��������������Ϊtwotarg����			
				start = i+1; end = len -1 ;
				while(start<end){ 
					sum = nums[start]+ nums[end];
					if(sum > twotarg) end--;
					else if(sum < twotarg) start++;
					else{ 
		                List<Integer> list = new ArrayList<Integer>();
		                list.add(nums[m]);
		                list.add(nums[i]);
		                list.add(nums[start]);
		                list.add(nums[end]);    
		                solu.add(list);
		                start++;
		                end --;
		                //�����һ��STARTԪ�غ͵�ǰ����ͬ����û�б�Ҫ�����һ���ˣ�ֱ������
		                while(start < end && nums[start] == nums [start-1]){ 
		                	start++;
		                }
		                //�����һ��endԪ�غ͵�ǰ��end��ͬ����û�б�Ҫ�ڴ���һ�飬ֱ������
		                while(start < end && nums[end] == nums[end+1]){ 
		                	end--;
		                }
					}
				}
			}
		}
	    return solu;
	}
	
	

}
