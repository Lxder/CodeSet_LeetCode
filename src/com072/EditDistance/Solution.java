package com072.EditDistance;


public class Solution {
	public static void main(String args[]){
		
		System.out.println(minDistance("abcd","acd"));
	}
	public static int minDistance(String word1, String word2) {
		int lenA = (int) word1.length();
		int lenB = (int) word2.length();
		// c[i][j]��ŵ�Ϊword1��0��i-1��word2��0��j-1�����Ӵ��ľ��롣����Ϊc�ı߽粻�㣩
		int[][] c = new int[lenA + 1][lenB + 1];
		// Record the distance of all begin points of each String
		// ��ʼ���߽�
		for (int i = 0; i <= lenA; i++)
			c[i][0] = i;
		for (int j = 0; j <= lenB; j++)
			c[0][j] = j;
		c[0][0] = 0;
		// �����������cԪ��
		for (int i = 1; i <= lenA; i++)
			for (int j = 1; j <= lenB; j++) {
				if (word2.charAt(j - 1) == word1.charAt(i - 1))
					c[i][j] = c[i - 1][j - 1];
				else
					c[i][j] = minValue(c[i][j - 1], c[i - 1][j],
							c[i - 1][j - 1]) + 1;
			}

		for (int i = 0; i <= lenA; i++) {
			for (int j = 0; j <= lenB; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		return c[lenA][lenB];
	}

	// ����3��������Сֵ
	public static int minValue(int A, int B, int C) {
		int tmin = A < B ? A : B;
		return tmin < C ? tmin : C;
	}
}
