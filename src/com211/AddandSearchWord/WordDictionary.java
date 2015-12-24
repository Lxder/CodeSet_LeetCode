package com211.AddandSearchWord;

public class WordDictionary {	
	
	public static void main(String args[]){
		WordDictionary w = new WordDictionary();
//		w.addWord("bad");
//		w.addWord("dad");
//		w.addWord("mad");
//		System.out.println(w.search(".d"));
//		
		w.addWord("a");
		w.addWord("ab");

		System.out.println(w.search(".b"));
//		System.out.println(w.search("a"));
//		System.out.println(w.search("aa"));
//		System.out.println(w.search("a"));
//		System.out.println(w.search(".a"));
//		System.out.println(w.search("a."));

		
	}
	
	private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return helper(word,root);
    }
    
    
    public boolean helper(String word, TrieNode root){
    	if(root==null) return false;    	
    	int len = word.length();    	
    	TrieNode curr = root;    	
    	if(len==0 && curr.c=='*') {
    		return true;
    	}

    	char c ; 
    	int i;
    	for( i = 0 ; i < len ; i++){
    		c = word.charAt(i);
    		if(c=='.'){//为通配符的情况
    			for(int j = 0 ; j < 26 ; j++){    				
    				if(helper(word.substring(i+1),curr.branch[j])==true)
    					return true;
    			}
    			break;
    		}else if(curr.branch[c-97]==null) {
        		return false;        	
    		}else{
        		curr = curr.branch[c-97];
        	}
        }
    	
        if(curr.c!='*') return false;
        if(i!=len&&curr.c=='*') return false;
        return true;
    	
    }
}

//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");

class TrieNode {
    // Initialize your data structure here.
    char c ;
    TrieNode[] branch;
	public TrieNode() {
        branch =  new TrieNode[26];
    }
}
