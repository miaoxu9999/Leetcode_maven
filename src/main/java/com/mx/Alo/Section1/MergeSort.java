package com.mx.Alo.Section1;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/26 19:10
 * @Version 1.0
 **/
public class MergeSort {
    public void Merge(int[] a, int start, int end)
    {
        if (start >= end || start >= (start + end) / 2)
        {
            return;
        }
        Merge(a, start, (start + end) / 2);
        Merge(a, (start + end) / 2 + 1, end);
        //将start到end归并起来
        merge_combine(a, start, (start + end) / 2, end);
    }

    public void merge_combine(int[] a, int start, int mid, int end)
    {
        if (start >= end || start >= mid)
        {
            return;
        }
        int cur = start;
        int i = 0,j = 0;

        int startindexi = start;
        int startindexj = mid;

        while (cur <= end && start <= mid && mid <= end)
        {
            //两个指针移动
            if (startindexi <= mid)
            {
                 i = a[startindexi];
            }
            else
            {
                 i = Integer.MAX_VALUE;
            }
            if (startindexj + 1<= end)
            {
                 j = a[startindexj + 1];
            }
            else
            {
                 j =Integer.MAX_VALUE;
            }
            if (i < j)
            {
                a[cur] = i;
                startindexi ++;
            }
            else
            {
                a[cur] = j;
                startindexj++;
            }
            cur++;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,7, 1,2,6};
        MergeSort mergeSort =  new MergeSort();
        System.out.println("排序前数组");
        mergeSort.printArrays(a);
        System.out.println("排序后数组");
        mergeSort.Merge(a, 0, a.length - 1);
        mergeSort.printArrays(a);

    }

    public void printArrays(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}
