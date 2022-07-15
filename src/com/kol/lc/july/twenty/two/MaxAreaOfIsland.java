package com.kol.lc.july.twenty.two;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) c
 * onnected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0
 *
 */

public class MaxAreaOfIsland {

    public static void main(String[] args) {

        int [][]grid = {
                           {0,0,1,0,0,0,0,1,0,0,0,0,0},
                           {0,0,0,0,0,0,0,1,1,1,0,0,0},
                           {0,1,1,0,1,0,0,0,0,0,0,0,0},
                           {0,1,0,0,1,1,0,0,1,0,1,0,0},
                           {0,1,0,0,1,1,0,0,1,1,1,0,0},
                           {0,0,0,0,0,0,0,0,0,0,1,0,0},
                           {0,0,0,0,0,0,0,1,1,1,0,0,0},
                           {0,0,0,0,0,0,0,1,1,0,0,0,0}
                        };

        MaxAreaOfIsland object = new MaxAreaOfIsland();

        System.out.println("Max Area of Land is "+object.maxAreaOfIsland(grid));

    }

    public int calculateArea(int r, int c, int g[][], boolean seen[][]) {

        if( r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == 0 || seen[r][c]) {
            return 0;
        }
        seen[r][c] = true;
        return 1 +
                calculateArea(r+1,c,g,seen) +
                calculateArea(r-1,c,g,seen) +
                calculateArea(r,c-1,g,seen) +
                calculateArea(r,c+1,g,seen);

    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxAreaSoFar = 0;
        boolean [][] seen = new boolean[grid.length][grid[0].length];
         for(int r = 0; r < grid.length;r++){
             for(int c = 0; c < grid[0].length; c++) {
                 int area =calculateArea(r,c,grid,seen);
                 maxAreaSoFar = Math.max(maxAreaSoFar,area);
             }
         }

        return maxAreaSoFar;

    }
}
