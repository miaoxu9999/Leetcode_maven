package com.mx;

import java.util.Arrays;

/**
 * @ClassName UniquePathsII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/16 21:18
 * @Version 1.0
 **/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1)
        {
            for (int i =0; i < n; i++)
            {
                if (obstacleGrid[0][i] == 1)
                {
                    return 0;
                }
            }
            return 1;
        }
        if (n == 1)
        {
            for (int i =0; i < m; i++)
            {
                if (obstacleGrid[i][0] == 1)
                {
                    return 0;
                }
            }
            return 1;
        }
        if (m < 2 || n < 2)
        {
            return 1;
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(matrix[i],  new Integer(-1));
        }

        if (obstacleGrid[0][0] == 1)
        {
            return 0;
        }
        matrix[0][0] = 1;
        if (obstacleGrid[0][1] == 1)
        {
            matrix[0][1] = 0;
        }
        else
        {
            matrix[0][1] = 1;
        }
        if (obstacleGrid[1][0] == 1)
        {
            matrix[1][0] = 0;
        }
        else
        {
            matrix[1][0] = 1;
        }



        int x = getRes(matrix,  m - 1, n - 1, obstacleGrid);
        return x;
    }

    public int getRes(int[][] matrix, int m, int n, int[][] obstacleGrid)
    {
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1)
        {
            return 0;
        }
        if (matrix[m][n] == -1)
        {
            matrix[m][n] = getRes(matrix, m - 1, n,obstacleGrid) + getRes(matrix, m, n - 1, obstacleGrid);
        }

        return matrix[m][n];
    }

    public static void main(String[] args) {
        int[][] m = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(new UniquePathsII().uniquePathsWithObstacles(m));
    }
}
