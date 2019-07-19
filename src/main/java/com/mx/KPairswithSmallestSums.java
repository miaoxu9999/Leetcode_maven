package com.mx;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName KPairswithSmallestSums
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/5 21:10
 * @Version 1.0
 **/
public class KPairswithSmallestSums {

    class Pair implements Comparable<Pair>{
        int num1;
        int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.num1 + this.num2) - (o.num1 + o.num2);
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1)
        {
            return new ArrayList<>();
        }
        PriorityQueue<Pair> pq1 = new PriorityQueue<>();
//        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                pq1.add(new Pair(nums1[i], nums2[j]));
            }
        }
        List<int[]> res = new ArrayList<>();
        while (k-- > 0 && pq1.size() > 0)
        {
            Pair pair = pq1.poll();
            res.add(new int[]{pair.num1, pair.num2});
        }

        return res;



    }


//    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k)
//    {
//        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1)
//        {
//            return new ArrayList<>();
//        }
//        List<int[]> res = new ArrayList<>();
//        int l2 = nums2.length;
//        int[] idx = new int[l2];
//        for (int i = 0 ; i < l2; i++)
//        {
//            idx[i] = i;
//        }
//        k = Math.min(k, nums1.length * l2);
//        int temp  =0;
//        while (k-- > 0)
//        {
//
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < nums1.length; i++)
//            {
//                if (idx[i] < l2 && min > nums1[i] + nums2[idx[i]])
//                {
//                    min =  nums1[i] + nums2[idx[i]];
//                    temp = i;
//                }
//
//            }
//            res.add(new int[]{nums1[temp] ,nums2[idx[temp]]});
//            idx[temp]++;
//        }
//
//        return res;
//
//    }


    public static void main(String[] args) {
//        int[] nums1 = {1,7,11};
//
//        int[] num2 = {2,4,6};


        int[] nums1 = {1,1,2};

        int[] num2 = {1,2,3};
        new KPairswithSmallestSums().kSmallestPairs(nums1, num2, 6);
    }

}
