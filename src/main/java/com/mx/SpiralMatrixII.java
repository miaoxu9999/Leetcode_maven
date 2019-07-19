package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralMatrixII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/30 11:23
 * @Version 1.0
 **/
public class SpiralMatrixII {
    int rowLength;
    int colLength;
    int total = 0;
    int[][] matrix;
    class Pair
    {
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] generateMatrix(int n)
    {
        matrix = new int[n][n];
        rowLength = matrix.length;
        if (rowLength < 1)
        {
            return matrix;
        }
        colLength = matrix[0].length;
        boolean[][] visted= new boolean[rowLength][colLength];
        int visitnum = rowLength * colLength;
        Pair p1, p2, p3, p4;
        p1 = new Pair(0, 0);
        while (total != visitnum)
        {
            //按照右下左上的顺序遍历
            p1 = findEndRight(p1.x, p1.y, matrix, visted);
            if (total == visitnum)
            {
                break;
            }
            //按照从上往下的顺序
            p2 = findEndDown(p1.y, p1.x + 1, matrix, visted);
            if (total == visitnum)
            {
                break;
            }
            //从右往左的顺序
            p3 = findEndLeft(p2.x, p2.y - 1, matrix, visted);
            if (total == visitnum)
            {
                break;
            }
            //从下往上的顺序
            p4 = findEndUp(p3.y, p3.x - 1, matrix, visted);
            if (total == visitnum)
            {
                break;
            }
            p1 = new Pair(p4.x, p4.y + 1);
        }


        return matrix;

    }



    public Pair findEndRight(int row, int colStart, int[][] matrix, boolean[][] visted)
    {
        int i;
        for ( i = colStart; i < colLength; i++ )
        {
            if (visted[row][i])
            {
                return new Pair(row, i - 1);
            }
            else
            {
                visted[row][i] = true;
                total++;
                matrix[row][i] = total;
            }
        }
        return new Pair(row, i -1);
    }
    //按照从上往下的顺序
    public Pair findEndDown(int col, int rowStart, int[][] matrix, boolean[][] visted)
    {
        int i;
        for (i = rowStart; i < rowLength; i++)
        {
            if (visted[i][col])
            {
                return new Pair(i - 1, col);
            }
            else
            {
                visted[i][col] = true;
                total++;
                matrix[i][col] = total;
            }
        }
        return new Pair(i - 1, col);
    }
    //从右往左的顺序
    public Pair findEndLeft(int row, int colStart, int[][] matrix, boolean[][] visted)
    {
        int i;
        for (i = colStart; i>= 0; i--)
        {
            if (visted[row][i])
            {
                return new Pair(row, i + 1);
            }
            else
            {
                visted[row][i] = true;
                total++;
                matrix[row][i]= total;
            }
        }
        return new Pair(row, i + 1);
    }
    //从下往上的顺序
    public Pair findEndUp(int col, int rowStart, int[][] matrix, boolean[][] visted)
    {
        int i;
        for (i = rowStart; i >= 0; i--)
        {
            if (visted[i][col])
            {
                return new Pair(i + 1, col);
            }
            else
            {
                visted[i][col] = true;
                total++;
                matrix[i][col] = total;
            }
        }
        return new Pair(i + 1, col);
    }


    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(3);
    }
}
