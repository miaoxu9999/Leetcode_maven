package com.mx.util;

import java.util.Random;

/**
 * @ClassName RandomTwoArray
 * @Description 随机二维数组
 * @Author miaoxu
 * @Date 2019/8/11 14:34
 * @Version 1.0
 **/
public class RandomTwoArray {

    static int[][] nums;
    private static int default_row = 3;
    private static int default_col = 2;
    public static int[][] randomTwoArray(int row, int col)
    {
        nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            nums[i] = RandomArray.randomArray(col);
        }

        return nums;
    }

    public static int[][] randomTwoArray()
    {
        return randomTwoArray(default_row, default_row);
    }

    public static String print_String()
    {
        String res = "{";
        for (int i = 0; i < nums.length; i++) {
            res += "{";
            for (int j = 0; j < nums[i].length; j++) {
                res += nums[i][j] +",";
            }
            res += "},";
        }
         res += "}";
        return res;
    }

    public static void main(String[] args) {
        RandomTwoArray.randomTwoArray();
        System.out.println(RandomTwoArray.print_String());
    }
}
