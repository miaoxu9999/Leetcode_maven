package com.mx;

/**
 * @ClassName NthTribonacciNumber
 * @Description NthTribonacciNumber 和斐波那契数列类似
 * @Author miaoxu
 * @Date 2019/7/28 10:35
 * @Version 1.0
 **/
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        if (n ==0 )
        {
            return 0;
        }
        if (n == 1 || n == 2)
        {
            return 1;
        }
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        int res = 0;
        for (int i = 3; i <= n ; i++) {
            res = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new NthTribonacciNumber().tribonacci(25));;
    }
}
