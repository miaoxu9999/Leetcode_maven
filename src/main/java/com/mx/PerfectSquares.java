package com.mx;

/**
 * @ClassName PerfectSquares
 * @Description 279. Perfect Squares
 * 一个数字最少由几个平方数构成
 * @Author miaoxu
 * @Date 2019/7/21 10:51
 * @Version 1.0
 **/
public class PerfectSquares {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            memo[i * i] = 1;
        }

        for (int i = 2; i <= n ; i++) {
            if (memo[i] == 0)
            memo[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++)
            {
                int t = i - j * j;
//                memo[i] = Math.min(memo[i], memo[t] + memo[j]);
                memo[i] = Math.min(memo[i], memo[t] + 1);
            }
        }
        return memo[n];

    }

    private  boolean isCompSqrt(int p) //判断完全平方数的方法
    {
        boolean flag = false;
        double fsqrt = Math.sqrt(p); // 先将数开平方
        int q = (int) fsqrt; // 转换成整数，另q为开平方且转换为整数的结果。

        if (p == Math.pow(q, 2)) // pow(x,y) 就是计算 x 的 y 次幂。把开平方后的整数再平方，看看他和开平方之前的数是不是相等 。
        {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(13));
    }



}
