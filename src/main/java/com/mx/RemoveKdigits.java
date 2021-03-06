package com.mx;

import java.util.Stack;

/**
 * @ClassName RemoveKdigits
 * @Description TODO
 * @Author miaoxu
 * @Date 2018/12/19 21:12
 * @Version 1.0
 **/
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        if (num.length() == 0 || num.length() <= k)
            return "0";

        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && cur < stack.peek()
                    && num.length() - i - 1 >= (num.length() - k) - stack.size()) {
                stack.pop();
            }
            if (stack.size()<num.length()-k)
                stack.push(cur);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.insert(0, stack.pop());

        while (res.length() > 0 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        if (res.length() == 0)
            return "0";
        return res.toString();
    }

    public static void main(String[] args) {
        new RemoveKdigits().removeKdigits("143279",1 );
    }
}
