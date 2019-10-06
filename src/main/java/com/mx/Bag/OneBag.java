package com.mx.Bag;

/**
 * @ClassName OneBag
 * @Description 01背包问题
 * @Author miaoxu
 * @Date 2019/9/26 20:56
 * @Version 1.0
 **/
public class OneBag {

    public int getZeroOneBag(int[] w, int[]v, int mostWeight){
        int[] dp = new int[mostWeight + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = mostWeight; j >= w[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }



        return dp[mostWeight];
    }

    public int getZeroOneBagTwoArray(int[] w, int[]v, int mostWeight){
        int[][] dp = new int[w.length][mostWeight + 1];
        for (int i = 0; i <= mostWeight; i++) {
            dp[0][i] = i >= w[0]? v[0]: 0;
        }
        for (int i = 1; i < w.length; i++) {

//            for (int j = mostWeight; j >= 0 ; j--) {
            for (int j = 0; j <= mostWeight ; j++) {
                if (j >= w[i])
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }


        boolean[] best = new boolean[w.length];
        for (int i = w.length - 1; i >= 1; i--) {
            if (dp[i][mostWeight] == dp[i - 1][mostWeight]){
                best[i] = false;
            }
            else {
                best[i] = true;
                mostWeight -= w[i];
            }
        }
        best[0] = dp[0][mostWeight] >0? true: false;
        for (int i = 0; i < w.length; i++) {
            if (best[i]){
                System.out.printf("第%d件物品被选中了", i);
                System.out.println();
            }
        }



        return dp[w.length - 1][mostWeight];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {16, 10, 12,};
        System.out.println(new OneBag().getZeroOneBag(w, v, 5));;
        System.out.println(new OneBag().getZeroOneBagTwoArray(w, v, 5));;
    }
}
