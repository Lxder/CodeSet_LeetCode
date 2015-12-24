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
		List<Integer> partnegnum = new LinkedList<Integer>(); //�洢ÿһ���ֵĸ�������
		List<Integer> partproduct = new LinkedList<Integer>();
		List<Integer> figrenum = new LinkedList<Integer>(); //�洢ÿһ�������ָ���(����)
		partnegnum.add(0);
		
		
		int currnegnum = 0; //��ǰ���ָ�������
		int currfignum  = 0; //��ǰ�������ָ���
		int currproduct = 1; //��ǰ���ֳ˻�
		
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
				System.out.println("��ǰ�˻���"+currproduct);
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
			partnegnum.add(currnegnum); //�����һ����ӽ�ȥ
			partproduct.add(currproduct); //�����һ�γ˻��ӽ�ȥ
		}else{
			partnegnum.add(currnegnum); //�����һ����ӽ�ȥ
			partproduct.add(Integer.MIN_VALUE); //�����һ�γ˻��ӽ�ȥ
		}
		partnegnum.remove(0); //����һ��0ȥ��
		
		System.out.println("negnum "+negnum+" partnegnum "+partnegnum);
		System.out.println("figrenum "+figrenum);
		System.out.println("zeronum "+zeronum+" loc "+zeroloc);
		System.out.println("�˻����ϣ�"+partproduct);
		
		int start = 0;
		int end = Integer.MIN_VALUE;
		for(int i = 0 ; i < zeronum ; i++){
			int currloc = zeroloc.get(i);
			end = currloc - 1;
			if(partnegnum.get(i)%2==0){ //������ĸ�������Ϊż��
				int currp = partproduct.get(i);
				if(currp>solu) solu = currp;					
			}else{ //����������Ϊ��������Ҫ���㱾��������˻�
				solu = Math.max(solu,getMaxProduct(start,end,nums));
				System.out.println("��ǰ�����"+solu);
			}
			start  =currloc+1;
		}
		
		end = len-1;
		if(partnegnum.get(zeronum)%2==0){ //������ĸ�������Ϊż��
			int currp = partproduct.get(zeronum);
			if(currp>solu) solu = currp;					
		}else{ //����������Ϊ��������Ҫ���㱾��������˻�
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
		int lproduct = 1 ; //��һ���˻�		
		for(left = start ; left <= end ;left++){
			if(nums[left]<0) break;
			lproduct = lproduct * nums[left];
		}
		if(nums[start]<0) lproduct = nums[start];
		
		int rleft ;
		int rlproduct = 1; //�ڶ����˻�
		for(rleft = left+1 ; rleft <= end ; rleft++){
			rlproduct*=nums[rleft];
		}		
		
		
		int right;
		int rproduct = 1; //�������˻�
		for(right = end ; right >= start ; right--){
			if(nums[right]<0) break;
			rproduct *= nums[right];
		}
		if(nums[end]<0) rproduct = nums[end];
		
		int lright ;
		int lrproduct = 1; //���ĸ��ɼ�
		for(lright= right - 1 ; lright>=start ;lright--){
			lrproduct *= nums[lright];
		}		
		
		System.out.println("���ֳ˻���"+lproduct+" "+rlproduct+" "+rproduct+" "+lrproduct);
		currmax = Math.max(Math.max( Math.max(lproduct, rlproduct),rproduct),lrproduct);
		return currmax;
		
	}

}
