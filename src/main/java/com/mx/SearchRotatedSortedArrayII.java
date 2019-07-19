package com.mx;

import java.util.Arrays;

/**
 * @ClassName SearchRotatedSortedArrayII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/23 20:51
 * @Version 1.0
 **/
public class SearchRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {

        return searchAll(nums, 0, nums.length - 1, target);

    }

    public boolean searchAll(int[] nums, int i, int j, int target)
    {
        if (i < 0 || j < 0 || i >= nums.length || j >= nums.length)
        {
            return false;
        }
        int start = i;
        int end = j;
        int mid = (start + end) / 2;
        while (start < end)
        {
            if (nums[mid] == target)
            {
                return true;
            }
            if (nums[mid] < nums[end]) //递增数组
            {
                if (nums[end] >= target)
                {
                    if (!check(mid + 1,nums))
                    {
                        return Arrays.binarySearch(nums, mid + 1, end + 1, target) >= 0;
                    }
                    return false;
                }
                else
                {
                    return searchAll(nums, start, mid - 1, target);
                }
            }
            else // 此时，从start到mid之间是递增的
            {
                if (nums[mid] >= target)
                {
                    if (mid > start)
                    {
                        return Arrays.binarySearch(nums, start, mid + 1, target) != - 1;
                    }
                    else
                    {
                        return nums[start + 1] == target;
                    }
                }
                else
                {
                    return searchAll(nums, mid + 1, end,target);
                }
            }

        }
        return nums[start] == nums[end];
    }

    public boolean check(int i, int[] nums)
    {
        if (i < 0 || i >= nums.length )
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] n = {2,5,6,0,0,1,2};
        int[] n = {3, 1};
        System.out.println(new SearchRotatedSortedArrayII().search(n, 1)
        );
    }
}
