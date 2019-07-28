package com.mx;

import java.util.*;

/**
 * @ClassName IsStringCycle
 * @Description 拼多多面试题，字符串数组是否能构成一个环，使得每一个字符串的前一个值的末尾和是后一个值的前缀
 * @Author miaoxu
 * @Date 2019/7/28 15:40
 * @Version 1.0
 **/
public class IsStringCycle {

    public static void main(String[] args) {
        //读取数据
        // 记录所有字符串的首尾
        // 遍历，判断能否形成环

        Scanner in = new Scanner(System.in);
        int count = 0;
//        int[] A = {0};
        int[] B;
        while (in.hasNextLine())
        {
            String a = in.nextLine();
            String[] A = a.split(" ");
            boolean f = isCycle(A);
            if (f)
            {
                System.out.println("true");
            }
            else
            {
                System.out.println("false");
            }
        }
    }

    public static boolean isCycle(String[] a)
    {

        int[] start = new int[26];
        int[] end = new int[26];

        for (int i = 0; i < a.length; i++) {
            char s = a[i].charAt(0);
            char e = a[i].charAt(a[i].length() - 1);
            start[s - 'A'] = start[s - 'A'] + 1;
            end[e - 'A'] = end[e - 'A'] + 1;
        }

        for (int i = 0; i < end.length; i++) {
            while (end[i] > 0)
            {
                if (start[i] <= 0)
                {
                    return false;
                }
                else
                {
                    end[i] -= 1;
                    start[i] -= 1;
                }
            }
        }

        if (findAllaero(start) && findAllaero(end))
        {
            return true;
        }

        return false;
    }

    public static  boolean findAllaero(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean judge(String[] arr)
    {
        List<String> list = Arrays.asList(arr);
        for (int i = 0; i < list.size(); i++) {
            List<String> newList = new ArrayList<>(list);
            newList.remove(i);
            if (judgeFixed(list.get(i), newList))
                return true;
        }
        return false;
    }

    public static boolean judgeFixed(String s, List<String> list )
    {
        if (list.size() == 0)
        {
            return true;
        }
        char tail = s.charAt(s.length() - 1);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(0) == tail)
            {
                List<String> newList = new ArrayList<>(list);
                newList.remove(i);
                if (judgeFixed(list.get(i), newList))
                {
                    return true;
                }
            }
        }
        return false;

    }
}
