package com.mx;

/**
 * @ClassName LongestPalindromicSubstring
 * @Description 最长的回文字符串
 *
 * @Author miaoxu
 * @Date 2019/9/13 16:44
 * @Version 1.0
 **/
public class LongestPalindromicSubstring {
    int lo = 0, hi = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")){
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            expandString(s, i, i);
            expandString(s, i, i + 1);
        }

        return s.substring(lo, hi + 1);
    }

    private void expandString(String s,int l, int h) {
//        while ( l >= 0 && h < s.length() && s.substring(l, l + 1).equals(s.substring(h, h + 1))){
        while ( l >= 0 && h < s.length() && s.charAt(l)== (s.charAt(h))){
            l--;
            h++;
        }
        if (h - l - 2> hi - lo){
            hi = h - 1;
            lo = l + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println( new LongestPalindromicSubstring().longestPalindrome("babad"));;
        System.out.println( new LongestPalindromicSubstring().longestPalindrome("cbbd"));;
    }
}
