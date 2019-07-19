package com.mx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSumII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/14 15:09
 * @Version 1.0
 **/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs_com(candidates, target, 0, res, new ArrayList<Integer>(), 0);
        return res;
    }

    public void dfs_com(int[] cand, int n, int temsum, List<List<Integer>> res, List<Integer> list, int step)
    {

        if (temsum == n)
        {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (step == cand.length)
        {
            return;
        }
        int flag = 0;
        for (int i = step; i < cand.length; i++)
        {
            if (temsum + cand[i] > n)
            {
                break;
            }
            if (i > 0 && flag == 1 && cand[i] == cand[i- 1])
            {
                continue;
            }
            else
            {
                if (step == 0 || (step > 0 && cand[i] >= list.get(list.size() - 1)))
                {
                    list.add(cand[i]);
                    flag = 1;
                    dfs_com(cand, n, temsum + cand[i], res, list, i + 1);
                    list.remove(list.size() - 1);
                }

            }

        }
    }


    public static void main(String[] args) {
//        int[] c = {10,1,2,7,6,1,5};
//        int t = 8;

//        int[] c = {2,5,2,1,2};
//        int t = 5;

//        int[] c = {1,2};
//        int t = 4;

        int[] c = {1,2,2,5};
        int t = 5;
        new CombinationSumII().combinationSum2(c, t);
    }
}
