package com149.MaxPointsonaLine;

import java.util.HashMap;

public class Solution {

	/**
	 * @param args
	 */
	
	//[[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point (2,3);
		Point p2 = new Point (3,3);
		Point p3 = new Point (-5,3);
		Point p4 = new Point (0,-70);
		Point p5 = new Point (0,-70);
		Point p6 = new Point (1,-1);
		Point p7 = new Point (21,10);
		Point p8 = new Point (42,90);
		Point p9 = new Point (-42,-230);
		
		
		Point[] points = {p1,p2,p3};
		System.out.println(maxPoints(points));

	}

	public static int maxPoints(Point[] points) {
		int len = points.length;
		if(len<=2) return len;
		int maxnum = 0;
		HashMap<Double,Integer>  map = new HashMap<Double,Integer>();		
		for(int i = 0 ; i < len ; i++){
			map = new HashMap<Double ,Integer>();
			int maxnum_curr = 0;
			int samenum = 1;
			Point currp = points[i];			
			for(int j = i+1 ; j < len ; j++){
				double k = 0 ;
				if(points[j].x ==currp.x){ 
					if(points[j].y==currp.y){ //两个点是同一个点
						samenum++;
						continue;
					}else{//x坐标相等，斜率不存在
						k = (double) Integer.MAX_VALUE;
					}
				}else{					
					k = (points[j].y-currp.y)/(double)(points[j].x-currp.x);
					if(k==-0.0 ) k = 0; 					
				}
				
				if(!map.containsKey(k)){
					map.put(k,1);	
					if(maxnum_curr<1)
						maxnum_curr = 1;
				}else{
					int knum = map.get(k)+1;
					map.put(k,knum);
					if(knum>maxnum_curr)
						maxnum_curr = knum;
				}
			}			
			
			maxnum_curr = maxnum_curr+samenum;
			if( maxnum_curr>maxnum)
				maxnum = maxnum_curr;
		}
		return maxnum;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}