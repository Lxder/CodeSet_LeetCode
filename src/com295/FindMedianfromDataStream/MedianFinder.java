package com295.FindMedianfromDataStream;

import java.util.ArrayList;
import java.util.List;

class MedianFinder {
	
	public static void main(String args[]){
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(7);
		System.out.println(m.findMedian());
		m.addNum(5);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(6);
		System.out.println(m.findMedian());
		System.out.println(m.list);
		
	}

	List<Integer> list = new ArrayList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
    	int len = list.size();
    	
    	int low = 0 ; 
    	int high = len-1;
    	int mid;
    	while(low<=high){    		
    		mid = low + (high-low)/2;    		
    		int tempmid = list.get(mid);
    		if(num <= tempmid){
    			high = mid -1;
    		}else{
    			low = mid +1 ;
    		}
    	}
    	
        list.add(low,num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int len = list.size();
    	if(len==0) return 0;
    	if(len%2==1) return list.get(len/2);
    	else return(list.get(len/2-1)+list.get(len/2))/2.0;        
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();