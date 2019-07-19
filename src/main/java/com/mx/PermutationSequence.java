package com.mx;

/**
 * @ClassName PermutationSequence
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/13 19:40
 * @Version 1.0
 **/
public class PermutationSequence {
    int kth;
    String res = "";
    int count = 0;
    public String getPermutation(int n, int k) {
        kth = k;
        boolean[] flag = new boolean[n +1];
        dfs_per(n, 0, "", flag);
        return res;
    }

    public void dfs_per(int n, int step, String tem, boolean[] flag)
    {
        if (step == n)
        {
            count++;
            if (count == kth)
            {
                res = tem;
            }
            return;
        }
        for (int i = 1; i <= n; i++)
        {
            if (flag[i] == false)
            {
                flag[i] = true;
                dfs_per(n, step + 1, tem + i, flag);
                flag[i] = false;
            }
            if (res.length() > 1)
            {
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println( new PermutationSequence().getPermutation(4,9));
    }
}
