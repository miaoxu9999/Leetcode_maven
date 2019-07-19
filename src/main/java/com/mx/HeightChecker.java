package com.mx;

import java.util.Arrays;

/**
 * @ClassName HeightChecker
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/26 11:00
 * @Version 1.0
 **/
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int count= 0;
        int[] t = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for (int i = 0; i < t.length; i++) {
            if (t[i] != heights[i])
                count++;
        }
        return count;

    }
}
