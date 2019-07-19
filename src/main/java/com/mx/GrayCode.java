package com.mx;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GrayCode
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/1 19:54
 * @Version 1.0
 **/
public class GrayCode {
    String pre = "";
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        if (n == 0)
        {
            res.add(0);
            return res;
        }
        String t = "";
        for (int i = 0; i < n - 1; i++)
        {
            pre += '0';
        }
        pre += '1';
        dfs(n,  "", 0, res);
        return res;
    }

    public boolean dfs(int n, String cur, int step,  List<Integer> res)
    {
        if (step == n)
        {
            if (isConflict(cur, pre))
            {
                res.add(Integer.parseInt(cur, 2));
                pre = cur;
                cur = "";
                return true;
            }
            else
            {
                return false;
            }
        }
        // 每一步决定，是加上0还是1
        boolean left = dfs(n, cur + '0', step + 1, res);
        boolean right = true;
        right = dfs(n, cur + '1', step + 1, res);
        if (right && !left)
        {
            left = dfs(n, cur + '0', step + 1, res);
        }

        return right;
    }

    boolean isConflict(String cur, String pre)
    {
        int count = 0;
        for (int i = 0; i < cur.length(); i++)
        {
            if (cur.charAt(i) != pre.charAt(i))
            {
                count++;
            }
        }
        return count == 1;
    }


    public static void main(String[] args) {
        System.out.println(3 >> 1);
    }
}
