package com318.MaximumProductofWordLengths;

//方法2  利用位运算
public class Solution2 {
	public static void main(String args[]) {
		String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		System.out.println(maxProduct(words));
	}

	public static int maxProduct(String[] words) {
		int len = words.length;
		if (len == 0 || len == 1)
			return 0;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			int slen = words[i].length();
			for (int j = 0; j < slen; j++) {
				int nbit = words[i].charAt(j) - 'a';
				arr[i] = arr[i] | (1 << nbit);
			}
		}
		int maxlen = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((arr[i] & arr[j]) == 0) {
				//if ((arr[i] ^ arr[j]) == (arr[i] + arr[j])) {
					int currlen = words[i].length() * words[j].length();
					if (currlen > maxlen)
						maxlen = currlen;
				}
			}
		}
		return maxlen;
	}
}