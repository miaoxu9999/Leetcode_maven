package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubsetsII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/12 15:05
 * @Version 1.0
 **/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[nums.length +1];
        dfs_subsets(res, nums, new ArrayList<Integer>(), -1, 0);

        return res;
    }

    public void dfs_subsets(List<List<Integer>> res, int[] nums, List<Integer> tem, int step, int start)
    {
        int flag = 0;
        res.add(new ArrayList<Integer>(tem));
        if (tem.size() == nums.length)
        {
            return;
        }
        for (int i = start; i < nums.length; i++)
        {
//            if (step == - 1 && i != 0)
//            {
//                if (nums[i] > nums[i - 1])
//                {
//                    continue;
//                }
//            }
            if( i > 0 && flag == 1 && nums[i] == nums[i-1])
                continue;
            tem.add(nums[i]);
            flag = 1;
            dfs_subsets(res, nums, tem, step + 1, i + 1);
            tem.remove(tem.size() - 1);

        }
    }


    public static void main(String[] args) {
        int[] n = {1, 2, 2};
        new SubsetsII().subsetsWithDup(n);
    }
}
