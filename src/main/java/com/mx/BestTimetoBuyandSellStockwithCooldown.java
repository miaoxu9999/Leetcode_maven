package com.mx;

/**
 * @ClassName BestTimetoBuyandSellStockwithCooldown
 * @Description 309 动态规划解决
 * TODO 空间上还可以优化一下
 * @Author miaoxu
 * @Date 2019/7/22 22:48
 * @Version 1.0
 **/
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
        {
            return 0;
        }
        //
        int[] memo = new int[prices.length];
        // 当前元素的最大值
        int[] preMax = new int[prices.length];
        memo[1] = Math.max(0, prices[1] - prices[0]);
        preMax[1] = memo[1];
        if (prices.length == 2)
        {
            return memo[1];
        }
        memo[2] = Math.max(prices[2] - prices[0], prices[2] - prices[1]);
        preMax[2] = memo[2];
        int res=  0;
        for (int i = 1; i < prices.length; i++) {
            memo[i] = Math.max( prices[i] - prices[0], memo[i]);
            memo[i] = Math.max( prices[i] - prices[1], memo[i]);
            res = Math.max(res, memo[i]);
            for (int j = 2; j < i; j++)
            {
                //第i天卖出，第j天买进， 第j - 2天之前的最小值，j - 3一直到0
               memo[i] =Math.max(preMax[j - 2] + prices[i] - prices[j], memo[i]);
               res = Math.max(res, memo[i]);
            }
            preMax[i] = res;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,0,2};
//        int[] n = {1,2,4};
//        int[] n = {6,1,6,4,3,0,2};
        System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(n));
    }
}
