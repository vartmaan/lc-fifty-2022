package com.kol.lc.july.twenty.two;

/**
 * Search in 2D Matrix which is sorted across rows and columns
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchA2DMatrixII {

    public static void main(String[] args) {

        new SearchA2DMatrixII().testSearchMatrix();

    }

    public void testSearchMatrix() {
        
       int test[][] =  {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
       int target = 5;

       System.out.println(" Is 5 exists in Matrix "+searchMatrix(test,target));

    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int currRow = 0;
        int currCol = matrix[0].length - 1;

        // start from the last cell
        while(currRow < matrix.length && currCol >= 0) {

            int currCellVal = matrix[currRow][currCol];

            if( currCellVal == target) return true;
            if(currCellVal < target) currRow++;
            else currCol--;
        }

        return false;
    }
}
