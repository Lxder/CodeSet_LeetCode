package com152.MaximumProductSubarray;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String args[]){
		//int[] nums = {2,3,-1,-2,-4,0,-5,-6,0,-7,2,5};
		int[] nums = {0,-2,0};
		System.out.println(maxProduct(nums));
	}
	
	public static int maxProduct(int[] nums) {
		int solu = Integer.MIN_VALUE;
		int len = nums.length;
		
		int z  = 0;
		for(z = 0 ; z < len ; z++){
			if(nums[z]!=0) break;
		}
		if(z==len) return 0;
		
		int negnum = 0 ;
		int zeronum = 0;
		List<Integer> zeroloc = new LinkedList<Integer>();
		List<Integer> partnegnum = new LinkedList<Integer>(); //存储每一部分的负数个数
		List<Integer> partproduct = new LinkedList<Integer>();
		List<Integer> figrenum = new LinkedList<Integer>(); //存储每一部分数字个数(非零)
		partnegnum.add(0);
		
		
		int currnegnum = 0; //当前部分负数个数
		int currfignum  = 0; //当前部分数字个数
		int currproduct = 1; //当前部分乘积
		
		for(int i = 0 ; i < len ; i++){			
			if(nums[i]<0) {
				negnum++;	
				currnegnum++;
			}			
			if(nums[i]!=0){
				currfignum ++;
				currproduct*=nums[i];
			}			
			if(nums[i]==0){				
				zeronum++;				
				zeroloc.add(i);
				partnegnum.add(currnegnum);
				if(currfignum==0)
					partproduct.add(0);
				else
					partproduct.add(currproduct);				
				
				figrenum.add(currfignum);				
				System.out.println("当前乘积："+currproduct);
				currproduct = 1;
				currnegnum=0;
				currfignum = 0;
			}			
		}
		
		if(zeronum==0){
			partnegnum.add(currnegnum);
			partproduct.add(currproduct);
		}else
		if(zeroloc.get(zeroloc.size()-1)!=len-1){
			partnegnum.add(currnegnum); //将最后一段添加进去
			partproduct.add(currproduct); //将最后一段乘积加进去
		}else{
			partnegnum.add(currnegnum); //将最后一段添加进去
			partproduct.add(Integer.MIN_VALUE); //将最后一段乘积加进去
		}
		partnegnum.remove(0); //将第一个0去掉
		
		System.out.println("negnum "+negnum+" partnegnum "+partnegnum);
		System.out.println("figrenum "+figrenum);
		System.out.println("zeronum "+zeronum+" loc "+zeroloc);
		System.out.println("乘积集合："+partproduct);
		
		int start = 0;
		int end = Integer.MIN_VALUE;
		for(int i = 0 ; i < zeronum ; i++){
			int currloc = zeroloc.get(i);
			end = currloc - 1;
			if(partnegnum.get(i)%2==0){ //本区域的负数个数为偶数
				int currp = partproduct.get(i);
				if(currp>solu) solu = currp;					
			}else{ //若负数个数为奇数，需要计算本区域的最大乘积
				solu = Math.max(solu,getMaxProduct(start,end,nums));
				System.out.println("当前结果："+solu);
			}
			start  =currloc+1;
		}
		
		end = len-1;
		if(partnegnum.get(zeronum)%2==0){ //本区域的负数个数为偶数
			int currp = partproduct.get(zeronum);
			if(currp>solu) solu = currp;					
		}else{ //若负数个数为奇数，需要计算本区域的最大乘积
			solu = Math.max(solu,getMaxProduct(start,end,nums));
		}				
		if(zeronum!=0&&solu<0) return 0;
		return solu;
	}
	
	public static int getMaxProduct(int  start , int end , int[] nums) {
		
		
		System.out.println("start:"+start+" end:"+end);
		if(end-start ==0) return nums[end];
		int currmax ;
		
		int left ;
		int lproduct = 1 ; //第一个乘积		
		for(left = start ; left <= end ;left++){
			if(nums[left]<0) break;
			lproduct = lproduct * nums[left];
		}
		if(nums[start]<0) lproduct = nums[start];
		
		int rleft ;
		int rlproduct = 1; //第二个乘积
		for(rleft = left+1 ; rleft <= end ; rleft++){
			rlproduct*=nums[rleft];
		}		
		
		
		int right;
		int rproduct = 1; //第三个乘积
		for(right = end ; right >= start ; right--){
			if(nums[right]<0) break;
			rproduct *= nums[right];
		}
		if(nums[end]<0) rproduct = nums[end];
		
		int lright ;
		int lrproduct = 1; //第四个成绩
		for(lright= right - 1 ; lright>=start ;lright--){
			lrproduct *= nums[lright];
		}		
		
		System.out.println("部分乘积："+lproduct+" "+rlproduct+" "+rproduct+" "+lrproduct);
		currmax = Math.max(Math.max( Math.max(lproduct, rlproduct),rproduct),lrproduct);
		return currmax;
		
	}

}
