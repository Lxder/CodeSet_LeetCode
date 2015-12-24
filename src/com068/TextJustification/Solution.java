package com068.TextJustification;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

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
		
		int len_line = 0; //һ�еĳ���
		int len_line_word = 0;
		List<String> list = new LinkedList<String>();  
		for(int i = 0 ; i < len ; ){
			int len_curr = 0;
			if(i< len)
				len_curr = words[i].length(); //��ǰ���ʵĳ���
			System.out.println("��ǰ����"+ len_curr+" ��ǰ���ʣ�"+words[i]);
			if(len_curr+len_line+1 <= maxWidth+1 ){ //���Լ��뱾��
				len_line_word += len_curr;//���ʾ����ȣ������ո�
				len_line = len_line+len_curr+1;
				list.add(words[i]); // ����ǰ���ʼ��뼯��
				i++;
			}else{ //������ǰ���ʼӽ����Ϻ󳤶ȳ���maxWidth				
				int onum = maxWidth - len_line_word; //�ո񳤶�
				int wnum = list.size() ; //��ǰ�е�������
				StringBuffer sb = new StringBuffer();
				System.out.println("��ǰ�е���������"+wnum);
				if(wnum == 1){ //��ǰ��ֻ��һ������
					sb.append(list.get(0));
					for(int j = 0 ; j < onum ; j++){
						sb.append(" ");
					}									
					solu.add(sb.toString());					
					//����
					len_line = 0; //һ�еĳ���
					len_line_word = 0;
					list = new LinkedList<String>();  
					continue;									
				}
				int preonum = onum/(wnum-1); // ÿһ���ո�ĳ���
				
				//�Ӻ���ǰ�嵥��
				int lonum = onum ; //ÿһ����Ҫ���㵱ǰʣ��ո񳤶�
				int ponum = preonum; //ÿһ���Ŀո�����				 
				for(int j = wnum-1 ; j>0 ; j--){ //�Ӻ���ǰ
					System.out.println("��ǰÿһ���ո�������"+ponum) ;
					sb.insert(0, list.get(j));
					for(int k = 0 ; k < ponum ; k++)
						sb.insert(0," "); //��ӿո�
					lonum = lonum - ponum; 
					if(j>1)
						ponum = lonum / (j-1);					
				}			
				int leftonum = lonum; //ʣ��ո�
				for(int j = 0 ; j < leftonum ; j++){
					sb.insert(0," ");
				}
				sb.insert(0,list.get(0));				
				solu.add(sb.toString());
				
				//����
				len_line = 0; //һ�еĳ���
				len_line_word = 0;
				list = new LinkedList<String>();  
			}
		}
		
		if(list.size()!=0){//����������һ��Ԫ��û�д���			
			int onum = maxWidth - len_line_word; //�ո񳤶�
			int wnum = list.size() ; //��ǰ�е�������
			StringBuffer sb = new StringBuffer();
			
			if(wnum == 1){ //��ǰ��ֻ��һ������
				sb.append(list.get(0));
				for(int j = 0 ; j < onum ; j++){
					sb.append(" ");
				}									
				solu.add(sb.toString());				
				//����
				len_line = 0; //һ�еĳ���
				len_line_word = 0;
				list = new LinkedList<String>();  		
			}
			else{
				int preonum = onum/(wnum-1); // ÿһ���ո�ĳ���				
				//�Ӻ���ǰ�嵥��
				int lonum = onum ; //ÿһ����Ҫ���㵱ǰʣ��ո񳤶�
				int ponum = preonum; //ÿһ���Ŀո�����				 
				for(int j = wnum-1 ; j>0 ; j--){ //�Ӻ���ǰ
					System.out.println("��ǰÿһ���ո�������"+ponum) ;
					sb.insert(0, list.get(j));
					for(int k = 0 ; k < ponum ; k++)
						sb.insert(0," "); //��ӿո�
					lonum = lonum - ponum; 
					if(j>1)
						ponum = lonum / (j-1);					
				}			
				///δ�꣡������������������������������������
				int leftonum = lonum-ponum; //ʣ��ո�
				for(int j = 0 ; j < leftonum ; j++){
					sb.insert(0," ");
				}
				sb.insert(0,list.get(0));				
				solu.add(sb.toString());
			}
		}
		//�������һ��

		String lastline = solu.get(solu.size()-1);
		String[] arr = lastline.split("\\s+");
		if(arr.length==0) return solu;
		StringBuffer ls = new StringBuffer();
		for(int i = 0 ; i < arr.length-1 ;i++){
			ls.append(arr[i]+" ");
		}
		ls.append(arr[arr.length-1]);
		int llen = ls.length(); //��ǰ����
		for(int i = llen ; i < maxWidth ; i++){
			ls.append(" ");
		}		
		solu.remove(solu.size()-1);
		solu.add(ls.toString());
		return solu;
	}

}
