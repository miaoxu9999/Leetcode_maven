package com.mx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Permutations
 * @Description 46. Permutations
 * @Author miaoxu
 * @Date 2019/9/25 23:25
 * @Version 1.0
 **/
public class Permutations {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums.length < 1){
            return res;
        }
        getPermutation(nums, new boolean[nums.length], 0, new ArrayList<Integer>());

        return res;
    }

    private void getPermutation(int[] nums, boolean[] visited, int index, ArrayList<Integer> list) {
        if (index == visited.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                getPermutation(nums,visited, index + 1, list );
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums.length < 1){
            return res;
        }
        Arrays.sort(nums);
        getPermutationUnique(nums, new boolean[nums.length], 0, new ArrayList<Integer>());

        return res;
    }

    private void getPermutationUnique(int[] nums, boolean[] visited, int index, ArrayList<Integer> list) {
        if (index == visited.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                    continue;
                }
                else
                {
                    visited[i] = true;
                    list.add(nums[i]);
                    getPermutationUnique(nums,visited, index + 1, list );
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] n = {1, 1, 1};
        System.out.println(new Permutations().permuteUnique(n));
    }
}
