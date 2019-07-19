package com.mx;

import java.util.*;

/**
 * @ClassName MergeIntervals
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/27 10:11
 * @Version 1.0
 **/
public class MergeIntervals {
             class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1)
        {
            return null;
        }
        // 所有Interval 排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int i = 1;// 第i个interval,从[1,len - 1]
        List<Interval> res = new ArrayList<>();
        // 如果start2 < end1，合并
        while (i < intervals.size())
        {
            int end1 = intervals.get(i - 1).end;
            int start1 = intervals.get(i - 1).start;

            int end2 = intervals.get(i).end;
            int start2 = intervals.get(i ).start;
            if (start2 < end1)
            {
                res.add(new Interval(start1, Math.max(end1, end2)));
            }
            else
            {
                res.add(new Interval(start1, end1));
                res.add(new Interval(start2, end2));
            }
        }

        return res;

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1)
        {
            return new int[0][0];
        }
        if (intervals.length == 1)
        {
            return intervals;
        }
        // 所有Interval 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 1;// 第i个interval,从[1,len - 1]
        List<Interval> res = new ArrayList<>();
        res.add(new Interval(intervals[0][0],intervals[0][1]));
        // 如果start2 < end1，合并
        while (i < intervals.length)
        {
            int end1, start1;
            end1 = res.get(res.size() - 1).end;
            start1 = res.get(res.size() - 1).start;
            res.remove(res.size() - 1);
            int end2 = intervals[i ][1];
            int start2 = intervals[i ][0];
            if (start2 <= end1)
            {
                res.add(new Interval(start1, Math.max(end1, end2)));
            }
            else
            {
                res.add(new Interval(start1, end1));
                res.add(new Interval(start2, end2));
            }
            i++;
        }
        int[][]res1 = new int[res.size()][2];
        i = 0;
        while (i < res.size())
        {
            Interval interval = res.get(i);
            res1[i][0] = interval.start;
            res1[i][1] = interval.end;
            i++;
        }
        return res1;

    }

    public static void main(String[] args) {
        int[][] n = {{1,4},{0,2},{3,5}};
//        int[][] n = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        new MergeIntervals().merge(n);
    }
}
