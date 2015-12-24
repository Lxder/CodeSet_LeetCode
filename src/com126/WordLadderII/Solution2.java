package com126.WordLadderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String beginWord = "hat" ;
		String endWord = "cog";
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		set.add("hac");
//		String beginWord = "cet" ;
//		String endWord = "ism";
//		Set<String> set = new HashSet<String>();
//		String[] mset = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
//		for(int i = 0 ; i <mset.length ; i++){
//			set.add(mset[i]);	
//		}

		Solution2 s = new Solution2();
		List<List<String>> solu = s.findLadders(beginWord,endWord,set);
		System.out.println(solu);
	}
	

	//记录每个单词所在的层数  
    HashMap<String,Integer> path = new HashMap<String,Integer>();  
    //bfs生成path  
    public void bfs(String start, String end, Set<String> dict) {  
        Queue<String> queue = new LinkedList<String>();  
        queue.add(start);  
        path.put(start,0);  
        String current;  
        while(!queue.isEmpty()) {  
            current = (String)queue.poll();  
            if(current==end) {  
                continue;  
            }  
            for(int i=0;i<current.length();i++) {  
                char[] strCharArr = current.toCharArray();  
                for(char ch='a';ch<='z';ch++) {  
                    if(strCharArr[i]==ch) {  
                        continue;  
                    }  
                    strCharArr[i] = ch;  
                    String newWord = new String(strCharArr);  
                    if(newWord.equals(end)==true||dict.contains(newWord)) {  
                        //每个单词在path中只能出现一次，也就是每个单词只能出现在一层中，
                    	//这样就很巧妙的解决了环的问题。  
                    	if(path.get(newWord)==null) {  
                            int depth = (int)path.get(current);  
                            path.put(newWord,depth + 1);  
                            queue.add(newWord);  
                        }  
                    }  
                }  
            }  
        }  
    }  
    //从目标单词往回找开始单词，记录所有路径  
    public void dfs(String end, String start, Set<String> dict, 
    		List<String> pathArray,List<List<String>> result) {  
        //找到了，需要reverse加入的所有单词  
    	if(end.equals(start)==true) {  
            pathArray.add(start);  
            Collections.reverse(pathArray);  
            result.add(pathArray);  
            return;  
        }  
        if(path.get(end)==null) {  
            return;  
        }  
        pathArray.add(end);  
        int nextDepth = (int)path.get(end) - 1;  
        for(int i=0;i<end.length();i++) {  
            char[] strCharArr = end.toCharArray();  
            for(char ch='a';ch<='z';ch++) {  
                if(strCharArr[i]==ch) {  
                    continue;  
                }  
                strCharArr[i] = ch;  
                String newWord = new String(strCharArr);  
                //只相差一个字母同时这个单词所在的层数也是当前单词的上一层  
                if(path.get(newWord)!=null&&(path.get(newWord)==nextDepth)) {  
                    ArrayList<String> newPathArray = new ArrayList<String>(pathArray);  
                    dfs(newWord,start,dict,newPathArray,result);  
                }  
            }  
        }  
    }  

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {  
        List<List<String>> result = new ArrayList<List<String>>();  
        List<String> path = new ArrayList<String>();  
        if(beginWord==null||endWord==null||beginWord.length()!=endWord.length()) {  
            return result;  
        }  
        bfs(beginWord, endWord, wordList);  
        System.out.println(this.path);
        dfs(endWord,beginWord, wordList, path, result);  
        return result;  
    }  
}
