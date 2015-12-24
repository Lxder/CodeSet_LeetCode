package com037.SudokuSolver;

import java.util.HashMap;


public class Solution3 {

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
		for(int i = 0 ; i < 9 ; i++){
			for(int j = 0 ;  j< 9 ; j++){
				System.out.print(board[i][j]+" ");
				if(j%3==2)
					System.out.print("| ");
			}
			if(i%3==2)
				System.out.print("\n-----------------------");
			System.out.println();
		}
	}

	public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        
        HashMap<Character, Integer>[] maprow = new HashMap[9];// 横行
		HashMap<Character, Integer>[] mapcol = new HashMap[9];// 竖行
		HashMap<Character, Integer>[] maprect = new HashMap[9];// 方格
		init(board,maprow,mapcol,maprect); //初始化hashmap
		
        solve(board,maprow,mapcol,maprect);
    }

    public  static boolean solve(char[][] board,HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9 for each cell
                        if(find(c,i, j, maprow,mapcol,maprect)){
                            board[i][j] = c; //Put c for this cell
                            add(c,i,j,maprow,mapcol,maprect);
                            if(solve(board,maprow,mapcol,maprect))
                                return true; //If it's the solution return true
                            else{
                                board[i][j] = '.'; //Otherwise go back
                                delete(c,i,j,maprow,mapcol,maprect);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
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
    
    //向集合中添加元素
  	public static void add(char elem, int i ,int j , HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){		
  			maprow[i].put(elem, 1);
  			mapcol[j].put(elem, 1);
  			maprect[i/3*3+j/3].put(elem, 1);
  	}
  	
  	public static void delete(char elem, int i ,int j , HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){
		maprow[i].remove(elem);
		mapcol[j].remove(elem);
		maprect[i/3*3+j/3].remove(elem);
	}
    
    
    //寻找某个字符是否在集合中
  	public static boolean find(char elem, int i ,int j , HashMap[] maprow,HashMap[] mapcol,HashMap[] maprect ){		
  		Integer irow = (Integer) maprow[i].get(elem);
  		Integer icol = (Integer)mapcol[j].get(elem);
  		Integer irect = (Integer)maprect[i/3*3+j/3].get(elem);
  		if(irow==null&&icol==null&&irect==null){
  			return true;
  		}
  		else return false;
  	}
  	
    public static boolean isValid(char[][] board, int i, int j, char c){
        //Check colum
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;

        //Check row
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;

        //Check 3 x 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }

}
