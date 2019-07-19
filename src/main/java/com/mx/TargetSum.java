package com.mx;

/**
 * @ClassName TargetSum
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/15 14:27
 * @Version 1.0
 **/
public class TargetSum {
    int sum = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return sum;
    }


    public void dfs(int[] nums, int S, int step, int total)
    {
        if (step == nums.length)
        {
            if (total == S)
            {
                sum++;
            }
            return;
        }

        dfs(nums, S, step + 1, total + nums[step]);
        dfs(nums, S, step + 1, total - nums[step]);
    }

    public static void main(String[] args) {
        int[] n = {1, 1, 1, 1, 1};

        new TargetSum().findTargetSumWays(n, 3);
    }

}
