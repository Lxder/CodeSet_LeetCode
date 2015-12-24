package com005.LongestPalindromicSubstring;

public class Solution2 {

	public static void main(String[] args) {
		//String str = longestPalindrome("bb");
		String str = longestPalindrome("ababccbaaaaeceaa");
		//String str = longestPalindrome("abcba");
		System.out.println("������Ӵ�Ϊ" + str);

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		
		//isPalindrome[i][j]=true ��ʾ��i��j���Ӵ�Ϊ����
		boolean[][] isPalindrome = new boolean[len][len];
		for(int i = 0 ; i < len ; i++){
			isPalindrome[i][i] =true;	//����Ԫ��Ϊ����
		}
		for(int i = 0 ; i < len-1 ; i++){
			isPalindrome[i+1][i] =true;	//���Խ�����һ��Ҳ����Ϊtrue����������ֻ������Ԫ�ص�ʱ����бȽϵ����
		}
		
		int maxlen = 1;
		int maxi = 0 ; 
		int maxj = 0;
		
		for(int i = 1 ; i < len ; i++){			
			for(int n = 0 ; n<len-i ;n++){ //�����iΪ����ĳ���-1
				if(isPalindrome[n+1][i+n-1]==true&&s.charAt(n)==s.charAt(i+n)){
					isPalindrome[n][i+n]=true;
					if(maxlen<=i){ //���������
						maxlen = i+1;
						maxi=n;
						maxj=i+n;						
					}
				}
				else isPalindrome[n][i+n]=false;
				
			}			
		}
		for(int i = 0 ; i < len ; i++){ //����������
			for(int j = 0   ;j < len ;j ++){
				System.out.print(isPalindrome[i][j]+"\t");
			}
			System.out.println();
		}
		return (String)s.substring(maxi,maxj+1);
	}
}
