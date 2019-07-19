package com.mx;

import java.util.PriorityQueue;

/**
 * @ClassName SuperUglyNumber
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/5 20:06
 * @Version 1.0
 **/
public class SuperUglyNumber {
    int count = 0;
//    public int nthSuperUglyNumber(int n, int[] primes) {
//
//        //使用dfs，每走一步，决定最小的是哪一个
//
//        //先放置1，之后放对比怎么乘才能得到最小的
//        int[] res=  new int[n];
//        res[0] = 1;
//        for (int i  =1; i < n; i++)
//        {
//            int pre = res[i - 1];
//            int min = -1;
//            for (int j = 0; j < i ; j++)
//            {
//                for (int k = 0; k < primes.length; k++)
//                {
//                    if (res[j] * primes[k] > pre)
//                    {
//                        if(min == -1)
//                        {
//                            min = res[j] * primes[k];
//                            continue;
//                        }
//                        if (min > res[j] * primes[k])
//                        {
//                            min = res[j] * primes[k];
//                        }
//                        count++;
//                        break;
//                    }
//                }
//                if (count == 10)
//                {
//                    count = 0;
//                    break;
//                }
//
//            }
//            res[i] = min;
//        }
//
//        return res[n- 1];
//
//    }


    public int nthSuperUglyNumberI(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }

    private class Num implements Comparable<Num> {
        int val;
        int idx;
        int p;

        public Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }

        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }

    public int nthSuperUglyNumberHeap(int n, int[] primes) {
        int[] ugly = new int[n];

        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
            }
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        int[] n = {2,7,13,19};

        System.out.println(new SuperUglyNumber().nthSuperUglyNumberHeap(12, n));
    }


}
