package com.mx;

/**
 * @ClassName JumpGame
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/17 21:02
 * @Version 1.0
 **/
public class JumpGame {
    boolean flag = false;
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length;i ++)
        {
            if (i < max)
            {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }

        return true;
    }


    public void dfs(int[] nums,int step)
    {
        if (step == nums.length - 1)
        {
            flag = true;
            return;
        }
        int maxsteps = 0;
        if (step < nums.length)
        {
            //当前所在位置最多能跳的步数
             maxsteps = nums[step];
        }
        else
        {
            return;
        }
//        for (int i = 1; i <= maxsteps; i++)
        for (int i = maxsteps; i >= 1; i--)
        {
            dfs(nums, step + i);
            if (flag)
            {
                return;
            }
        }
    }

        public static void main(String[] args) {
//        int [] n = {2,3,1,1,4};
        int [] n = {3,2,1,0,4};
        System.out.println(new JumpGame().canJump(n));;
    }
}
