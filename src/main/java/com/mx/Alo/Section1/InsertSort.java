package com.mx.Alo.Section1;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/26 18:54
 * @Version 1.0
 **/
public class InsertSort {
    public void Insert(int[] a)
    {
        for (int j = 1; j < a.length; j++)
        {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key)
            {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,7, 1,2,6};
        InsertSort insertSort = new InsertSort();
        System.out.println("排序前数组");
        insertSort.printArrays(a);
        System.out.println("排序后数组");
        insertSort.Insert(a);
        insertSort.printArrays(a);

    }

    public void printArrays(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}
