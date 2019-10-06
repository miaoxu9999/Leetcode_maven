package com.mx;

import java.util.Arrays;

/**
 * @ClassName PlaywithChips
 * @Description leetcode 周赛，1217. Play with Chips
 * @Author miaoxu
 * @Date 2019/10/6 11:41
 * @Version 1.0
 **/
public class PlaywithChips {
    public int minCostToMoveChips(int[] chips) {
        if (chips.length < 1){
            return 0;
        }

        int odd = 0;
        int jishu = 0;

        for (int i = 1; i < chips.length; i++) {
            if (chips[i] % 2 == 0){
                odd++;
            }
            else {
                jishu++;
            }

        }


        return Math.min(jishu, odd);

    }

    public static void main(String[] args) {
//        int[] c = {1,2,3};
//        int[] c = {2,2,2,3,3};
        int[] c = {1,2,2,2,2};
        System.out.println( new PlaywithChips().minCostToMoveChips(c));;
    }
}
