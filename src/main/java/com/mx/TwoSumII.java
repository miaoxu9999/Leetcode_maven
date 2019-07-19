package com.mx;

/**
 * @ClassName TwoSumII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/25 8:49
 * @Version 1.0
 **/
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {0,0};
        //l和r是两个指针, l < r
        int l = 0, r = numbers.length - 1;
        while (l < r)
        {
            if (numbers[l] + numbers[r] == target)
            {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
            else if (numbers[l] + numbers[r] < target)
            {
                l++;
            }
            else
            {
                r++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println("sdfsafsa".substring("sd".length()));
    }
}
