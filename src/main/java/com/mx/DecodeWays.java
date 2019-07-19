package com.mx;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName DecodeWays
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/17 19:33
 * @Version 1.0
 **/
public class DecodeWays {
    HashMap<Integer, Character> map = new HashMap<>();
    public void init()
    {
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        map.put(4, 'D');
        map.put(5, 'E');
        map.put(6, 'F');
        map.put(7, 'G');
        map.put(8, 'H');
        map.put(9, 'I');
        map.put(10, 'J');
        map.put(11, 'K');
        map.put(12, 'L');
        map.put(13, 'M');
        map.put(14, 'N');
        map.put(15, 'O');
        map.put(16, 'P');
        map.put(17, 'Q');
        map.put(18, 'R');
        map.put(19, 'S');
        map.put(20, 'T');
        map.put(21, 'U');
        map.put(22, 'V');
        map.put(23, 'W');
        map.put(24, 'X');
        map.put(25, 'Y');
        map.put(26, 'Z');
    }


    public int numDecodings(String s)
    {
        if (s.length() == 0)
        {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ?0: 1;
        for (int i = 2; i <= n; i++)
        {
            if (s.charAt(i - 1) != '0')
            {
                dp[i] = dp[i - 1];
            }
            if (Integer.parseInt(s.substring(i- 2, i)) >= 10 && Integer.parseInt(s.substring(i- 2, i)) <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];

    }



//    public int numDecodings(String s) {
//        init();
//        if(s == null || s.trim().equals(""))
//        {
//            return 0;
//        }
//        if (s.length() < 2)
//        {
//            return Math.max(check(s, 0, 1), 0);
//        }
//        if (s.charAt(0) == '0')
//        {
//            return 0;
//        }
//        int[] dp = new int[s.length()];
//
//        Arrays.fill(dp, -1);
//        dp[0] = 1;
//
////        dp[1] = Math.max(check(s, 0, 2), 0);
////        String s2 = s.substring(0,2);
//        dp[1] = getRees(dp,1, s.substring(0,2));
//        if (dp[1] == 0)
//            return 0;
//        getRees(dp, s.length() - 1, s);
//        return dp[s.length() - 1];
//
//    }

    public int getRees( int[] dp, int m, String s)
    {
        if (m < 0 )
        {
            return 0;
        }
        if (dp[m] != -1)
        {
            return dp[m];
        }
        //当前字符串的前两个字符串
        int t = check(s, m - 1, m + 1);
        //当前字符串的前一个字符串
        int t1 = check(s, m, m + 1);
        //计算取一个的时候和前面的是否能转化成字母

        if (t == 0 && t1 == 0)
        {
            dp[s.length() - 1] =0;
            return 0;
        }
        if (m < 2)
        {
            dp[m] = Math.max(getRees(dp, m - 1, s), getRees(dp, m - 2, s) + t);
            return dp[m];
        }
        int t2 = check(s, m - 2, m);
        //当前字段的前两个中有10 后者20 这种 比如110
        if ((t != 0 && t1 == 0))
        {
            dp[m - 1] = getRees(dp, m - 2, s);
            dp[m] = Math.max(getRees(dp, m - 1, s), getRees(dp, m - 2, s) + t - 1);
            return dp[m];

        }
        if (t2 == 0)
        {
            if (t == 0 && s.charAt(m - 1) == '0')
            {
                dp[s.length() - 1] =0;
                return 0;
            }
            dp[m - 1] = getRees(dp, m - 2, s);
            dp[m] = Math.max(getRees(dp, m - 1, s), getRees(dp, m - 2, s) + t - 1);
            return dp[m];

        }
        dp[m] = Math.max(getRees(dp, m - 1, s), getRees(dp, m - 2, s) + t);
//        if (t2 == 0)
//        {
//            dp[m] = Math.max(getRees(dp, m - 1, s), getRees(dp, m - 2, s) );
//        }
//        else
//        {
//
//
//        }

        return dp[m];
    }


    public int check(String string, int start, int end)
    {

        String s = string.substring(start, end);
        if (map.get(Integer.parseInt(s)) == null)
        {
            return 0;
        }
        if (s.length() == 1)
        {
            return 1;
        }
        if (Integer.parseInt(s) < 10)
        {
            return 0;
        }
        if ((Integer.parseInt(s) == 10 || Integer.parseInt(s) == 20)  )
        {
            return 1;
        }


        return 2;

    }

    public static void main(String[] args) {
//        for (int i = 1; i <= 26;i++)
//        {
//            System.out.println(String.format("map.put(%s, '%s');", i, (char)(i + 64)));
//        }
//        System.out.println(new DecodeWays().numDecodings("611"));;
//        System.out.println(new DecodeWays().numDecodings("1"));;
//        System.out.println(new DecodeWays().numDecodings("27"));;
//        System.out.println(new DecodeWays().numDecodings("0"));;
//        System.out.println(new DecodeWays().numDecodings("121"));;
//        System.out.println(new DecodeWays().numDecodings("1029"));;
//        System.out.println(new DecodeWays().numDecodings("1001"));;
//        System.out.println(new DecodeWays().numDecodings("301"));;
//        System.out.println(new DecodeWays().numDecodings("101"));;
//        System.out.println(new DecodeWays().numDecodings("110"));;
//        System.out.println(new DecodeWays().numDecodings("12"));;
//        System.out.println(new DecodeWays().numDecodings("226"));;
//        System.out.println("1");

//        System.out.println((char)("01"));
//        System.out.println((char)("01"));

        System.out.println("sdfsd".replace("df", ""));
    }
}
