package com.mx;

import java.util.Arrays;

/**
 * @ClassName KthLargestElement
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/5 19:48
 * @Version 1.0
 **/
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] n = {3,2,1,5,6,4};
        System.out.println(new KthLargestElement().findKthLargest(n, 2));
    }



}
