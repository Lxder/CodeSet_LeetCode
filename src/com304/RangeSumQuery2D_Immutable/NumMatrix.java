package com304.RangeSumQuery2D_Immutable;
public class NumMatrix {
	
	public static void main(String args[]){
		int[][] matrix = {
				  {3, 0, 1, 4, 2},
				  {5, 6, 3, 2, 1},
				  {1, 2, 0, 1, 5},
				  {4, 1, 0, 1, 7},
				  {1, 0, 3, 0, 5}
		};
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(2,1,4,3));
		System.out.println(numMatrix.sumRegion(1,1,2,2));
	}

	int[][] sum ;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row==0) return;
        int col = matrix[0].length;
        sum = new int[row+1][col+1];
        for(int i= 0 ; i < row ; i++){
        	for(int j = 0  ; j < col ; j++){
        		sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]+matrix[i][j]-sum[i][j];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1]-sum[row1][col2+1]-sum[row2+1][col1]+sum[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);