package com.mx;

/**
 * @ClassName ValidPalindromeII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/25 9:01
 * @Version 1.0
 **/
public class ValidPalindromeII {
    public boolean isPalindrome(String s) {
        //指针l小于r
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while (l < r)
        {
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);
            if (!isValidChar(c1))
            {
                l++;
                continue;
            }
            if (!isValidChar(c2))
            {
                r--;
                continue;
            }
            if (isValidChar(c1) && isValidChar(c2))
            {
                if (c1 != c2 )
                {
                    return false;
                }
                else
                {
                    continue;
                }
            }


        }
        return true;
    }

    public  boolean isValidChar(char i)
    {
        if((i>=65&&i<=90)||(i>=97&&i<=122) || (i >=48 && i <=57))
        {
            return true;
        }
        return false;
    }
}
