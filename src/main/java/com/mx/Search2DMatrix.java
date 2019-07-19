package com.mx;

import java.util.Arrays;

/**
 * @ClassName Search2DMatrix
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/14 15:53
 * @Version 1.0
 **/
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||matrix.length==0||(matrix.length==1&&matrix[0].length==0))
        {
            return false;
        }
        //取定属于哪一排
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        for (i = 0; i < row; i++)
        {
            if (target >matrix[i][col - 1])
            {
                continue;
            }
            else
            {
                break;
            }
        }
        if (i >= row)
        {
            return false;
        }
        int res  = Arrays.binarySearch(matrix[i], target);
        return res >= 0;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1,   3,  5,  7},
        {10, 11, 16, 20},
            {23, 30, 34, 50},
        };

        int[][] m1= {{1}};

        new Search2DMatrix().searchMatrix(m1, 3);
    }
}
