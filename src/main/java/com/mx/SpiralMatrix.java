package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralMatrix
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/29 14:40
 * @Version 1.0
 **/
public class SpiralMatrix {
    int rowLength;
    int colLength;
    int total;
    List<Integer> res;
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
    public List<Integer> spiralOrder(int[][] matrix)
    {
         res = new ArrayList<>();

        rowLength = matrix.length;
        if (rowLength < 1)
        {
            return res;
        }
        colLength = matrix[0].length;
        total = rowLength * colLength;
        boolean[][] visted= new boolean[rowLength][colLength];
        int visitnum = rowLength * colLength;
        Pair p1, p2, p3, p4;
        p1 = new Pair(0, 0);
        while (total != 0)
        {
            //按照右下左上的顺序遍历
            p1 = findEndRight(p1.x, p1.y, matrix, visted);
            if (total == 0)
            {
                break;
            }
            //按照从上往下的顺序
            p2 = findEndDown(p1.y, p1.x + 1, matrix, visted);
            if (total == 0)
            {
                break;
            }
            //从右往左的顺序
            p3 = findEndLeft(p2.x, p2.y - 1, matrix, visted);
            if (total == 0)
            {
                break;
            }
            //从下往上的顺序
            p4 = findEndUp(p3.y, p3.x - 1, matrix, visted);
            if (total == 0)
            {
                break;
            }
            p1 = new Pair(p4.x, p4.y + 1);
        }


        return res;

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
                total--;
                res.add(matrix[row][i]);
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
                total--;
                res.add(matrix[i][col]);
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
                total--;
                res.add(matrix[row][i]);
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
                total--;
                res.add(matrix[i][col]);
            }
        }
        return new Pair(i + 1, col);
    }
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> res = new ArrayList<>();
//
//        int rowLength = matrix.length;
//        if (rowLength < 1)
//        {
//            return res;
//        }
//        int colLength = matrix[0].length;
//        boolean[][] visted= new boolean[rowLength][colLength];
//        int visitnum = rowLength * colLength;
//
//        //按照右下左上的顺序遍历
//        for (int i= 0; i < colLength;)
//        {
//
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        //先遍历第一行
//        for (int i = 0; i < colLength; i++)
//        {
//            res.add(matrix[0][i]);
//        }
//        //再遍历最后一列
//        if (rowLength > 1)
//        {
//            for (int i = 1; i < rowLength;i++)
//            {
//                res.add(matrix[i][colLength - 1]);
//            }
//
//            //遍历最后一行
//            for (int i = colLength  -2; i >=0 ; i--)
//            {
//                res.add(matrix[rowLength - 1][i]);
//            }
//            //遍历倒数第二行，一直到正数第二行
//            for (int i= rowLength - 2; i >= 1; i--)
//            {
//                if ((rowLength - i) % 2 != 0 )
//                {
//                    //倒序遍历
//                    traverseInvertedOrder(res, matrix, i, 0, colLength - 1);
//                }
//                else
//                {
//                    //正序遍历
//                    traversePositiveOrder(res, matrix, i, 0, colLength - 1);
//                }
//            }
//        }
//
//        return res;
//
//    }

    //正序遍历
    public void traversePositiveOrder(List<Integer> res, int[][] matrix, int row, int start, int end)
    {
        for (int i = start; i < end; i++)
        {
            res.add(matrix[row][i]);
        }
    }
    //倒序遍历
    public void traverseInvertedOrder(List<Integer> res, int[][] matrix, int row, int start, int end)
    {
        for (int i = end - 1; i >= start; i--)
        {
            res.add(matrix[row][i]);
        }
    }


    public void test()
    {
        int[][] m = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] m1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        spiralOrder(m);
    }


    public static void main(String[] args) {
        new SpiralMatrix().test();
    }
}
