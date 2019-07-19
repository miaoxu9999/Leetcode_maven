package com.mx;

import java.util.Scanner;

/**
 * @ClassName ReArrangeNum
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/22 11:35
 * @Version 1.0
 **/
public class ReArrangeNum
{
    public static boolean isSatisfy(int[] nums)
    {
        int fourcount = 0;
        int twocount = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 4 == 0)
            {
                fourcount++;
            }
            else if (nums[i] % 2 == 0)
            {
                twocount++;
            }
            else
            {
                left++;
            }
        }
        if (fourcount > left - 1)
        {
            return true;
        }
        else if (fourcount == left - 1)
        {
            if (twocount == 0)
            {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int count = 0;
        while (count < total) {//注意while处理多个case

            int arrlen = in.nextInt();
            int[] nums = new int[arrlen];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }
            boolean flag = isSatisfy(nums);
            if (flag)
            System.out.println("Yes");
            else
                System.out.println("No");
            count++;
        }
    }
}
