package com.kol.lc.aug.tt2;

public enum KthSmallestElementinSortedMatrix {
    ;

    public int kthSmallest(int[][] matrix, int k) {

        int lowEle = matrix[0][0];
        int highEle = matrix[matrix.length - 1][matrix.length - 1];

     

        while(lowEle < highEle) {

            int midEle = lowEle + (highEle - lowEle) / 2;
            
            int eleCount = countElemen(matrix,midEle);

            if(eleCount < k) {
                lowEle = midEle+1;
            }else{
                highEle = midEle;
            }

        }

        return lowEle;
    }

    private int countElemen(int matrix[][], int target) {

        int count = 0 , len = matrix.length, i = len-1, j=0;

        while(i >=0 && j<len){
            if(matrix[i][j] > target){
                i--;
            }
            else
            {
                count = count + i +1;
                j++;
            }
        }
        return count;
    }


}
