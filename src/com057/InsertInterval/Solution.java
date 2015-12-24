package com057.InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String args[]){
		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(3,5);
		Interval i3 = new Interval(6,7);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		List<Interval> solu = insert(list,new Interval(4,9));
		for(Interval i :solu){
			System.out.println(i.start+" "+ i.end);
		}

		
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> solu = new ArrayList<Interval>();		
		
		if(intervals==null||intervals.size()==0){
			solu.add(newInterval);
			return solu;
		}
		
		int len = intervals.size();
		if(newInterval.start>intervals.get(len-1).end){
			solu = new ArrayList<Interval>(intervals);
			solu.add(newInterval);
			return solu;
		}
		
		if(newInterval.end<intervals.get(0).start){
			solu.add(newInterval);
			for(Interval val: intervals)
				solu.add(val);		
			return solu;
		}		
		
		Interval temp;
		int start = newInterval.start;
		int newstart = 0 ;
		
		int i ;
		for(i = 0 ; i < len ; i++){
			temp = intervals.get(i);
			if(temp.end<start)
				solu.add(temp);
			else{
				newstart = Math.min(start,temp.start);
				break;
			}
		}
		
		int end = newInterval.end;
		int newend = 0;
		for( ; i<len ; i++){
			temp = intervals.get(i);
			if(temp.start>end){
				newend = Math.max(end, intervals.get(i-1).end);
				break;
			}
		}
		System.out.println("new start: " +newstart +" new end: "+newend);
		if(i==len&&newend==0){
			newend = Math.max(newInterval.end,intervals.get(len-1).end);
			solu.add(new Interval(newstart,newend));
		}else{
			solu.add(new Interval(newstart,newend));
			for(; i<len ; i++){
				solu.add(intervals.get(i));
			}
		}
		return solu;
    }
}

class Interval {
	int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
