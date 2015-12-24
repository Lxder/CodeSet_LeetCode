package com301.RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution2 {
	
	public static void main(String args[]){
		String str = "()(()()";
		System.out.println(new Solution2().removeInvalidParentheses(str));
	}
	
	
    public List<String> removeInvalidParentheses(String s) {
        List<String> solu = new ArrayList<String>();
        HashSet<String> set_solu = new HashSet<String>();
        if(s==null)return solu;
        
        int len = s.length();
        int lremove = 0; //Ҫ�Ƴ�������������
        int rremove = 0; //Ҫ�Ƴ�������������
        for(int i = 0 ; i < len ; i++){
        	if(s.charAt(i)=='('){
        		lremove ++ ;
        	}else if(s.charAt(i) == ')'){
        		if(lremove != 0)
        			lremove --;
        		else
        			rremove ++;
        	}
        }
        
        helper(s,new StringBuffer(),lremove,rremove , 0, set_solu);
        solu.addAll(set_solu);
        return solu;	
    }
    
    //lremove: Ҫ�Ƴ������������� rremove��Ҫ�Ƴ������������� pair�������������Ƿ�ƥ��
    public void helper(String str , StringBuffer currsolu, int lremove , int rremove , int pair ,HashSet<String> set_solu ){
    	if(str.length() == 0){
			if(lremove == 0 && rremove ==0 && pair == 0){
				set_solu.add(currsolu.toString());
				return ;
			}
			else return;
    	}
    	char c = str.charAt(0);
    	if(c!='(' && c!=')'){
    		helper(str.substring(1),new StringBuffer(currsolu).append(c),lremove , rremove,pair ,set_solu);
    	}else if(c == '('){ //Ϊ������
    		if(lremove > 0){ //�����Ų����������൱���Ƴ���
    			helper(str.substring(1),new StringBuffer(currsolu),lremove-1,rremove,pair, set_solu);
    		}
    		//���Ƴ����������洦��
    		helper(str.substring(1),new StringBuffer(currsolu).append(c),lremove , rremove ,pair+1,set_solu);
    	}else{ //Ϊ������
    		if(rremove > 0){//�����Ų����������൱���Ƴ���
    			helper(str.substring(1),new StringBuffer(currsolu),lremove,rremove-1,pair, set_solu);
    		}
    		if(pair>0){//ֻ��pair>0��ʱ�� (������������������������)�����ܽ������ż���
    			helper(str.substring(1),new StringBuffer(currsolu).append(c),lremove,rremove,pair-1, set_solu);
    		}
    	}    	
    }
    
}