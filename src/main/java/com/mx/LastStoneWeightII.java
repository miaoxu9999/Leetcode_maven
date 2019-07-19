package com.mx;

/**
 * @ClassName LastStoneWeightII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/22 9:11
 * @Version 1.0
 **/
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        //求和
        // 求f[i][v] 代表的是前i个数，能够达到的最大值
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int[][] f = new int[stones.length + 1][sum / 2 + 1];
        for (int i = 1; i < f.length; i++) {
            for(int j = stones[i - 1]; j < f[0].length; j++)
            {
                f[i][j] = f[i - 1][j];
                if (j >= stones[i - 1] && f[i][j] < f[i - 1][j - stones[i - 1]] + stones[i - 1])
                {
                    f[i][j] = f[i - 1][j - stones[i - 1]] + stones[i - 1];
                }
            }
        }
        return sum - f[stones.length][sum / 2] * 2;
    }

    public static void main(String[] args) {
//        int[] n = {2,7,4,1,8,1};
        int[] n = {1,2};

        System.out.println(new LastStoneWeightII().lastStoneWeightII(n));
    }

}
