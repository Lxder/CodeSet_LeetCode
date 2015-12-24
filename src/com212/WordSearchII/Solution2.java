package com212.WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(findWords(board,words));
		

	}

	public static List<String> findWords(char[][] board, String[] words) {
		HashSet<String> solu = new HashSet<String>();
		Trie trie = new Trie();
		for(String w : words){
			trie.insert(w); //将当前单词加入到字典树中
		}
		
		int row = board.length;
		int col = board[0].length;
		boolean[][] visited  = new boolean[row][col];
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				dfs(board,visited,i,j,"",trie,solu);
			}
		}
		return new ArrayList<String>(solu);
	}
	
	//采用深搜
	public static void dfs(char[][] board, boolean[][] visited, 
			int x, int y, String word,  Trie trie ,HashSet<String> solu) {
		

		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return ;

		if (visited[x][y])
			return ;

		word += board[x][y];
		if(!trie.startsWith(word)) return;
		
		if(trie.search(word)==true) //如果找到了单词		
			solu.add(word);
		

		visited[x][y] = true;		
		dfs(board, visited, x - 1, y, word, trie, solu);
		dfs(board, visited, x + 1, y, word, trie, solu);
		dfs(board, visited, x, y - 1, word, trie, solu);
		dfs(board, visited, x, y + 1, word, trie, solu);
		visited[x][y] = false; 
		
	}
	
}

//利用字典树
class TrieNode {
    // Initialize your data structure here.
    char c ;
    TrieNode[] branch;
	public TrieNode() {
        branch =  new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len = word.length();
        TrieNode curr = root;
        char c; 
        for(int i = 0 ;i < len ; i++){
        	c = word.charAt(i);
        	if(curr.branch[c-97]==null)
        		curr.branch[c-97] = new TrieNode();
        	curr = curr.branch[c-97];
        }
        curr.c = '*';
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length();
        TrieNode curr = root;
        char c;
      
        for(int i = 0 ; i < len ; i++){
        	c = word.charAt(i);
        	if(curr.branch[c-97]==null) return false;        	
        	curr = curr.branch[c-97];
        }
        if(curr.c!='*') return false;
        return true;
    	
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	int len = prefix.length();
        TrieNode curr = root;
        char c;
        for(int i = 0 ; i < len ; i++){
        	c = prefix.charAt(i);
        	if(curr.branch[c-97]==null) 
        		return false;        	
        	curr = curr.branch[c-97];
        }
        return true;
    	
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
