package com218.TheSkylineProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] buildings = {  {2, 9, 10},{3,7,15},{5,12,12},{15,20,10},{19,24,8} };
		//int[][] buildings = {  {1,2,1},{1,2,2},{1,2,3}};
	//	int[][] buildings = {  {1,2,1},{2147483646,2147483647,2147483647}};
//		int[][] buildings = {{2,4,7},{2,4,5},{2,4,6}};
		//int[][] buildings ={{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
		int[][] buildings = {{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
		
		List<int[]> solu = getSkyline(buildings);

		for (int[] curr : solu) {
			System.out.println(curr[0] + " " + curr[1]);
		}
		System.out.println(solu);

	}
//���󣡣����������������������¸߶ȵķ�������
	// ����2���������,��һ�ΰ��ս����￪ʼ�������򣬵ڶ��ΰ��ս����������������
	public static List<int[]> getSkyline(int[][] buildings) {
		List<int[]> solu = new LinkedList<int[]>();
		int row = buildings.length;	
		if(row==0) return solu;
		//sort(buildings,new int[]{0,2});//�Ȱ��տ�ʼ�����������
		int preh = buildings[0][2];
		int endx = buildings[0][1];
		if(preh!=0){
			solu.add(new int[]{buildings[0][0],preh});
		}		
		for(int i = 1 ; i < row ; i++){
			if(buildings[i][0]>endx) //�����˼�ϵ����
				preh = 0;
			if(preh<buildings[i][2]){
				solu.add(new int[]{buildings[i][0],buildings[i][2]});		
				preh = buildings[i][2]; //���µ�ǰ�߶�		(��ô���²��ԣ���������������������������)
			}	
			
			endx = Math.max(endx, buildings[i][1]);//������Զ����λ��						
		}
		
		
		//////////////////////
		sort(buildings,new int[]{1,2});//�ٰ��ս����������
		preh = buildings[row-1][2];
		endx = buildings[row-1][0];
		if(preh!=0){
			solu.add(new int[]{buildings[row-1][1],0});
		}
		for(int i = row-2 ; i>=0 ; i--){
			if(buildings[i][1]<endx) //�����˼�ϵ����
				preh = 0;
			if(preh<buildings[i][2]){
				solu.add(new int[]{buildings[i][1],preh});
				preh = buildings[i][2]; //���µ�ǰ�߶�  (��ô���²��ԣ���������������������������)
			}	
			
			endx = Math.min(endx, buildings[i][0]);//������Զ����λ��			
		}

		int slen = solu.size();
		int[][] arr=  new int[slen][2];
		for(int i = 0 ; i <slen ; i++){
			arr[i] = solu.get(i);
		}
		sort(arr,new int[]{0});
		
		
		List<int[]> fsolu = new LinkedList<int[]>();		
		fsolu.add(arr[0]);
		int cx = arr[0][0];
		
		for(int i = 1 ; i <slen ; i++){			
			if(arr[i][0]==cx){
				fsolu.remove(fsolu.size()-1);				
			}
			fsolu.add(arr[i]);
			cx = arr[i][0];			
		}	
		return fsolu;
		
	
		
		
	}

	public static void sort(int[][] ob, final int[] order) {
		Arrays.sort(ob, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				int[] one = (int[]) o1;
				int[] two = (int[]) o2;
				for (int i = 0; i < order.length; i++) {
					int k = order[i];
					if (one[k] > two[k]) {
						return 1;
					} else if (one[k] < two[k]) {
						return -1;
					} else {
						continue; // �����һ�����ȽϽ����ȣ���ʹ�õڶ����������бȽϡ�
					}
				}
				return 0;
			}
		});
	}

}
