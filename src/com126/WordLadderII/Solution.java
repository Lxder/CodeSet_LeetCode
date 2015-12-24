package com126.WordLadderII;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//最好的方法在Solution2内
public class Solution {

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
		
		
//		String beginWord = "cet" ;
//		String endWord = "ism";
//		Set<String> set = new HashSet<String>();		
//		String[] mset = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
//		for(int i = 0 ; i <mset.length ; i++){
//			set.add(mset[i]);	
//		}

		List<List<String>> solu = findLadders(beginWord,endWord,set);
		System.out.println(solu);
	}

	
	//大数据超时（每一个都使用了队列）
	public static List<List<String>> findLadders(String beginWord, String endWord,	Set<String> wordList) {
		List<List<String>> solu = new LinkedList<List<String>>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		queue.add(null);
		
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		
		Queue<Set<String>> qvisit = new LinkedList<Set<String>>();
		qvisit.add(visited);
		qvisit.add(null);
		
		
		Queue<List<String>> qsolu =new LinkedList<List<String>>(); 
		List<String> csolu = new  LinkedList<String>();
		csolu.add(beginWord);
		qsolu.add(csolu);
		qsolu.add(null);
		
		
		boolean flag = false;
		
		while(!queue.isEmpty()){
			String str = queue.poll();
			Set<String> cvisited = qvisit.poll();
			List<String> clist = qsolu.poll();
			//System.out.println(clist);
			if(str!=null){
				for(int i = 0 ; i < str.length() ; i++){
					char[] temp = str.toCharArray();
					for(char c = 'a' ; c <='z' ; c++){
						temp[i] = c;
						String curr = new String(temp);
						List<String> currlist = new LinkedList<String>(clist); 
						if(curr.equals(endWord)) {
							flag = true;	
							System.out.println("立了一个flag");
							clist.add(curr);
							solu.add(clist);
							continue;
						}
								
						//System.out.println("VISIT"+cvisited);
						if(wordList.contains(curr)&&!cvisited.contains(curr)){
							//qvisit.poll();							
							currlist.add(curr);
							qsolu.add(currlist);

							queue.add(curr);
							
							Set<String> curvisit = new HashSet<String>(cvisited);							
							curvisit.add(curr);							
							qvisit.add(curvisit);
							
							System.out.println("当前q"+qsolu);
						}
					}
				}
			}else{
				if(flag == true)
					return solu;
				if(!queue.isEmpty()){
					queue.add(null);
					qsolu.add(null);			
					qvisit.add(null);
				}
			}
		}
		return solu;

	}
}
