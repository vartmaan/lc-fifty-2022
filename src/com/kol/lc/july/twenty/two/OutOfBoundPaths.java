package com.kol.lc.july.twenty.two;

import java.util.Arrays;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid
 * crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths
 * to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 */

public class OutOfBoundPaths {



    int M = 1000000007;

    public static void main(String[] args) {
        OutOfBoundPaths outOfBoundPaths = new OutOfBoundPaths();

        System.out.println("result is "+ outOfBoundPaths.findPaths(1,3,3,0,1));
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int memo[][][] = new int[m][n][maxMove+1];

        for(int level1[][] : memo) {
            for(int level2[] : level1) {
                Arrays.fill(level2,-1);
            }
        }


        return findPaths(m,  n, maxMove,  startRow,  startColumn,memo) ;
    }


    public int findPaths(int m, int n, int N, int startRow, int startColumn, int memo[][][]) {

           if(startRow < 0 || startColumn < 0 || startRow == m || startColumn == n) {
               return 1;
           }

           if( N == 0) return 0;

           if(memo[startRow][startColumn][N] != -1) return memo[startRow][startColumn][N];

        memo[startRow][startColumn][N] = ((findPaths(m,n,N-1,startRow - 1, startColumn,memo) +
                                           findPaths(m,n,N-1,startRow+1,startColumn,memo)) % M +
                (findPaths(m,n,N-1,startRow,startColumn+1,memo) +
                 findPaths(m,n,N-1,startRow,startColumn-1,memo)) % M ) % M;

        return memo[startRow][startColumn][N];






        }
}
