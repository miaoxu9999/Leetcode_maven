package com.mx;


import edu.princeton.cs.algs4.StdIn;

/**
 * @ClassName UF
 * @Description TODO
 * @Author miaoxu
 * @Date 2018/12/11 22:47
 * @Version 1.0
 **/
public class UF {
    private int[] id;
    private int count;
    public UF(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }
    public int count()
    {
        return count;
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    public int find(int p)
    {
        while (p != id[p]) //相等的时候是根节点
        {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q)
    {
        // 将p和q归并到一个分量中
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
        {
            return;
        }
        for (int i = 0; i < id.length; i++)
        {
            //将pId所属节点的值全部改为一个
            if (id[i] == pId)
            {
                id[i] = qId;
            }
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
    }
}
