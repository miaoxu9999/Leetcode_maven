package com.mx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * @ClassName RemoveElement
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/25 17:59
 * @Version 1.0
 **/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        //[0,i]和val不同
        int i = 0;
        int count = 0;
        while (i < nums.length)
        {
            if (nums[i] == val)
            {
                boolean f = swap(i, nums);
                if (!f)
                {
                   i++;
                }

            }
            else
            {
                i++;
                count++;
            }
        }
        return count;
    }

    public boolean swap(int i, int[] nums)
    {
        int key = nums[i];
        int j = i + 1;
        while (j < nums.length)
        {
            if (nums[j] != key)
            {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                return true;
            }
            j++;
        }


        return false;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        //遍历字符串数组，对数组中的内容进行排序，加入hash表中
        //如果存在hash表中，加入对应的结果中
        //不存在创建一个新的list
        int count = 0;
//        Hashtable<Character[], Integer> hashtable = new Hashtable<>();
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++)
        {
            String temp = sort(strs[i]);
            if (hashtable.containsKey(temp))
            {
                int index = hashtable.get(temp);
                res.get(index).add(strs[i]);
            }
            else
            {
                List<String> list = new ArrayList<>();
                hashtable.put(temp,count);
                count++;
                list.add(strs[i]);
                res.add(list);
            }
        }

        return res;
    }

    public  String sort(String str){
        //利用toCharArray可将字符串转换为char型的数组
        char[] s1 = str.toCharArray();
        Arrays.sort(s1);
        //再次将字符数组转换为字符串，也可以直接利用String.valueOf(s1)转换
        String st = new String(s1);
        return st;
    }

    public static void main(String[] args) {
        int[] n = {3,2,2,3};
        new RemoveElement().removeElement(n, 3);
        System.out.println("BANC".contains("ABC"));
    }
}
