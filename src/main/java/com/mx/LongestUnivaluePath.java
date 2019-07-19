package com.mx;

/**
 * @ClassName LongestUnivaluePath
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/14 15:14
 * @Version 1.0
 **/
public class LongestUnivaluePath {
            public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public int longestUnivaluePath(TreeNode root) {
        // 判断左子树的最大值
        // 判断右子树的最大值
        if (root == null)
        {
            return 0;
        }
       return helper(root, 0);

    }

    public int helper(TreeNode node, int max)
    {
        if (node == null)
        {
            return max;
        }
        int t = node.val;
        int left = helper(node.left, max);

        return 0;



    }
}

