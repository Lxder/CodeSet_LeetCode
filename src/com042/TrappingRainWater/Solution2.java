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
		int maxindex = 0; //���ҵ���ߵ�λ��
		for (int i = 1; i < len; i++) {
			if (height[i] > height[maxindex])
				maxindex = i;
		}		

		int vwater = 0;//ָʾˮ�������
		
		int sechigh = height[0]; //����θߵĸ߶ȣ�Ҳ����maxindex�����ߵ�
		for(int i = 1 ; i < maxindex ; i++){
			if(height[i] > sechigh ){ //����ǰ�߶ȴ��������ߵģ�������߸߶ȣ��˸߶Ȳ����ܴ�ˮ��
				sechigh = height[i]; 
			}else{ //�߶�С�������ߣ���ˮ��������ϼ��ϵ�ǰ���������ܴ�ˮ�����
				vwater += sechigh - height[i];
			}
		}
		
		//���Ҳ������ͬ����
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
