package com.mx;

import java.util.Scanner;

/**
 * @ClassName Fragment
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/22 10:56
 * @Version 1.0
 **/
public class Fragment {

    public static double getMeanFragmentLength(String s) {
        int[] a = new int[26];
        int part = 0;
        int totallen = 0;
        //遍历s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a[c - 'a'] == 0)
            {
                // 第一次出现，计算c的碎片长度

                part += 1;
                int count = 0;
                while (i < s.length() && s.charAt(i) == c)
                {
                    i++;
                    count++;
                }
                i--;
                a[c - 'a'] = count;
                totallen += count;
            }
            else
            {
                int count = a[c - 'a'];
                part = part + 1;
                totallen += count;
                i += (count - 1);
            }
        }
        return (double) totallen / part;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case              int a = in.nextInt();
            String s = in.next();
            System.out.println(getMeanFragmentLength(s));
        }
    }
}
