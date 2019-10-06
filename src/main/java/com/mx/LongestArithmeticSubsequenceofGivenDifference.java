package com.mx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LongestArithmeticSubsequenceofGivenDifference
 * @Description 1218. Longest Arithmetic Subsequence of Given Difference
 * @Author miaoxu
 * @Date 2019/10/6 10:58
 * @Version 1.0
 **/
public class LongestArithmeticSubsequenceofGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        if (arr.length < 2 ){
            return arr.length;
        }
       int[] dp = new int[arr.length];
        // 存储的数字以及对应的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.fill(dp, 1);
        int res = 1;
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >=0 ; j--) {
//                if (arr[i] - arr[j] == difference){
//                    dp[i] = dp[j] + 1;
//                    res = Math.max(res, dp[i]);
//                    break;
//                }
//            }
//        }
        for (int i = 1; i < arr.length; i++) {
            if (map.containsKey(arr[i] - difference)){
                int index = map.get(arr[i] - difference);
                dp[i] = dp[index] + 1;
                res = Math.max(res, dp[i]);
            }
            map.put(arr[i], i);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] a = {1,5,7,8,5,3,4,2,1};
        new LongestArithmeticSubsequenceofGivenDifference().longestSubsequence(a, -2);
    }

}
