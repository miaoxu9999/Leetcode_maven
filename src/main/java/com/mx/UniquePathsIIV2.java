package com.mx;

import com.mx.util.RandomTwoArray;

/**
 * @ClassName UniquePathsIIV2
 * @Description 迷宫问题，中间有障碍
 * 只能向右或者向下走，
 * 那么走到终点，有多少种可能的路径
 * @Author miaoxu
 * @Date 2019/9/14 14:39
 * @Version 1.0
 **/
public class UniquePathsIIV2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else {
                    dp[j] = (j - 1 >= 0 ?dp[j - 1]: 0 ) + dp[j];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] num = {{0},{1}};
        new UniquePathsIIV2().uniquePathsWithObstacles(num);
        System.out.println(RandomTwoArray.replace("[[0],[1]]"));;
    }
}
