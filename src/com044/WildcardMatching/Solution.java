package com044.WildcardMatching;


public class Solution {

	public static void main(String[] args) {
		String s1 = "**a****a**b***ab***a*bab";
		String s2 = s1.replaceAll("\\*+", "*");
		System.out.println(s1);
		System.out.println(s2);
		// TODO Auto-generated method stub
		System.out.println(isMatch("abbabaaabbabbaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabb"
				,"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaabbbb"));
	}
//------------³¬Ê±£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡
	public static boolean isMatch(String s, String p) {
		int lens = s.length();
		p = p.replaceAll("\\*+", "*");
		int lenp = p.length();
		if(lens==0&&lenp==0) return true;
		
		int i ;
		for( i = 0 ; i < lens ; i++){
			if(i>=lenp) return false;
			if(s.charAt(i)==p.charAt(i)||p.charAt(i)=='?'){
				continue;
			}else{
				if(s.charAt(i)!=p.charAt(i) && p.charAt(i)!= '*'){
					return false;
				}else{
					for(int j = i ; j<=lens ; j++ ){
						//System.out.println(s.substring(j)+" j"+j+" "+p.substring(i+1));
						if(isMatch(s.substring(j),p.substring(i+1)) == true)
							return true;
					}
				}
			}
		}
		if(i<lenp&&p.charAt(lenp-1)!='*') return false;		
		return true;
				
	}
	

}
