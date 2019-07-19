package com.mx;

/**
 * @ClassName RotateArray
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/20 17:15
 * @Version 1.0
 **/
public class RotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
        {
            return 0;
        }
        if (array.length == 1)
        {
            return array[0];
        }
        for (int i= 0; i < array.length - 1;i++)
        {
            if (array[i] < array[i + 1])
            {
                return array[i + 1];
            }
        }

        return 0;

    }

    public int Fibonacci(int n) {
        if (n == 0)
        {
            return 0;
        }
        if (n == 1 || n == 2)
        {
            return 1;
        }
        int[] f = new int [n + 1];
        f[1] = 1;
        f[2] = 1;

        return F(n - 1, f) + F(n -2, f);


    }

    public int F(int n,int[] f)
    {
        if (f[n] != 0)
        {
            return f[n];
        }
        else
        {
            f[n] = F(n - 1, f) + F(n -2, f);
        }
        return f[n];
    }

    public int JumpFloor(int target) {
        if (target <= 0)
        {
            return 0;
        }
        if (target == 1)
        {
            return 1;
        }
        if (target == 2)
        {
            return 2;
        }
        int[] f = new int[target + 1];
        f[1] = 1;
        f[2] = 2;

        return countOfJump(target, f);
    }

    public int countOfJump(int n, int[] f)
    {
        if (f[n] != 0)
        {
            return f[n];
        }
        f[n] = countOfJump(n -1, f) +  countOfJump(n -2, f);

        return f[n];
    }

    public int JumpFloorII(int target) {
        if (target <= 0)
        {
            return 0;
        }
        if (target == 1)
        {
            return 1;
        }
        if (target == 2)
        {
            return 2;
        }
        int[] f = new int[target + 1];
        f[1] = 1;
        f[2] = 2;
        return countOfJumpII(target, f);
    }

    public int countOfJumpII(int n, int[] f)
    {

        for (int j = 3; j <= n; j++)
        {
            int tem = 1;
            for (int i = j; i >= 1; i--)
            {
                tem +=  f[j + 1 - i];
            }
            f[j] = tem;
        }


        return f[n];
    }

    public static void main(String[] args) {

        System.out.println(new RotateArray().JumpFloorII(4));
    }

}




