package com.mx;

import java.util.Arrays;

/**
 * @ClassName SearchRotatedSortedArray
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/31 14:02
 * @Version 1.0
 **/
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
        {
            return nums[0] == target?0:-1;
        }
        // 双指针
        // [left, right]的范围搜索
        int left = 0;
        int right = nums.length - 1;
        while (left < right)
        {
            if (nums[left] == target)
            {
                return left;
            }
            if (nums[right] == target)
            {
                return right;
            }
            // 如果nums[left] < nums[right],有序数组，二分查找
            if (nums[left] < nums[right]) {
                int i = Arrays.binarySearch(nums, left, right, target);
                return i>= 0?i:-1;
            }
            // target 》 nums[left]，left 左移
            if (target > nums[left])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return -1;
    }



//    public boolean search(int[] nums, int target) {
//        if (nums.length == 1)
//        {
//            return nums[0] == target;
//        }
//        // 双指针
//        // [left, right]的范围搜索
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right)
//        {
//            if (nums[left] == target)
//            {
//                return true;
//            }
//            if (nums[right] == target)
//            {
//                return true;
//            }
//            // 如果nums[left] < nums[right],有序数组，二分查找
//            if (nums[left] < nums[right]) {
//                int i = Arrays.binarySearch(nums, left, right, target);
//                return i>= 0;
//            }
//            // target 》 nums[left]，left 左移
//            if (target > nums[left])
//            {
//                left++;
//            }
//            else
//            {
//                right--;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[]n = {4,5,6,7,0,1,2};
        System.out.println(new SearchRotatedSortedArray().search(n, 10));;

    }
}
