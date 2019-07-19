package com.mx;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName NextPermutation
 * @Description TODO
 * @Author miaoxu
 * @Date 2018/12/21 16:15
 * @Version 1.0
 **/
public class NextPermutation {
    class IndexValue implements Comparable<IndexValue>
    {
        int index;
        int val;
        IndexValue(int index, int val)
        {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(IndexValue o) {
            return this.val - o.val;
        }
    }
    public void nextPermutation(int[] nums) {
        List<IndexValue> indexValueList = new ArrayList<>();
        int min = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        //从后往前遍历，使用一个栈存储
        int i;
        int cur = nums[nums.length - 1];
        for(i = nums.length  - 1; i >= 0; i--)
        {
             cur = nums[i];
            indexValueList.add(new IndexValue(i, cur));
            if (max > cur)
            {
                break;
            }
            if (min > cur)
            {
                min = cur;

            }
            else if (max < cur)
            {
                max = cur;
            }
        }


        //排序，找到和比当前的数字大一点的数字
        Collections.sort(indexValueList);
        if (max == nums[0] && i==-1)
        {
            for (int j = 0; j < nums.length; j++)
            {
                nums[j] = indexValueList.get(j).val;
            }
        }
        else
        {
            for (int k = 0; k < indexValueList.size(); k++)
            {
                IndexValue value = indexValueList.get(k);
                if (value.val > cur)
                {
                    //交换两个数字
                    int a = value.val;
                    nums[value.index] = nums[i];
                    nums[i] = a;
                    indexValueList.remove(k);
                    //剩下的数字按照最小的顺序
                    for (int m = i + 1, n = 0; m < nums.length; m++)
                    {
                        nums[m]= indexValueList.get(n).val;
                        n++;
                    }
                    break;
                }
            }
        }
        for (i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }

    }

    public static void main(String[] args) {
//        int [] n = {1,2, 3,4};
//        int [] n = {3,2,1};
        int [] n = {3,5, 6,1};
//        int [] n = {1,1,5};
//        int [] n = {2,2,3,4,2,3,1,1,2};
//        int [] n = {1,3,2};
        new NextPermutation().nextPermutation(n);
    }
}
