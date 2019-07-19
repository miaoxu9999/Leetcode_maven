package com.mx;

/**
 * @ClassName ConvertSortedArraytoBinarySearchTree
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/9 20:34
 * @Version 1.0
 **/
public class ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
        {
            return null;
        }
        return constructTree(nums, 0, nums.length );

    }
    //start闭区间
    //end开区间
    public TreeNode constructTree(int[] nums, int start, int end)
    {
        if (end - start == 1)
        {
            return new TreeNode(nums[start]);
        }
        if (end == start)
        {
            return null;
        }
        //查找根节点
        int len = end - start;
        int halfIndex = start + len / 2;
        int val = nums[halfIndex];
        TreeNode node = new TreeNode(val);
        //构建左子树
        TreeNode left = constructTree(nums, start, halfIndex);
        //构建右子树
        TreeNode right= constructTree(nums, halfIndex + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}
