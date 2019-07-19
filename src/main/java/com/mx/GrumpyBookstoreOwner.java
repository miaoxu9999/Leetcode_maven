package com.mx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName GrumpyBookstoreOwner
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/26 11:08
 * @Version 1.0
 **/
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 计算所有grumpy为0的总数
        int sum = 0;
//        for (int i = 0; i < grumpy.length; i++) {
//            if (grumpy[i] == 0)
//            {
//                sum += customers[i];
//            }
//        }
        //计算grumpy为1的时候，X步的最大值
        int s = 0; // 滑动的起点，[s, s+ x] grupy的最大值
        int max= 0 ;
        while (s < grumpy.length)
        {
            int t = 0;
            for (int i = 0;  s + i < grumpy.length && i < X ; i++)
            {
                if (grumpy[s + i] == 1)
                {
                    t += customers[s + i];
                }
            }
            if (max < t)
            {
                max = t;
            }
            if (grumpy[s] == 0)
            {
                sum += customers[s];
            }
            s++;
        }
        return max + sum;
    }

    public static void main(String[] args) {
        int[] n1 = {1,0,1,2,1,1,7,5};
        int[] n2 = {0,1,0,1,0,1,0,1};
        new GrumpyBookstoreOwner().maxSatisfied(n1, n2, 3);
        List<String> wordDict = new ArrayList<>();
        Collections.sort(wordDict);
    }
}
