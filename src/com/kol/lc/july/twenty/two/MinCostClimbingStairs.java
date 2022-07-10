package com.kol.lc.july.twenty.two;

/**
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */

public class MinCostClimbingStairs {


    public static void main(String[] args) {
        MinCostClimbingStairs objectUnderTest = new MinCostClimbingStairs();

        int cost[] = new int[] {1,100,1,1,1,100,1,1,100,1};
        System.out.println(" Answer With Dp is "+ objectUnderTest.minCostClimbingStairsUsingDP(cost));
    }




    public int minCostClimbingStair(int cost[]) {

        int memo[] = new int[cost.length];

        memo[0] = cost[0];
        memo[1] = cost[1];

        for(int i = 2; i < cost.length; i++) {
            memo[i] = cost[i] + Math.min(memo[i-1],memo[i-2]);
        }

        return Math.min(memo[memo.length - 1], memo[memo.length - 2]);
    }

    /**
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairsUsingDP(int cost[]) {

        /* if there are exactly two cost we just need to
           return minimum of the two
         */

        if(cost.length == 2) {
            return Math.min(cost[0],cost[1]);
        }

        // Else we will try to optimize using DP

        // The + 1 space is for stroing the cost for the top
        int dp[] = new int[cost.length+1];

        // As we can start from either 0 or 1 the cost will be 0 for any of these
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i < dp.length; i++) {

            dp[i] = Math.min(dp[i-1]+cost[i - 1], dp[i-2] + cost[i - 2]);
        }



    return dp[dp.length - 1];

    }
}
