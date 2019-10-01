package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CombinationsV2
 * @Description 组合问题
 * @Author miaoxu
 * @Date 2019/9/27 20:23
 * @Version 1.0
 **/
public class CombinationsV2 {

    List<List<Integer>> res;
    private int K;
    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();

        K = k;

        getCombination(1, n,new ArrayList<>(), new boolean[n]);

        return res;

    }

    // 从start开始，获取K个数字
    private void getCombination(int start, int n,  ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == K){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n ; i++) {
            if (!visited[i]){
                visited[i] = true;
                list.add(i);
                getCombination(i, n, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }

    }

    private void getCombination(int start, int n,  ArrayList<Integer> list) {
        if (list.size() == K){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n ; i++) {
            list.add(i);
            getCombination(i + 1, n, list);
            list.remove(list.size() - 1);
        }

    }


}
