package com284.PeekingIterator;

import java.util.Iterator;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PeekingIterator implements Iterator<Integer> {
	Integer n = null;
	Iterator<Integer> itr ;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(n!=null) return n;
		else{
			n = itr.next();
			return n;
		}
		
		
		
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(n!=null) {
	    	int temp = n;
	    	n = null;
	    	return temp;
	    
	    }
	    return itr.next();
	}

	@Override
	public boolean hasNext() {
	    if(n!=null) return true;
	    return itr.hasNext();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
