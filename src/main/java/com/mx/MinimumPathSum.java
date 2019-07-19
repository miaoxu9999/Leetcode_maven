package com.mx;

/**
 * @ClassName MinimumPathSum
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/25 17:26
 * @Version 1.0
 **/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = grid[0][0];
        dp(m - 1, n - 1, grid, dp);
        return dp[m - 1][n - 1];

    }

    public int  dp(int m, int n, int[][] grid, int[][] dp)
    {
        if (m < 0 || n < 0)
        {
            return Integer.MAX_VALUE;
        }
        if (dp[m][n] != -1)
        {
            return dp[m][n];
        }
        dp[m][n] = Math.min(dp(m - 1,n, grid, dp),dp(m ,n - 1, grid, dp)) + grid[m][n];
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] g = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinimumPathSum().minPathSum(g));;
    }
}
