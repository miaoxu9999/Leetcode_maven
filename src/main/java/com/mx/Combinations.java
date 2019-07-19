package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Combinations
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/12 14:12
 * @Version 1.0
 **/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[n +1];
        dfs_com(n, k, 0, res, new ArrayList<Integer>(), flag, 0);
        return res;
    }

    public void dfs_com(int n, int k, int step, List<List<Integer>> res, List<Integer> temp, boolean[] flag, int last)
    {
        if (step == k)
        {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = last + 1; i <= n ; i++)
        {
            if (!flag[i])
            {
                temp.add(i);
                flag[i] = true;
                dfs_com(n, k, step + 1, res, temp, flag, i);
                flag[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }
}
