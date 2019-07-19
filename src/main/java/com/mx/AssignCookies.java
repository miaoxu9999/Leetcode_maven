package com.mx;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName AssignCookies
 * @Description 455. Assign Cookies
 * 贪心算法解决
 * @Author miaoxu
 * @Date 2019/7/19 16:24
 * @Version 1.0
 **/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // 对s和g分别进行排序,由高到低
        Arrays.sort(g);
        Arrays.sort(s);
        g=  reverse(g);
        s = reverse(s);
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < s.length && j < g.length)
        {
            if (s[i] >= g[j])
            {
                res++;
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }



        return res;

    }
    public int[] reverse(int[] a)
    {
        int[] b = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            b[i] = a[a.length - i - 1];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1,1};
        new AssignCookies().findContentChildren(a, b);

    }
}
