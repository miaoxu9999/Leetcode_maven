package com.mx;

import edu.princeton.cs.algs4.In;

/**
 * @ClassName BestTimetoBuyandSellStockII
 * 122. Best Time to Buy and Sell Stock II
 * @Description 什么实际卖掉股票最好
 * @Author miaoxu
 * @Date 2019/7/20 10:14
 * @Version 1.0
 **/
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
        {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for (int i = 0; i <= prices.length; i++) {
            int num;
            if ( i == prices.length)
            {
                 num = Integer.MIN_VALUE;
            }
            else
            {
                 num = prices[i];
            }
            if (num < max) // 说明开始下降了
            {
                profit += max - min;
                min = num;
                max = num;
            }
            else
            {
                max = num;
            }
            if (num < min)
            {
                min = num;
            }

        }

        return profit;

    }

    public static void main(String[] args) {
        int[] n = {7,1,5,3,6,4};
//        int[] n = {1,2,3,4,5};
//        int[] n = {7,6,4,3,1};
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(n));

    }
}
