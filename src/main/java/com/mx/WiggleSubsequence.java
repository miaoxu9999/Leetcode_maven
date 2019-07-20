package com.mx;

import java.util.Arrays;

/**
 * @ClassName WiggleSubsequence
 * 376. Wiggle Subsequence
 * @Description 寻找数组中要么增加，要么减少的数组
 * @Author miaoxu
 * @Date 2019/7/20 15:11
 * @Version 1.0
 **/
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 3)
        {
            return nums.length;
        }
        // 增减型序列的最大记录数组，increaseDown[i]表示，以i为结尾的数组，增减型子序列的最大长度
        int[] increaseDown = new int[nums.length];
        // 减增型序列的最大记录数组，downIncrease[i]表示，以i为结尾的数组，减增型子序列的最大长度
        int[] downIncrease = new int[nums.length];
        Arrays.fill(increaseDown, 1);
        Arrays.fill(downIncrease, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    if (increaseDown[j] % 2 == 0)
                    {
                        increaseDown[i] = increaseDown[j] + 1;
                    }
                    if (downIncrease[j] % 2 != 0)
                    {
                        downIncrease[i] = downIncrease[j] + 1;
                    }
                }
                if (nums[i] < nums[j])
                {
                    if (increaseDown[j] % 2 != 0)
                    {
                        increaseDown[i] = increaseDown[j] + 1;
                    }
                    if (downIncrease[j] % 2 == 0)
                    {
                        downIncrease[i] =  downIncrease[j] + 1;
                    }
                }
                res = Math.max(res, increaseDown[i]);
                res = Math.max(res, downIncrease[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] n = {1,17,5,10,13,15,10,5,16,8};
//        int[] n = {1,7,4,9,2,5};
//        int[] n = {1,2,3,4,5,6,7,8,9};
        int[] n = {0,0};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(n));
    }
}
