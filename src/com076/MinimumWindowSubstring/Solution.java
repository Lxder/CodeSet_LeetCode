package com076.MinimumWindowSubstring;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("vva","va"));
	}

	//ͬ���֮��3.5 ���ժҪ������
	public static String minWindow(String s, String t) {
		int len_s = s.length();
		int len_t = t.length();
		int minlen = Integer.MAX_VALUE; //��̳���
		int minstart  = Integer.MIN_VALUE;
		int minend = Integer.MIN_VALUE;
		int start=0 ; 
		int end=0;
		
		
		HashMap<Character,Integer> map_t = new HashMap<Character,Integer>(); //���ڱ���t�ڵ��ַ��������Ժ����
		HashMap<Character,Integer> map_tcount = new HashMap<Character,Integer>(); //���ڱ���t�ڵ��ַ��ľ�������
		for(int i = 0 ; i < len_t ; i++){
			map_t.put(t.charAt(i),0);
			Integer curr =map_tcount.get(t.charAt(i)) ; 
			if(curr==null){				
				map_tcount.put(t.charAt(i),1);				
			}
			else
				map_tcount.put(t.charAt(i),map_tcount.get(t.charAt(i))+1);
		}
		System.out.println(map_t);
		System.out.println(map_tcount);
		int tcount = 0;
		for(int i = 0 ; i < len_s ; i++){
			Integer currc = map_t.get(s.charAt(i));
			if(currc!=null){ 	//���map�ڴ��ڸ��ַ�,˵���Ѿ���ӽ�ȥ��
				if(tcount==0) start = minstart = i;
				if(currc<map_tcount.get(s.charAt(i)))
					tcount++;
								
				map_t.put(s.charAt(i),	map_t.get(s.charAt(i))+1);
			
			}
			if(tcount == len_t){ //�Ѿ��ҵ�һ������
				end = minend = i; //ָ���β������β�����ڼ����ڣ�
				minlen = minend-minstart;
				break;
			}
		}
				
		System.out.println("��ʼλ��:"+minstart+" ����λ�ã�"+minend+" ���ȣ�"+minlen+" ����:"+tcount);
		
		if(minlen==Integer.MAX_VALUE) return "";
		
		start = minstart ;
		while(start< len_s){
			System.out.println(map_t);
			char currchar = s.charAt(start);
			int cnum = map_t.get(currchar);
			if(cnum==1&&end==len_s-1) break;
			System.out.println("��ǰԪ�أ�"+currchar+" ʣ��������"+cnum);
			if(cnum==map_tcount.get(currchar)){ //Ҫ��������ĸ�ڼ�����ֻ��һ���ˣ���Ҫ��end��ʼ����ҵ�һ����Ҫ��������ĸ��ͬ����ĸ
				map_t.put(currchar,	cnum-1);
				
				for(int i = end+1 ; i < len_s ; i++){
					Integer currc = map_t.get(s.charAt(i)); //����ȡԪ��
					if(currc!=null){ //����ǰԪ���Ǽ����ڵ���ĸ����Ҫ������ĸ������
						map_t.put(s.charAt(i),	currc+1);
					}
					if(s.charAt(i)==currchar){//����ǰ��ĸΪҪѰ�ҵ���ĸ�����ȷ����βλ��
						end = i; //���½�βλ��
						break;
					}
				}				
				System.out.print("PART1:");				
			}
			else{ //Ҫ��������ĸ�ڼ����в�ֹһ��,��start��ʼ����ҵ�һ����Ҫ��������ĸ��ͬ����ĸ			
				map_t.put(currchar,cnum-1); //���¼�������Ӧ��ĸ������
				
				System.out.print("PART2:");
			}

			//����startλ��
			for(int i = start+1 ; i < end ; i++){
				Integer currc = map_t.get(s.charAt(i)); //����ȡԪ��
				if(currc!=null){ //����ǰԪ���Ǽ����ڵ���ĸ����Ҫ������ʼλ��
					start = i;
					break;
				}					
			}
			
			//������������������������
			if(map_t.get(currchar)<map_tcount.get(currchar)){
				break;
			}
			
			
			//�����������Ҫ����start��λ��
			//��һ�������Ȼ����endλ��
			//�ڶ��ֲ���Ҫ����end			
			System.out.println("��ʼλ��:"+start+" ����λ�ã�"+end+" ���ȣ�"+(end-start));

			if(end-start<minlen){
				minlen =end-start;
				minstart = start ;
				minend = end;
			}
			
			System.out.println("minstart: "+minstart+" minend:"+minend+" minlen:"+minlen);
			//if(flag ==true) break;
		}

		return s.substring(minstart,minend+1);
	}

}
