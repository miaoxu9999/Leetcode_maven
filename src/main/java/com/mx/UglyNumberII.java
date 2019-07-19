package com.mx;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName UglyNumberII
 * @Description
 * 丑陋数字，他的因子都是2，3，5
 * @Author miaoxu
 * @Date 2019/5/8 9:44
 * @Version 1.0
 **/
public class UglyNumberII {
//    public int nthUglyNumber(int n) {
//        if (n == 1)
//        {
//            return 1;
//        }
//        //存储2,3,5三个因子，以及他们的数量，找出当前最小的值
//        //加入到队列中
//        int count = 1;
//        int min = 1;
//        int i = 1;
//        while (count != n)
//        {
//            i++;
//            if (valid(i))
//            {
//                count++;
//            }
//        }
//
//    return i;
//    }

    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1l);

        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }

    public boolean valid(int i)
    {
        if (i == 1)
        {
            return true;
        }
        if (i % 2 == 0)
        {
            i = i / 2;
            return valid(i);
        }
        if (i % 3 == 0)
        {
            i = i / 3;
            return valid(i);
        }
        if (i % 5 == 0)
        {
            i = i / 5;
            return valid(i);
        }

        return false;
    }

    public int findMin(PriorityQueue<Integer> priorityQueue, int[] n)
    {

        return 0;
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(10));;
        for (int i = 1; i <= 14; i++)
        {
            System.out.println(uglyNumberII.nthUglyNumber(i));;
        }
    }

}
