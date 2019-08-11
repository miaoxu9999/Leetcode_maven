package com.mx;

import com.mx.util.RandomTwoArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SetMatrixZeroes
 * @Description 73. Set Matrix Zeroes 将有0的元素行列放置为0
 * @Author miaoxu
 * @Date 2019/5/25 9:22
 * @Version 1.0
 **/
public class SetMatrixZeroes {
    boolean[][] visited;

//    public void setZeroes(int[][] matrix) {
//        // 行指针l, 列指针r
//        int row = 0;
//        int col = 0;
//        List<Integer> colList = new ArrayList<>();
//        for (int r = 0;r < matrix.length; r++)
//        {
//            for (int c = 0;c < matrix[0].length; c++)
//            {
//                if (find(c, colList))
//                {
//                    continue;
//                }
//                if (matrix[r][c] == 0)
//                {
//                    row = r;
//                    col = c;
//                    colList.add(col);
//                    //此时，将这一行所有列变为0
//                    for (int i = 0; i < matrix[0].length; i++)
//                    {
//                        matrix[row][i] = 0;
//                    }
//                    // 此时，将这一列，所有行变为0
//                    for (int i = 0; i < matrix.length; i++)
//                    {
//                        matrix[i][col] = 0;
//                    }
//                    break;
//                    //
//                }
//            }
//        }
//    }

    public void setZeroes(int[][] matrix) {
        // 查找所有零元素
        visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]){
                    setZeroes(matrix, i, j);
                }
            }
        }

    }

    public void setZeroes(int[][] matrix, int row, int col) {
        //对有0的行进行重置
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] == 0 && !visited[row][i]){
                visited[row][i] = true;
                setZeroes(matrix, row, i);
            }
            else {
                matrix[row][i] = 0;
                visited[row][i] = true;
            }
        }
        //对有0的列进行重置
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == 0 && !visited[i][col]){
                visited[i][col] = true;
                setZeroes(matrix, i, col);
            }
            else {
                matrix[i][col] = 0;
                visited[i][col] = true;
            }
        }

    }


    public boolean find(int c, List<Integer> list)
    {
        for (Integer i:list) {
            if ( i== c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] num = {{1,1,1},{1,0,1},{1,1,1}};
       new SetMatrixZeroes().setZeroes(num);

//        System.out.println(RandomTwoArray.replace("[[1,1,1],[1,0,1],[1,1,1]]"));
    }
}
