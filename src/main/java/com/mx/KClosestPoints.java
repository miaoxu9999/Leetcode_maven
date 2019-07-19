package com.mx;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName KClosestPoints
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/6 18:52
 * @Version 1.0
 **/
public class KClosestPoints {
    class Pair implements Comparable<Pair>{
        int num1;
        int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.num1 * this.num1 + this.num2 * this.num2) - (o.num1 * o.num1 + o.num2 * o.num2);
        }
    }
    public int[][] kClosest(int[][] points, int K) {



        Queue<Pair> priorityQueue = new PriorityQueue<Pair>();

        for (int i = 0; i < points.length; i ++)
        {
            priorityQueue.offer(new Pair(points[i][0], points[i][1]));
        }
        K = Math.min(K, priorityQueue.size());
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++)
        {
            Pair pair = priorityQueue.poll();
            res[i] = new int[]{pair.num1, pair.num2};
        }


        return res;
    }

    public static void main(String[] args) {
//        int[][]points = {{1,3},{-2,2}};
        int[][]points = {{3,3},{5,-1},{-2,4}};
        new KClosestPoints().kClosest(points, 2);
    }
}
