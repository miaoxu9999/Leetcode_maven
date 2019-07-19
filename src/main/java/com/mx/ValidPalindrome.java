package com.mx;

/**
 * @ClassName ValidPalindrome
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/19 14:18
 * @Version 1.0
 **/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 1)
        {
            return true;
        }
        //过滤字符串,判定是否为回文字符串
        String temp = "";
        for (int j = 0; j < s.length(); j++)
        {
            char   c   =   s.charAt(j);
            int   i   =(int)c;
            if((i>=65&&i<=90)||(i>=97&&i<=122) || (i >=48 && i <=57))
            {
                temp += String.valueOf(c).toLowerCase();
            }
        }


        return  Palindrome(temp);
    }

    public boolean Palindrome(String s)
    {
        for (int i = 0, j = s.length() - 1; i < j; i++,j--)
        {
            if (s.charAt(i)!= s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }

}
