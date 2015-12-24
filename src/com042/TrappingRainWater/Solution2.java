package com042.TrappingRainWater;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1,0};
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
		int len = height.length;
		if(len==0) return 0;
		int maxindex = 0; //先找到最高的位置
		for (int i = 1; i < len; i++) {
			if (height[i] > height[maxindex])
				maxindex = i;
		}		

		int vwater = 0;//指示水的总体积
		
		int sechigh = height[0]; //保存次高的高度，也就是maxindex左侧最高的
		for(int i = 1 ; i < maxindex ; i++){
			if(height[i] > sechigh ){ //若当前高度大于左侧最高的，更新最高高度（此高度不可能存水）
				sechigh = height[i]; 
			}else{ //高度小于左侧最高，在水的总体积上加上当前竖条部分能存水的体积
				vwater += sechigh - height[i];
			}
		}
		
		//对右侧进行相同操作
		sechigh = height[len-1];
		for(int i = len-2 ; i > maxindex ; i--){
			if(height[i] > sechigh ){ 
				sechigh = height[i]; 
			}else{
				vwater += sechigh - height[i];
			}
		}
		
		return vwater;

	}

}
