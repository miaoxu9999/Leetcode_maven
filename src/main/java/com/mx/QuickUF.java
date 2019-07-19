package com.mx;

/**
 * @ClassName QuickUF
 * @Description
 * 改进union算法的
 * @Author miaoxu
 * @Date 2019/3/25 20:02
 * @Version 1.0
 **/
public class QuickUF
{
    private int[] id;
    private int[] sz;
    private int count;
    public QuickUF(int N)
    {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = i;
        }
    }
    public int getCount()
    {
        return count;
    }
    public boolean connected(int p, int q)
    {
       return find(p) == find(q);
    }

    public int find(int p)
    {
        while (p != id[p])
        {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        if (i == j)
        {
            return;
        }
        if (sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
