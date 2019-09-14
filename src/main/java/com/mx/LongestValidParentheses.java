package com.mx;

import java.util.Stack;

/**
 * @ClassName LongestValidParentheses
 * @Description 最长的合法的括号
 * @Author miaoxu
 * @Date 2019/9/13 17:26
 * @Version 1.0
 **/
public class LongestValidParentheses {
    int count = 0;
    int[][] dp;
    public int longestValidParentheses(String s) {
        int[] longest = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
           if (s.charAt(i) == ')'){
               if (s.charAt(i - 1) == '('){
                   longest[i] = i - 2 >= 0 ?longest[i - 2] + 2: 2 ;
               }
               else if (i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1 ) == '('){
                   longest[i] = longest[i - 1] + 2 +  (i - longest[i - 1] - 2 >= 0 ? longest[i - longest[i - 1] - 2] : 0);
               }
           }
            count = Math.max(longest[i], count);
        }
        //从[0, n]的dp数组
        return count;
    }

    private int  helper(String s, int start, int end) {
        if (start >= end || start < 0 || start >= s.length() || end >= s.length() || end < 0) {
            return 0;
        }
        if (dp[start][end] != 0){
            return dp[start][end];
        }
        if (s.charAt(start) =='(' && s.charAt(end) == ')'){
            if (start + 1 < s.length()){
               if (s.charAt(start + 1) == ')'){
                   dp[start][end] = Math.max(helper(s, start + 2, end) + 2, dp[start][end]);
               }
               else {
                   if ((end - start - 1) % 2 != 0 ){
                       dp[start][end] = 0;
                   }
                   else {
                       dp[start][end] = helper(s, start + 1, end - 1) + 2;
                   }

               }
            }
            count = Math.max(dp[start][end], count);
        }
        else {
            dp[start][end] = 0;

        }
        helper(s, start + 1, end);
        helper(s, start , end - 1);
        return dp[start][end];
    }

    private void expandParentheses(String s, int l) {
        int lo = l;
        int hi = l + 1;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == '(' && s.charAt(hi) == ')'){
            lo--;
            hi++;
        }
        if (hi- lo - 1 > count){
            count = hi- lo - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
//        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
//        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
//        System.out.println(new LongestValidParentheses().longestValidParentheses("()(())"));
        System.out.println(new LongestValidParentheses().longestValidParentheses("((()))())"));
    }
}
