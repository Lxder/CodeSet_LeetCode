package com005.LongestPalindromicSubstring;

public class Solution {

	public static void main(String[] args) {
		//String str = longestPalindrome("ababcbaaaaa");
		String str = longestPalindrome("ababccbaaaaeceaa");
		System.out.println("������Ӵ�Ϊ" + str);

	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		
		//�����ǵ������������������
		int maxmid = 0; //�м�λ��
		int max = 0; //������һ��+1 ���� ���ĳ�Ϊ7 ��ômax��4
		//���������
		for (int mid = 0; mid < len; mid++) {
			for (int i = mid, j = mid; i >= 0 && j < len; i--, j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (max < j - mid + 1) {
						max = j -mid+1;
						maxmid = mid;
					}
				}
				else break;
			}
		}
		
		//������˫�����������������
		int maxmid2 = 0; //����λ�ã�ƫ�����Ǹ������� abccba����ômaxmid2ָʾ��һ��c��
		int max2 = 0; // ����/2+1
		for (int mid2 = 0; mid2 < len; mid2++) {
			for (int i = mid2, j = mid2+1; i >= 0 && j < len; i--, j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (max2 < j - mid2 + 1) {
						max2 = j -mid2+1;
						maxmid2 = mid2;
					}
				}
				else break;
			}
		}
		if(max2>max){
			System.out.println("maxmid2:"+maxmid2+" max2:"+max2);
			return (String) s.subSequence(maxmid2-max2+2, maxmid2+max2);
		}else{
			System.out.println("maxmid:"+maxmid+" max:"+max);
			return (String) s.subSequence(maxmid-max+1, maxmid+max);			
		}
	}
}
