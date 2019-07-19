package com.mx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Triangle
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/1 21:10
 * @Version 1.0
 **/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = Integer.MAX_VALUE;
        int m = triangle.size() + 1;
        int n = triangle.get(triangle.size() - 1).size() + 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[1][1] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++)
        {
            getRees(triangle, dp, m - 1, i);
        }

        for (int i = 1; i < n; i++)
        {
            sum = Math.min(sum, dp[n - 1][i]);
        }
        return sum;
    }

    public int getRees(List<List<Integer>> triangle, int[][] dp, int m, int n)
    {
        if (m < 1 || n < 1 || m <n)
        {
            return Integer.MAX_VALUE;
        }
        if (dp[m][n] != Integer.MAX_VALUE)
        {
            return dp[m][n];
        }
        dp[m][n] = Math.min(getRees(triangle, dp, m - 1, n), getRees(triangle, dp, m  - 1, n - 1)) + triangle.get(m - 1).get(n - 1);
        return dp[m][n];
    }

    public static void main(String[] args) {
//        List<List<Integer>> tr = Arrays.asList({
//                {2},
//                {3,4},
//                {6,5,7},
//                {4,1,8,3}
//        })
        int[][]s = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>> tr = new ArrayList<>();
        for (int i = 0; i < s.length; i++)
        {
            List<Integer> t = new ArrayList<>();
            for(int j = 0; j < s[i].length; j++)
            {
                t.add(s[i][j]);
            }
            tr.add(t);
        }

        new Triangle().minimumTotal(tr);
    }

}
