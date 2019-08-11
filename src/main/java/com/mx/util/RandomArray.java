package com.mx.util;

import java.util.Random;

/**
 * @ClassName RandomArray
 * @Description 生成随机的二维数组
 * @Author miaoxu
 * @Date 2019/8/11 14:23
 * @Version 1.0
 **/
public class RandomArray {
    private static int defaultNum = 5;
    static int[] nums;
    public static int[] randomArray(int cap)
    {
        nums = new int[cap];
        Random random = new Random();
        for (int i = 0; i < cap; i++) {
            nums[i] = random.nextInt(10);
        }
        return nums;
    }

    public static int[] randomArray() {
        return randomArray(defaultNum);
    }

    public static String print_String()
    {
        String res = "{";

        for (Integer integer: nums){
            res = res + integer + ",";

        }
        res += "}";
        return res;
    }



    public static void main(String[] args) {
        RandomArray.randomArray(10);
        System.out.println(RandomArray.print_String());
    }
}
