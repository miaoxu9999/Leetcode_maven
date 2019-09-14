package com.mx;

/**
 * @ClassName CountingBits
 * @Description 计算0-num范围内的数字每个含有多少个1
 * @Author miaoxu
 * @Date 2019/9/14 15:23
 * @Version 1.0
 **/
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int i = 1;
        int count = 0;
        while (i <= num){
//            res[i] = 1 + res[(int)(i - Math.pow(2, count))];
            res[i] = 1 + res[(int)(i - (2 << (count - 1)))];
//            if (Math.pow(2, count + 1) == i){
            if ((2 << (count)) == i){
                    res[i] = 1;
                count++;
            }
            i++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] r = new CountingBits().countBits(5);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

        System.out.println(2 >> 1);
        System.out.println(4 >> 1);
    }
}
