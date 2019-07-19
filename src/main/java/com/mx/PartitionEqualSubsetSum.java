package com.mx;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * @ClassName PartitionEqualSubsetSum
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/3 15:54
 * @Version 1.0
 **/
public class PartitionEqualSubsetSum {
    boolean flag = false;
    public boolean canPartition(int[] nums) {
        //计算总和，
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        //递归判断当前的i数字放进去之后，两边的数字是否一致
//        isSumEqual(nums, 0, sum, 0);
        if (sum %2 == 1)
        {
            return false;
        }
        boolean[]d = new boolean[sum + 1];
        d[0] = true;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = sum / 2; j >= nums[i]; j--)
            {
                if (j >= nums[i])
                {
                    d[j] = d[j] || d[j - nums[i - 1]];

                }
            }
        }
        return d[sum / 2];
    }

    public void isSumEqual(int[] nums, int leftsum, int sum, int i)
    {
        if (i >= nums.length)
        {
            return;
        }
        if (leftsum * 2== sum)
        {
            flag = true;
            return;
        }
        if (flag)
        {
            return;
        }
        //放置第i个物品
        isSumEqual(nums, leftsum + nums[i], sum, i + 1);

        //不放第i个物品
        isSumEqual(nums, leftsum, sum, i + 1);

    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
        {
            return 0;
        }
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE - 100);
        for (int i = 0; i < coins.length; i++)
        {
            if (coins[i] <= amount)
            {
                f[coins[i]] = 1;
            }
        }
        for (int i = 0; i < coins.length; i++)
        {
            for (int j = coins[i]; j <= amount; j++)
            {
                f[j] = Math.min(f[j], f[j - coins[i]] + 1);
            }
        }

        return f[amount]>= Integer.MAX_VALUE - 1000? -1: f[amount];

    }




    public static void main(String[] args) {
//        int[] n = { 1, 5, 11, 5};
//        int[] n = { 1, 2, 3, 4};
//        int[] n = { 1, 2, 5};
        int[] n = { 2};
//        System.out.println(new PartitionEqualSubsetSum().canPartition(n));
        System.out.println(new PartitionEqualSubsetSum().coinChange(n, 3));
    }
}
