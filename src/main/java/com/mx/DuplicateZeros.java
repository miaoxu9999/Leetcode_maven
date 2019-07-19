package com.mx;

/**
 * @ClassName DuplicateZeros
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/16 11:31
 * @Version 1.0
 **/
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
//        碰到0后面的数字向后偏移1个单位
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
            {
                shift(arr, i+ 1);
                if (i + 1 < arr.length)
                {
                    arr[i + 1] = 0;
                    i++;
                }

            }
        }
        return;
    }

    public void shift(int[] arr, int i)
    {
        //从i开始，所有元素向后平移一个单位
//        从倒数第二个元素开始
        int prelast = arr.length - 2;
        while (prelast >= 0 && prelast>= i)
        {
            arr[prelast + 1] = arr[prelast];
            prelast--;
        }
    }

    public static void main(String[] args) {
//        int[] a = {1,0,2,3,0,4,5,0};
//        new DuplicateZeros().duplicateZeros(a);


    }
}
