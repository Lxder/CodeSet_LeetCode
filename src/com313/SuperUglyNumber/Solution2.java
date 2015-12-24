package com313.SuperUglyNumber;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
	public static void main(String args[]){
		int[] primes ={2, 7, 13, 19};
		System.out.println(nthSuperUglyNumber(12,primes));
	}
    public static int nthSuperUglyNumber(int n, int[] primes) {
    	int len = primes.length;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(len,new Comparator<Node>(){
			@Override
			public int compare(Node arg0, Node arg1) {
				if(arg0.fact>arg1.fact) return 1;
				else if(arg0.fact < arg1.fact) return -1;
				return 0;
			}
        });
        
        long[] ugly = new long[n];
        ugly[0] = 1 ;
        for(int i = 0 ;i < len ; i++){
        	queue.add(new Node(primes[i],0,primes[i]));
        }        
        
        for(int i = 1 ; i < n ; i++){
        	long curmin= queue.peek().fact;
        	ugly[i] = curmin;
        	//System.out.print(ugly[i]+" ");
        	while(queue.peek().fact == curmin){
        		Node curr = queue.poll();
        		curr.index++;
        		curr.fact = ugly[curr.index]*curr.prime;
        		queue.add(curr);
        	}
        }
        return (int)ugly[n-1];
    }

}

class Node{
	long fact;
	int index;
	int prime;
	Node(long fact , int index , int prime){
		this.fact = fact; 
		this.index = index;
		this.prime = prime;
	}
}