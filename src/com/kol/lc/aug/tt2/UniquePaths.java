package com.kol.lc.aug.tt2;

/*

There is a robot on an m x n grid. The robot is initially located at the top-left
corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corne
r (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that
the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println("For M =3 and N = 7, Number of unique paths are "+new UniquePaths().uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        for(int i = 0; i < dp.length;i++) {
            for(int j = 0; j < dp[i].length;j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }


}
