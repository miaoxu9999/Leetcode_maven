package com.mx;

import java.util.Arrays;

/**
 * @ClassName FindInTwoArray
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/20 14:35
 * @Version 1.0
 **/
public class FindInTwoArray {

    public boolean Find(int target, int [][] array) {
        if (array.length < 1 || array[0].length < 1)
        {
            return false;
        }

        for (int i = 0; i < array.length; i++)
        {
            if (target > array[i][array[i].length - 1])
            {
                if (Arrays.binarySearch(array[i], target) >= 0)
                {
                    return true;
                }
            }
            else
            {
                continue;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[][] a = {{}};
        System.out.println(new FindInTwoArray().Find(16, a));;
    }

}
