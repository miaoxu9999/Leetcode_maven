package com.mx.Bag;

/**
 * @ClassName OneBagV2
 * @Description 01 背包问题
 * @Author miaoxu
 * @Date 2019/10/6 20:14
 * @Version 1.0
 **/
public class OneBagV2 {
    public int getMostValue(int[] w, int[] v, int maxWeight){
        int[] dp = new int[maxWeight + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = maxWeight; j >= w[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[maxWeight];
    }

    public int getZeroOneBagTwoArray(int[] w, int[]v, int maxWeight){
        int[][] dp = new int[w.length][maxWeight + 1];
        for (int i = 0; i <= maxWeight; i++) {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = maxWeight; j >= 0 ; j--) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i] && dp[i - 1][j - w[i]] + v[i] > dp[i][j]){
                    dp[i][j] = dp[i - 1][j - w[i]] + v[i];
                }
            }
        }
        boolean[] best = new boolean[w.length];
        int i = w.length - 1;
        int j = maxWeight;
        while (i > 0){
            if (dp[i][j] == dp[i - 1][j]){
                best[i] = false;
            }else {
                best[i] = true;
                j = j - w[i];
            }
            i--;
        }
        best[0] = dp[0][j] > 0 ;
        for (int k = 0; k < best.length; k++) {
            if (best[k]){
                System.out.printf("被选中的物品有%s  ", k);
            }
        }

        return dp[w.length - 1][maxWeight];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {16, 10, 12,};
        System.out.println(new OneBagV2().getMostValue(w, v, 5));;
        System.out.println(new OneBagV2().getZeroOneBagTwoArray(w, v, 5));;
    }
}
