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

	//Ĭ��Ϊ��С�� ������Ұ벿�֣��Ѷ������Ұ벿�ֵ���Сֵ
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
	//�������ѣ������벿�֣��Ѷ�����벿�ֵ����ֵ
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

	//����벿��ʼ�ղ������Ұ벿��
	// Adds a number into the data structure.
	public void addNum(int num) {
		int sizemin = minHeap.size();
		int sizemax = maxHeap.size();
		if(sizemin ==0 && sizemax ==0) {
			minHeap.add(num);
			return ;
		}
		
		if(sizemin==sizemax){
			if(num<maxHeap.peek()){ //numС����벿�ֵ����ֵ
				minHeap.add(num);
			}else{ //num���ڵ�����벿�����ֵ
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