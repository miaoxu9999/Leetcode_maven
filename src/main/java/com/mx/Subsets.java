package com.mx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Subsets
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/1 21:32
 * @Version 1.0
 **/
public class Subsets {
    List<Integer> temp;
    int[] nums1;
    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<Integer>());
//        for(int i = 1; i <= nums.length; i++)
//        {
//            temp = new ArrayList<>(1);
//            boolean[] flag = new boolean[nums.length];
//            dfs_com(i, 0, nums, -1, flag, res);
//        }
//        return res;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfsSubsets(nums, 0, list, result);
        return result;

    }

    public void dfs_com(int n, int step, int[] nums, int last,  boolean[] flag, List<List<Integer>> res)
    {
        if (step == n)
        {
            List<Integer> t = new ArrayList<>();
            for(Integer integer: temp)
            {
                t.add(integer);
            }
            res.add(t);
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (flag[i] == false && i > last)
            {
                flag[i] = true;
                if (temp.size() >= step + 1)
                {
                    temp.set(step, nums[i]);
                }
                else
                {
                    temp.add(nums[i]);
                }
                dfs_com(n, step + 1, nums, i, flag, res);
                flag[i] = false;
            }
        }
    }

//    public void helper()

    private void dfsSubsets(int[] num, int start, ArrayList<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        for (int i = start; i < num.length; i++) {
            list.add(num[i]);
            dfsSubsets(num, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public int splitnum(int n)
    {
        nums1 = new int[n + 1];
        Arrays.fill(nums1,-1);
        nums1[0] = 0;
        nums1[1] = 1;
        return dfssplitnum(n);

    }

    public int dfssplitnum(int n)
    {
        if (nums1[n] != -1)
        {
            return nums1[n];
        }
        int res = dfssplitnum(n - 1) + dfssplitnum(n - 2) ;
        nums1[n] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] n = {1,  2, 3};
//        new Subsets().subsets(n);
        System.out.println(new Subsets().splitnum(4));
    }
}
