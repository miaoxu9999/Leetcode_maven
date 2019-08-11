package com.mx;

import com.mx.util.RandomTwoArray;

import java.util.Arrays;

/**
 * @ClassName RussianDollEnvelopes
 * @Description 能够容纳的最大的娃娃，dp解法
 * @Author miaoxu
 * @Date 2019/8/11 15:05
 * @Version 1.0
 **/
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length <= 0)
        {
            return 0;
        }
        int res = 1;
        Arrays.sort(envelopes, (int[]a, int[] b) -> b[0] - a[0]);

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int[] pre = envelopes[0];
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (fit(envelopes[i], envelopes[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }

            }
        }
        return res;
    }

    private boolean fit(int[] pre, int[] envelope) {
        if (pre[0] < envelope[0] && pre[1] < envelope[1]){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] n = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(n));
//        System.out.println( RandomTwoArray.replace("[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]"));;
    }


}
