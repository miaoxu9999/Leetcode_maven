package com.mx;

import java.util.Arrays;

/**
 * @ClassName 300.LongestIncreasingSubsequence
 * @Description 最长上升子序列问题
 * 动态规划
 * @Author miaoxu
 * @Date 2019/7/19 22:35
 * @Version 1.0
 **/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1)
        {
            return 0;
        }
        //最小值为1
        int res = 1;
        int l = nums.length;
        //m[i] 代表以i结尾的上升的最长子序列个数
        int[] m = new int[l];
        Arrays.fill(m, 1);
        //
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    m[i] = Math.max(m[j] + 1, m[i]);
                    res = Math.max(m[i], res);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] m = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(m));
    }
}
