package com.mx;

/**
 * @ClassName RotateImage
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/1 17:08
 * @Version 1.0
 **/
public class RotateImage {
    public  void swap(int i, int j, int m , int n, int[][] matrix)
    {
        matrix[m][n] = matrix[i][j] ^matrix[m][n] ^ matrix[i][j];
        matrix[i][j] = matrix[i][j] ^matrix[m][n] ^matrix[m][n];
    }

    public void rotateFour(int m, int n, int[][] matrix)
    {
        int count = 0;
        int temp1 = matrix[m][n], temp2;
        while (count != 4)
        {
            count++;
            int nextr = n;
            int nextc = matrix.length - 1 - m;
            temp2 =  matrix[nextr][nextc];
            matrix[nextr][nextc] = temp1;
            m = nextr;
            n = nextc;
            temp1 = temp2;
        }


    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2)
        {
            return;
        }
        //调整第一行
        for (int i = 0; i < n - 1; i++)
        {
            rotateFour(0, i,  matrix);
        }
        int end = n / 2;
        //调整对角线
        for (int i = 1; i <end; i++)
        {
            rotateFour(i, i, matrix);
        }

    }

    public static void main(String[] args) {
        int[][] m ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] m1= {
            { 5, 1, 9,11},
            { 2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,16} ,};
        new RotateImage().rotate(m1);
    }
}
