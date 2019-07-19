package com.mx;

/**
 * @ClassName MaximumSubarray
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/2 16:19
 * @Version 1.0
 **/
public class MaximumSubarray {
    int[][]s;
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[nums.length][nums.length];
        s = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                s[i][j] = Integer.MAX_VALUE;
            }
            dp[i][i] = nums[i];
            s[i][i] = nums[i];
        }
        int res = dp(nums, dp, 0, n - 1);
        return res;
    }

    //i和j都是闭区间
    public int  dp(int[] nums, int[][] dp, int i, int j)
    {
        if (i < 0 || j < 0 || i >= dp.length || j > dp.length)
        {
            return Integer.MAX_VALUE;
        }
        if (i == j)
        {
            return nums[i];
        }
        if (dp[i][j] != Integer.MAX_VALUE)
        {
            return dp[i][j];
        }
        dp[i][j] = Math.max(dp(nums, dp, i, j - 1), dp(nums, dp, i + 1, j));
        //计算从num[i] 到j的和
        if (s[i][j] == Integer.MAX_VALUE)
        {
//            int sum = 0;
//            for (int k = i; k <= j; k++)
//            {
//                sum += nums[k];
//            }
//            s[i][j] = sum;
            s[i][j] = getSum(nums, i, j);
        }

        // 与dp[i][j]比较
        dp[i][j] = Math.max(dp[i][j], s[i][j]);
        return dp[i][j];
    }

    public int getSum(int[] nums, int i, int j)
    {

        if (i < 0 || j < 0 )
        {
            return 0;
        }
        if (i == j)
        {
            return nums[i];
        }
        if (s[i][j] != Integer.MAX_VALUE)
        {
            return s[i][j];
        }
        s[i][j] = getSum(nums, i , j - 1) + nums[j];
        return s[i][j];
    }

    public static void main(String[] args) {
//        int[] n = {-2,1,-3,4,-1,2,1,-5,4};
        int[] n = {-57,9,-72,-72,-62,45,-97,24,-39,35,-82,-4,


                91,-14,-81,-7,60,48,8,-57,-25,92,-25,77,97,-85,25,-45,-2,-71,2,78,98,56,-5,-30,-91
                ,73,-85,10,80,93,76,48,-44,72,-58,-83,20,49,-64,94,18,11,48,16,2,-26,47,99,-21,-50,55,-23,-94,-73,46,-85};
        System.out.println(new MaximumSubarray().maxSubArray(n));
    }
}
