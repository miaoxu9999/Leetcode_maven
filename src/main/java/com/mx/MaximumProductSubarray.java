package com.mx;

/**
 * @ClassName MaximumProductSubarray
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/7/19 23:22
 * @Version 1.0
 **/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int res = nums[0];
//        int[][] m = new int[nums.length][nums.length];
        int[] m = new int[nums.length];
        //m[i] 代表的是从i到当前位置的乘积
        for (int i = 0; i < nums.length; i++) {
//            m[i][i] = nums[i];
            m[i]= nums[i];
            res = Math.max(m[i], res);
        }
        for (int i = 1; i < nums.length; i++)
        {

            for(int j = 0; j < i; j++)
            {
                m[j]= m[j] * nums[i];
                res = Math.max(m[j], res);
            }






//            for(int j = 0; j <= i; j++)
//            {
//                m[i][j] = Math.max( m[i - 1][j] * nums[i],  m[i - 1][j]);
//
//            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] n = {2,3,-2,4};
//        int[] n = {-2,0,-1};
        System.out.println(new MaximumProductSubarray().maxProduct(n));
    }
}
