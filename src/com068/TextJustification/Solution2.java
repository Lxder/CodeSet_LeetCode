package com068.TextJustification;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
//简化
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		List<String> solu = fullJustify(words,30);
		Iterator<String> itr = solu.iterator();

		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> solu = new LinkedList<String>();
		if(maxWidth==0){ 
			solu.add("");
			return solu;
		}
		int len = words.length;		
		int len_line = 0; //一行的长度
		int len_line_word = 0;
		List<String> list = new LinkedList<String>();  
		for(int i = 0 ; i < len ||list.size()!=0; ){
			int len_curr = 0;
			if(i< len)	len_curr = words[i].length(); //当前单词的长度
			if(len_curr+len_line+1 <= maxWidth+1 && i<len){ //可以加入本行
				len_line_word += len_curr;//单词净长度（不含空格）
				len_line = len_line+len_curr+1;
				list.add(words[i]); // 将当前单词加入集合
				i++;
			}else{ //若将当前单词加进集合后长度超过maxWidth				
				int onum = maxWidth - len_line_word; //空格长度
				int wnum = list.size() ; //当前行单词数量
				StringBuffer sb = new StringBuffer();
				if(wnum == 1){ //当前行只有一个单词
					sb.append(list.get(0));
					for(int j = 0 ; j < onum ; j++)
						sb.append(" ");								
					solu.add(sb.toString());					
					//清零
					len_line = 0; //一行的长度
					len_line_word = 0;
					list = new LinkedList<String>();  
					continue;									
				}
				
				//从后往前插单词
				int lonum = onum ; 		//每一步都要计算当前剩余空格长度
				int ponum = onum/(wnum-1); 			// 每一个空格的长度	 
				for(int j = wnum-1 ; j>0 ; j--){ 	//从后向前
					sb.insert(0, list.get(j));
					for(int k = 0 ; k < ponum ; k++)
						sb.insert(0," "); 		//添加空格
					lonum = lonum - ponum;  	//重新计算剩余空格长度 
					if(j>1) ponum = lonum / (j-1);	//重新计算下一步要插入的空格数	
				}
				for(int j = 0 ; j < lonum ; j++){
					sb.insert(0," ");
				}
				sb.insert(0,list.get(0));				
				solu.add(sb.toString());
				
				//清零
				len_line = 0; //一行的长度
				len_line_word = 0;
				list = new LinkedList<String>();  
			}
		}
		
		//处理最后一行
		String lastline = solu.get(solu.size()-1);
		String[] arr = lastline.split("\\s+");
		if(arr.length==0) return solu;
		StringBuffer ls = new StringBuffer();
		for(int i = 0 ; i < arr.length-1 ;i++)
			ls.append(arr[i]+" ");
		ls.append(arr[arr.length-1]);
		for(int i = ls.length() ; i < maxWidth ; i++)
			ls.append(" ");	
		solu.remove(solu.size()-1);
		solu.add(ls.toString());
		return solu;
	}

}
