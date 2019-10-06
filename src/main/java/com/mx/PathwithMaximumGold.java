package com.mx;

import com.mx.util.RandomArray;
import com.mx.util.RandomTwoArray;

/**
 * @ClassName PathwithMaximumGold
 * @Description 1219. Path with Maximum Gold
 * @Author miaoxu
 * @Date 2019/10/6 11:20
 * @Version 1.0
 **/
public class PathwithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1){
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0){
                    int tem = dfs(grid, i, j, new boolean[grid.length][grid[0].length]);
                    res = Math.max(res, tem);
                }
            }
        }

        return res;

    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >=grid[0].length){
            return 0;
        }
        if (visited[i][j] || grid[i][j] == 0){
            return 0;
        }
        visited[i][j] = true;
        int res = grid[i][j];
        int t = 0;
        int left = dfs(grid, i, j + 1, visited);
        int right = dfs(grid, i, j - 1, visited);
        int down = dfs(grid, i + 1, j, visited);
        int top = dfs(grid, i - 1, j , visited);
        t = Math.max(t, left);
        t = Math.max(t, right);
        t = Math.max(t, down);
        t = Math.max(t, top);
        visited[i][j] = false;
        return res + t;
    }

    public static void main(String[] args) {
        int[][] num = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
//        System.out.println(RandomTwoArray.replace("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]"));
        new PathwithMaximumGold().getMaximumGold(num);
    }
}
