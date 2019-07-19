package com.mx;

/**
 * @ClassName NumberOfIslands
 * @Description
 * 二维数组，其中只有0和1，计算其中的联通分量的数目
 *
 * @Author miaoxu
 * @Date 2019/3/25 20:10
 * @Version 1.0
 **/
public class NumberOfIslands {
    int[]sz;

    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        if (rowLength < 1)
        {
            return 0;
        }
        sz = new int[rowLength * colLength];
        int[] id = new int[rowLength * colLength];
        //为每个数组元素赋值
        for (int i = 0; i < id.length; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
        int count = id.length;
        int total = 0;
        int sub = 0;
        //遍历数组
        for (int i = 0; i < rowLength; i++)
        {
            for (int j = 0; j < colLength; j++)
            {
                if (grid[i][j] != '1')
                {
                    continue;
                }
                total++;
                //判断grid[i][j]和它右面，下面的格子是否连接
                int location = location(i, j, colLength);
                if (i + 1 < rowLength)
                {
                    if ( grid[i][j] == grid[i + 1][j])
                    {
                        // 下面格子的位置
                        int downLocation = location(i + 1, j, colLength);
                        //判断两者是否在同一个联通分量中
                        int pId = find(location, id);
                        int qId = find(downLocation, id);
                        if ( qId!= pId)
                        {
                            union(pId, qId, id);
                            sub++;
                        }
                    }

                }
                if (j + 1 < colLength)
                {
                    if (grid[i][j] == grid[i][j + 1])
                    {
                        // 右面格子的位置
                        int rightLocation = location(i, j + 1, colLength);
                        //判断两者是否在同一个联通分量中
                        int pId = find(location, id);
                        int qId = find(rightLocation, id);
                        if ( qId!= pId)
                        {
                            union(pId, qId, id);
                            sub++;
                        }
                    }

                }
            }
        }

        return total - sub;

    }

    /**
     * @Author miaoxu
     * @Description
     * 根据行，列，行的长度获取位置信息
     * @Date 20:24 2019/3/25
     * @Param [row, col, rowLength]
     * @return int
     **/
    public int location(int row, int col, int colLength)
    {
        return row * colLength + col;
    }

    public int find(int p, int[]id)
    {
        while (p != id[p])
        {
            p = id[p];
        }
        return p;
    }

    public void union(int pId, int qId, int[] id)
    {
        if (sz[pId] < sz[qId])
        {
            id[pId] = qId;
            sz[qId] += sz[pId];
        }
        else
        {
            id[qId] = pId;
            sz[pId] += sz[qId];
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},

        };

        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
