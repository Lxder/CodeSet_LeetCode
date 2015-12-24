package com056.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public static void main(String args[]){
		Interval i1 = new Interval(8,10);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(1,3);
		Interval i4 = new Interval(9,18);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		List<Interval> solu = merge(list);
		
		for(int i = 0 ; i < solu.size() ; i++){
			System.out.println(solu.get(i).start+" "+solu.get(i).end);
		}
	}
	
	
	public static List<Interval> merge(List<Interval> intervals) {
			List<Interval> solu = new LinkedList<Interval>();
			if(intervals==null||intervals.size()==0) return solu;
			int len = intervals.size();		
			Interval[] arrs = new Interval[len];
			for(int i = 0 ; i < len ; i++){
				arrs[i] = intervals.get(i);
			}
			
			//先将数组按照start排序
			Arrays.sort(arrs,new IntervalComparator());		
		
			for(int i = 1 ; i < len ; i++){
				if(arrs[i-1].end>=arrs[i].start){
					arrs[i].start = arrs[i-1].start;
					arrs[i].end = Math.max(arrs[i-1].end, arrs[i].end);
				}else{
					solu.add(arrs[i-1]);
				}
			}
			
			solu.add(arrs[len-1]);
							
			return solu;
	}
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval one, Interval another) {
        return one.start - another.start; 
    }
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}