package com.mx;

/**
 * @ClassName FindFirstLastPosition
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/1 16:32
 * @Version 1.0
 **/
public class FindFirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
    //二分查找
        int[] res = {-1, -1};
        if(nums.length < 1)
        {
            return res;
        }
        int low = 0;
        int high = nums.length -1;
        int mid = (low + high)/ 2;
        while (nums[mid] != target && low <= high)
        {
            if (nums[mid] > target)
            {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            else
            {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }
        if (nums[mid] == target)
        {
            res[0] = mid;
            res[1] = mid;
            int j = mid - 1;
            int k = mid + 1;
            while (j >= 0 && nums[j] == target)
            {
                res[0] = j;
                j--;
            }
            while (k < nums.length - 1 && nums[k] == target )
            {
                res[1] = k;
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] n = {5,7,7,8,8,10};
        int[] n = {2,2};
        new FindFirstLastPosition().searchRange(n, 2);
    }
}
