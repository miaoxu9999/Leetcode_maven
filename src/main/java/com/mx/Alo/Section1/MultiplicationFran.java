package com.mx.Alo.Section1;

/**
 * @ClassName MultiplicationFran
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/15 16:12
 * @Version 1.0
 **/
public class MultiplicationFran {

    public int multiply(int x, int y)
    {
        if (y == 0)
        {
            return 0;
        }
        int z = multiply(x, y / 2);
        if (y % 2 == 0)
        {
            return 2 * z;
        }
        else
        {
            return x + 2 * z;
        }
    }

    public static void main(String[] args) {

        System.out.println( new MultiplicationFran().multiply(9, 5)
);
    }
}
