package com146.LRUCache;

import java.util.HashMap;
import java.util.TreeMap;


//用treemap, 速度很慢.
public class LRUCache2 {
    long timestamp ;
	int capacity;
	int currnum ;
    TreeMap<Long , Integer> tmap ; 		//存放时间--key
    HashMap<Integer,Long> hmap_time ; 	//存放key--时间
    HashMap<Integer, Integer> hmap; 	//存放key--value
    
	
	
    public LRUCache2(int capacity) {
        this.capacity = capacity;        
        currnum = 0;
    	tmap = new TreeMap<Long,Integer>();
    	hmap_time =new HashMap<Integer,Long>();
    	hmap = new HashMap<Integer,Integer>();
    }
    
    public int get(int key) {
    	Integer value = hmap.get(key);
        if(value==null) return -1;
        
    	long currtime = hmap_time.get(key);
        tmap.remove(currtime);
        timestamp++;
        tmap.put(timestamp, key);
        hmap_time.put(key, timestamp);
        System.out.println("get "+hmap_time);
        return value;
        
    }
    
    public void set(int key, int value) {
    	timestamp++;
    	if(currnum==capacity&&!hmap.containsKey(key)){
    		
    		
    		long deltime = tmap.firstKey();
    		int delkey = tmap.firstEntry().getValue();
    		
    		System.out.println("到顶了！"+deltime+" 要删的key"+delkey);
    		tmap.remove(deltime); //删除时间最小的key
    		hmap_time.remove(delkey); //删除key对应的时间
    		hmap.remove(delkey); //删除key对应的value
    		
    		tmap.put(timestamp, key);
    		hmap_time.put(key,timestamp);
    		hmap.put(key, value);
    	}else{
    		if(!hmap.containsKey(key)){
    			System.out.println("正常！");
    			currnum++;
    			tmap.put(timestamp, key);
    			hmap_time.put(key,timestamp);
    			hmap.put(key, value);
    		}else{
    			long currtime = hmap_time.get(key);
    	        tmap.remove(currtime);
    	        tmap.put(timestamp, key);
    			hmap_time.put(key,timestamp);
    			hmap.put(key, value);
    		}
    	}
    	System.out.println("set t-k"+tmap);
    	System.out.println("set k-t"+hmap_time);
    	System.out.println("set k-v"+hmap);
    	
    	
    }
    
    
    public static void main(String args[]){
    	
    	//get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)
    	LRUCache2 l = new LRUCache2(2);
    	System.out.println(l.get(2));
    	l.set(2,6);
    	System.out.println(l.get(1));
    	l.set(1,5);
    	l.set(1,2);
    	System.out.println(l.get(1));
    	System.out.println(l.get(2));
    }
}