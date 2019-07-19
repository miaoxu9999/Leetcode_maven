package com.mx;

import java.util.Scanner;

/**
 * @ClassName MagicCoin
 * @Description 网易魔法币
 * @Author miaoxu
 * @Date 2019/6/22 10:07
 * @Version 1.0
 **/
public class MagicCoin {

    public static int getResByFirstMachine(int num)
    {
        return num * 2 + 1;
    }

    public static int getResBySecondMachine(int num)
    {
        return num * 2 + 2;
    }

    public static String getRes(int money, String s, int way, int target)
    {
        if (way != -1)
        {
            s += way;
        }

        if (money == target)
        {

            return s;
        }
        else if (money > target)
        {
            return null;
        }
        else
        {
            String s1 = getRes(getResByFirstMachine(money), s, 1, target);
            if (s1 != null)
            {
                return s1;
            }
            String s2 = getRes(getResBySecondMachine(money), s, 2, target);
            if (s2 != null)
            {
                return s2;
            }

        }
        return null;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case              int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(getRes(0, "", -1, b));
//            System.out.println(getRes(0, "", 2, b));
        }
    }
}
