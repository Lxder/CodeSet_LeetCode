package com208.ImplementTriePrefixTree;

class TrieNode {
    // Initialize your data structure here.
    char c ;
    TrieNode[] branch;
	public TrieNode() {
        branch =  new TrieNode[26];
    }
}

public class Trie {
	public static void main(String args[]){
		Trie trie = new Trie();		
		
		trie.insert("app");
		trie.insert("apple");
		
		System.out.println(trie.search("appl"));
		System.out.println(trie.startsWith("appl"));
		
		
	}
	
	
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