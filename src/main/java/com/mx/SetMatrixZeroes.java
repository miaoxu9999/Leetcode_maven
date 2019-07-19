package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SetMatrixZeroes
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/25 9:22
 * @Version 1.0
 **/
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        // 行指针l, 列指针r
        int row = 0;
        int col = 0;
        List<Integer> colList = new ArrayList<>();
        for (int r = 0;r < matrix.length; r++)
        {
            for (int c = 0;c < matrix[0].length; c++)
            {
                if (find(c, colList))
                {
                    continue;
                }
                if (matrix[r][c] == 0)
                {
                    row = r;
                    col = c;
                    colList.add(col);
                    //此时，将这一行所有列变为0
                    for (int i = 0; i < matrix[0].length; i++)
                    {
                        matrix[row][i] = 0;
                    }
                    // 此时，将这一列，所有行变为0
                    for (int i = 0; i < matrix.length; i++)
                    {
                        matrix[i][col] = 0;
                    }
                    break;
                    //
                }
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
}
