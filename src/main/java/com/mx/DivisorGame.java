package com.mx;

/**
 * @ClassName DivisorGame
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/14 10:40
 * @Version 1.0
 **/
public class DivisorGame {
    boolean[] res;
    public boolean divisorGame(int N) {
        res = new boolean[N + 1];
        res[1] = false;
        boolean r  = sub_divisor(N);
        return res[N];



    }

    public boolean sub_divisor(int n)
    {
        if (n == 1)
        {
            return false;
        }
        if (res[n])
        {
            return true;
        }
        for (int i = 1; i < n; i++)
        {
            if (n % i ==0  && !sub_divisor(n - i))
            {
                res[n] = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(2));
    }

}
