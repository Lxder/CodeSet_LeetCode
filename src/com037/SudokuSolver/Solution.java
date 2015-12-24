package com037.SudokuSolver;

import java.util.HashMap;


//��δ���  �д���!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Solution {

	public static void main(String[] args) {
		char[][] board =
				{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				};

		solveSudoku(board);
	}

	public static void solveSudoku(char[][] board) {
		HashMap<Character, Integer>[] maprow = new HashMap[9];// ����
		HashMap<Character, Integer>[] mapcol = new HashMap[9];// ����
		HashMap<Character, Integer>[] maprect = new HashMap[9];// ����
		init(board,maprow,mapcol,maprect); //��ʼ��hashmap
		System.out.println("init����");
		char[][] pre = new char[9][];
		for(int i = 0 ; i < 9 ; i++){
				pre[i]=board[i].clone();
		}
		int[] loc = nextloc(pre,0,0);
		System.out.println(loc[0]+" "+loc[1]);
		System.out.println("�ҵ�һ��Ԫ�ؽ���");
		helper(board,pre,'1',loc[0],loc[1],maprow,mapcol,maprect);
		
		System.out.println(find('7',2,2,maprow,mapcol,maprect));
	}

	public static void helper(char[][] board,char[][] pre, char elem, int row , int col,HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){
		if(row==9) return;
		boolean addflag = add(elem,row,col,maprow,mapcol,maprect);
		System.out.println("row "+row+ " col "+col+" ��ǰ���� "+elem+" addflag "+addflag);
		if(addflag == false){ //����������������
			if(findNext(board,elem,row,col,maprow,mapcol,maprect)=='*'){ //�����ǰλ��û����һ���ɲ�����ַ�����Ҫ���ݵ���һ����
				System.out.println("���ɲ��룡");
				delete(elem,row,col,maprow,mapcol,maprect);
				int[] lloc = lastloc(pre,row,col);					
				char next_elem = findNext(board,elem,lloc[0],lloc[1],maprow,mapcol,maprect);
				helper(board,pre,next_elem,lloc[0],lloc[1],maprow,mapcol,maprect);
			}
			else{
				char elem_next = findNext(board,elem,row,col,maprow,mapcol,maprect);
				helper(board,pre,elem_next,row,col,maprow,mapcol,maprect);
			}
		}else{ //������ӣ���Ԫ����ӽ�ȥ��Ȼ�����һ����λ���в���
			board[row][col] = elem;//��Ԫ����ӽ�ȥ��Ȼ���������
			
			int[] loc = nextloc(pre,row,col);
			System.out.println("��ǰλ�� "+row+" "+col+" ��һ��λ�� "+loc[0]+" "+loc[1]);
			helper(board,pre,elem,loc[0],loc[1],maprow,mapcol,maprect);
		}
	}
	
	//Ѱ����һ���ɲ����λ��
	public static int[] nextloc(char[][] board,int row, int col){		
		col++;
		while(row<9){
			if(col==9){
				col = 0;
				row++;
			}
			while(col<9){
				if(board[row][col]!='.'){
					col++;
				}else{
					return new int[]{row,col};
				}
			}
		}
		return null;
		
	}
	//Ѱ��ǰһ������λ��
	public static int[] lastloc(char[][] pre, int row , int col){
		col --;
		while(row>=0){
			if(col==-1){
				col = 8  ;
				row-- ;				
			}			
			while(col>=0){
				System.out.println("��ǰ����:"+row+" " + col+" "+pre[row][col]);
				if(pre[row][col]!='.')
					col--;
				else {
					return new int[]{row,col};
				}
			}
		}
		return null;
	}
	
	//Ѱ�ҵ�ǰλ�õ�ǰ�ַ���һ�����е��ַ�
	public static char findNext(char[][] board,char elem,int row, int col,HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){
		for(char c = '1' ; c<='9' ; c++){
			System.out.print(c);
			if(find(elem,row,col,maprow,mapcol,maprect) == true)
				return c;
		}
		System.out.println("\n");
		return '*';		
	}
	
	//Ѱ��ĳ���ַ��Ƿ��ڼ�����
	public static boolean find(char elem, int i ,int j , HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){		
		Integer irow = (Integer) maprow[i].get(elem);
		Integer icol = (Integer)mapcol[j].get(elem);
		Integer irect = (Integer)maprect[i/3*3+j/3].get(elem);
		if(irow==null&&icol==null&&irect==null){
			return true;
		}
		else return false;
	}
	
	//�����������Ԫ��
	public static boolean add(char elem, int i ,int j , HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){		
		Integer irow = (Integer) maprow[i].get(elem);
		Integer icol = (Integer)mapcol[j].get(elem);
		Integer irect = (Integer)maprect[i/3*3+j/3].get(elem);
		if(irow==null&&icol==null&&irect==null){
			maprow[i].put(elem, 1);
			mapcol[j].put(elem, 1);
			maprect[i/3*3+j/3].put(elem, 1);
			return true;
		}
		else return false;
	}
	
	//ɾ�������е�Ԫ��
	public static void delete(char elem, int i ,int j , HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){
		maprow[i].remove(elem);
		mapcol[j].remove(elem);
		maprect[i/3*3+j/3].remove(elem);
	}

	public static void init(char[][] board,HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ) {		
		for (int i = 0; i < 9; i++) {
			maprow[i] = new HashMap<Character, Integer>();
			mapcol[i] = new HashMap<Character, Integer>();
			maprect[i] = new HashMap<Character, Integer>();
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
					maprow[i].put(board[i][j], 1);
					mapcol[j].put(board[i][j], 1);
					maprect[i / 3 * 3 + j / 3].put(board[i][j], 1);
			}
		}
	}

}
