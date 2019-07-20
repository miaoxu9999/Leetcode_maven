package com.mx;

/**
 * @ClassName 221 MaximalSquare
 * @Description 221.  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * @Author miaoxu
 * @Date 2019/7/20 16:57
 * @Version 1.0
 **/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0|| (matrix.length == 1 && matrix[0].length == 0))
        {
            return 0;
        }
        int[][] m = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 1)
                {
                    m[i][j] = 1;
                    int left = getMatrixValue(m, i - 1, j);
                    int top = getMatrixValue(m, i, j - 1);
                    int ali = getMatrixValue(m, i - 1, j - 1);
//                    int tem ;
//                    tem = Math.min(top, left);
//                    tem = Math.min(ali, tem);
//                    m[i][j] = tem + 1;
                    m[i][j] = Math.min(Math.min(top, left), ali) + 1;
                    res = Math.max(m[i][j], res);

                }
            }
        }

        return res * res;

    }

    public int getMatrixValue(int[][] matrix, int i, int j)
    {
        if (i < 0 || i > matrix.length)
        {
            return 0;
        }
        if (j < 0 || j > matrix[0].length)
        {
            return 0;
        }
        return matrix[i][j];

    }

    public static void main(String[] args) {
//        char[][] ma = {
//                {1, 0, 1, 0, 0},
//                {1, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1},
//                {1, 0, 0, 1, 0},
//        };
        char[][] ma = {
                {1, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };
//        char[][] ma = {
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//        };
        System.out.println(new MaximalSquare().maximalSquare(ma));
    }

}
