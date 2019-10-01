package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CombinationSumIII
 * @Description 216. Combination Sum III
 * @Author miaoxu
 * @Date 2019/10/1 17:12
 * @Version 1.0
 **/
public class CombinationSumIII {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if (n > 55 || k < 1 || k > 9){
            return res;
        }
        helper(1, k, n, new ArrayList<Integer>());



        return res;
    }

    // 从index开始，获取可能的组合
    private void helper(int start, int k, int n, ArrayList<Integer> list) {
        if (n < 0){
            return;
        }
        if (list.size() == k){
            if (n == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i <= 9 ; i++) {
            list.add(i);
            helper(i + 1, k, n - i, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        new CombinationSumIII().combinationSum3(3, 7);
        new CombinationSumIII().combinationSum3(3, 9);
    }
}
