package com.mx;

import java.util.*;

/**
 * @ClassName ReverseNum
 * @Description 相反数
 * @Author miaoxu
 * @Date 2019/6/22 10:24
 * @Version 1.0
 **/
public class ReverseNum {

    public static int getRerseNum(int num)
    {
        List<Integer> list = new ArrayList<>();
        while (num != 0)
        {
            int yushu = num % 10;
            list.add(yushu);
            num = num / 10;
        }
        int count  = list.size() - 1;
        boolean flag = false; // 判断前面的是否为0
        int res = 0;
        for (Integer n: list)
        {
            if (flag)
            {
                res += Math.pow(10, count) * n;
                count--;
            }
            else if (n != 0)
            {
                flag = true;
                res += Math.pow(10, count) * n;
                count--;
            }
            else
            {
                count--;
                continue;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case              int a = in.nextInt();
            int b = in.nextInt();
            int reverse = getRerseNum(b);
            System.out.println(b + reverse);
        }
    }
}
