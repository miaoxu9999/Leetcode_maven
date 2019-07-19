package com.mx;

import java.util.*;

/**
 * @ClassName PermutationsII
 * @Description TODO
 * @Author miaoxu
 * @Date 2018/12/30 17:10
 * @Version 1.0
 **/
public class PermutationsII {
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            temp.add(-1);
        }

        Set<List<Integer>> set = new HashSet<>();
        getUniquePermutations(res, nums, 0, flag, -1);

        return new ArrayList<>(set);
    }


    public void getUniquePermutations( List<List<Integer>> res  , int[] nums, int step, boolean[] flag,  int last)
    {
        if (step == nums.length)
        {
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < temp.size(); i++)
//            {
//                list.add(temp.get(i));
//            }
//            set.add(list);
            res.add(temp);
//            temp = new ArrayList<>();
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if ( i>0 &&nums[i-1]==nums[i] && !flag[i-1])
            {
                flag[i] = true;
                temp.set(step, nums[i]);
                getUniquePermutations(res, nums, step + 1, flag,  nums[i]);
//                if (step + 1 == nums.length)
//                {
//                    temp =
//                }
                flag[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] n = {1, 1, 2};
        new PermutationsII().permuteUnique(n);
    }
}
