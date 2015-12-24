package com295.FindMedianfromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder2 {

	public static void main(String args[]) {
		MedianFinder2 m = new MedianFinder2();

		m.addNum(1);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(2);
		m.addNum(7);
		System.out.println(m.findMedian());
		m.addNum(5);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(6);
		System.out.println(m.findMedian());

	}

	//默认为最小堆 ，存放右半部分，堆顶就是右半部分的最小值
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
	//创建最大堆，存放左半部分，堆顶是左半部分的最大值
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1,
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if(o1.intValue()<o2.intValue()) return 1;
					else if(o1.intValue()>o2.intValue()) return -1;
					return 0; 
				}
			});

	//令左半部分始终不少于右半部分
	// Adds a number into the data structure.
	public void addNum(int num) {
		int sizemin = minHeap.size();
		int sizemax = maxHeap.size();
		if(sizemin ==0 && sizemax ==0) {
			minHeap.add(num);
			return ;
		}
		
		if(sizemin==sizemax){
			if(num<maxHeap.peek()){ //num小于左半部分的最大值
				minHeap.add(num);
			}else{ //num大于等于左半部分最大值
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			}			
		}else if(sizemin>sizemax){
			 if(num<=minHeap.peek()){
				 maxHeap.add(minHeap.poll());
				 minHeap.add(num);
			 }else{
				 System.out.println("right");
				 maxHeap.add(num);
			 }
		}
		System.out.println( minHeap.size()+ "  " +  maxHeap.size());
	}

	// Returns the median of current data stream
	public double findMedian() {
		System.out.println(minHeap.size() + " " + maxHeap.size()+" minHeap "+minHeap.peek()+ " maxHeap "+ maxHeap.peek());
		if(minHeap.size()!=maxHeap.size()) 
			return minHeap.peek();
		else return (minHeap.peek() + maxHeap.peek())/2.0;
	}
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();