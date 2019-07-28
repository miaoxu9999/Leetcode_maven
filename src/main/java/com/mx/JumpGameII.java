package com.mx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName JumpGameII
 * @Description JumpGameII,好像最简单是用贪心算法
 * @Author miaoxu
 * @Date 2019/7/27 21:53
 * @Version 1.0
 **/
public class JumpGameII {
    class Pair
    {
        int index;
        int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int jump(int[] nums) {
        if (nums.length < 2)
        {
            return 0;
        }
        if (nums.length < 3)
        {
            return 1;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, nums.length);
        memo[nums.length - 2] = 1;
        int count = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.index - o1.index;
            }
        });
        for (int i = nums.length - 2; i >= 0 ; i--) {
            count++;
            if (i + nums[i] >= nums.length - 1)
            {
                memo[i] = 1;
                continue;
            }
            int min;
            if ((i + 1) == (i + nums[i] + 1))
            {
                min = Arrays.stream(memo, i + 1, i  + 2).min().getAsInt();
            }
            else
            {
                min = Arrays.stream(memo, i + 1, i + nums[i] + 1).min().getAsInt();

            }
            memo[i] =  Math.min(min+ 1, memo[i]);
//            for (int j = 1; j <= nums[i] && j < queue.size(); j++) {
//
////                memo[i] = Math.min(memo[i + j] + 1, memo[i]);
//
//                if (memo[i + j] == 1 )
//                {
//                    memo[i] = Math.min(memo[i + j] + 1, memo[i]);
//                    break;
//                }
//                memo[i] = Math.min(memo[i + j] + 1, memo[i]);
//
//            }
            queue.add(new Pair(i, memo[i]));
            if (count > 20)
            {
                queue.poll();
            }
        }
        return memo[0];

    }

    public static void main(String[] args) {
        int[] m = {2,3,1,1,4};
//        int[] m = {1,1,1,1};
//        int[] m = {1,1,1,1, 1};
//        int[] m = {2,3,0,1,4};
//        int[] m = {6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3};
//        int min = Arrays.stream(m, 1, 4).max().getAsInt();
//        System.out.println(min);
        System.out.println(new JumpGameII().jump(m));
    }

}
