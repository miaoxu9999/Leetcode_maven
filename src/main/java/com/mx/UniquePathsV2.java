package com.mx;

/**
 * @ClassName UniquePathsV2
 * @Description 迷宫问题，只能向右或者向下走，
 * 那么走到终点，有多少种可能的路径
 * @Author miaoxu
 * @Date 2019/9/14 14:20
 * @Version 1.0
 **/
public class UniquePathsV2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //i, j 等于 i- j
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}
