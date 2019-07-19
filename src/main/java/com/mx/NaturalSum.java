package com.mx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName NaturalSum
 * @Description TODO
 * 自然数之和
 * @Author miaoxu
 * @Date 2019/1/3 22:23
 * @Version 1.0
 **/
public class NaturalSum
{
    int[] a = new int[10000];
    int n ,tot;
    int count = 0;
    NaturalSum(int n)
    {
        Arrays.fill(a,1);
        this.n = n;
    }
    public void dfs(int p,int q)
    {
        int i;
        for(i=a[q-1];i<=p;i++)
        {
            if(i<n)
            {
                a[q]=i;
                p-=i;
                if(p==0)print(q);
                else
                {
                    dfs(p,q+1);
                }
                p+=i;
            }
        }
    }

    public void print(int j)
    {
        tot++;
        System.out.println("=" + n);
        for(int i=1;i<=j;i++)
        {
            if(i!=j)
            {
                System.out.print(a[i] + "+");
            }
            else
            {
                System.out.print(a[i]);
            }
        }
    }
    public List<List<Integer>> subset(int[] n)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(n);
//        dfs_subsets(0, new ArrayList<Integer>(), n, res);
//        backtracking(res, n, new ArrayList<Integer>(), 0);
        dfsSubsets(n, 0, new ArrayList<Integer>(), res);
        return  res;
    }
    private void dfsSubsets(int[] num, int start, ArrayList<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        for (int i = start; i < num.length; i++) {
            list.add(num[i]);
            dfsSubsets(num, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public void backtracking(List<List<Integer>> result,int nums[],List<Integer> list,int start) {
        result.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;//跳过重复的
            list.add(nums[i]);
            backtracking(result, nums, list, i+1);
            list.remove(list.size()-1);

        }
    }
    public void dfs_subsets(int step, List<Integer> tem, int[] n, List<List<Integer>> res)
    {
        res.add(new ArrayList<Integer>(tem));
        for (int i = step; i < n.length; i++)
        {
            //

            if (i > step && n[i] == n[i - 1] )
            {
                continue;
            }
            tem.add(n[i]);
            dfs_subsets(i + 1, tem, n, res);
            tem.remove(tem.size() - 1);



        }
    }

    public void  total_sum_way(int target)
    {
        //计算从1到target - 1，一共有多少种方式
        dfs_sum(target, 1, 7);
    }

    public void dfs_sum(int target, int step, int n)
    {
//        if (target == 0)
//        {
//            //输出当前的方案
//            print_all(step - 1, target + 7);
//            return;
//        }
        for (int i =a[step - 1]; i <= target; i++)
        {
//            if (i < n)
//            {
                target = target - i;
                int temp = a[step];
                a[step] = i;
                if (target == 0)
                {
                    //输出当前的方案
                    print_all(step, target + 7);
                }
                else
                {
                    dfs_sum(target, step + 1, n);
                }
                target = target + i;
                a[step] = temp;
//            }


        }
    }

    public void print_all(int step, int target)
    {
        for (int i = 1; i <= step; i++)
        {
            System.out.print(a[i]);
            if (i == step )
            {
                System.out.print("=");
            }
            else
            {
                System.out.print("+");
            }
        }
        System.out.print(target + "   总数为");
        System.out.println(++this.count);

    }

    public int print_total(int target, int[] a)
    {
        if (a[target] != 0)
        {
            return a[target];
        }
        a[target] = print_total(target - 1, a);
        return 0;
    }

    public static void main(String[] args) {
        NaturalSum naturalSum = new NaturalSum(7);
        naturalSum.total_sum_way(7);
        int[] n = {1,  1, 3};
        naturalSum.subset(n);
    }
}
