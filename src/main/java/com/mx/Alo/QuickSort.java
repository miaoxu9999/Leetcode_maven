package com.mx.Alo;

/**
 * @ClassName QuickSort
 * @Description
 * 快速排序
 * @Author miaoxu
 * @Date 2019/5/7 15:06
 * @Version 1.0
 **/
public class QuickSort {

    public int partition(int[] A, int s, int e)
    {
        if (s < 0 || e > A.length)
        {
            return -1;
        }
        int key = A[s];
        int c = s;
        int j = e - 1;
        while (c < e && j >= c)
        {
            if (A[c] > key)
            {
                exchange(A, c, j);
                j--;
                continue;
            }
            c++;
        }
        exchange(A, j, s);
        return j;
    }

    public void exchange(int[] A, int s, int e)
    {
        int t = A[s];
        A[s] = A[e];
        A[e] = t;
    }

    public void quick(int[] A, int l, int h)
    {
        if (l < h)
        {
            int i = partition(A, l, h);
            quick(A, l, i - 1);
            quick(A,i + 1,h );
        }

    }

    public static void main(String[] args) {
        int[] n = {2, 8, 7, 1, 3, 5, 6, 4};
        new QuickSort().quick(n, 0, n.length);
        for (int i: n
             ) {
            System.out.println(i);

        }
    }
}
