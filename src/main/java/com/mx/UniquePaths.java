package com.mx;

import java.util.Arrays;

/**
 * @ClassName UniquePaths
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/1 20:50
 * @Version 1.0
 **/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        if (m < 2 || n < 2)
        {
            return 1;
        }
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        int x = getRes(matrix,  m, n);
        return x;
    }

    public int getRes(int[][] matrix, int m, int n)
    {
        if (m - 1 < 0 || n - 1 < 0)
        {
            return 0;
        }
        if (matrix[m - 1][n - 1] != 0)
        {
            return matrix[m - 1][n - 1];
        }
        int l;
        if (m - 2 >= 0 && n - 1 >= 0 && matrix[m - 2][n - 1] != 0)
        {
            l = matrix[m - 2][n - 1];
        }
        else
        {
            l = getRes(matrix, m - 1, n);
        }
        int r;
        if (m - 1 >= 0 && n - 2>= 0 && matrix[m - 1][n - 2] != 0)
        {
            r = matrix[m - 1][n - 2] ;
        }
        else
        {
            r = getRes(matrix, m, n - 1);
        }
        matrix[m - 1][n - 1] = l + r;

        return  l + r;
    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(23, 12);
    }
}
