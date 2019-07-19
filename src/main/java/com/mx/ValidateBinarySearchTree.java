package com.mx;

/**
 * @ClassName ValidateBinarySearchTree
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/30 22:10
 * @Version 1.0
 **/
public class ValidateBinarySearchTree {
    int maxCount = 0;
    int minCount = 0;
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public boolean isValidBST(TreeNode root) {
         if (root == null || (root.left == null && root.right == null))
        {
            return true;
        }
         return isVaildTree(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean isVaildTree(TreeNode node, Long min, Long max)
    {
        if (node == null )
        {
            return true;
        }
        if (node.left != null)
        {
            if (node.val <= node.left.val)
            {
                return false;
            }
        }
        if (node.right != null)
        {
            if (node.val >= node.right.val)
            {
                return false;
            }
        }
        if (node.val == Integer.MAX_VALUE)
        {
            maxCount++;
        }
        if (node.val == Integer.MIN_VALUE)
        {
            minCount++;
        }
        if ((node.val <= min || node.val >= max))
        {
            if ((node.val == Integer.MIN_VALUE && minCount == 1) || (node.val == Integer.MAX_VALUE && maxCount == 1))
            {

            }
            else
            {
                return false;
            }

        }
        //左子树是否有效
        boolean left = isVaildTree(node.left, min, new Long(node.val));
        boolean right = isVaildTree(node.right, new Long(node.val), max);
        return left && right;
    }

    public void test()
    {
        TreeNode n1 = new TreeNode(2147483647);
        TreeNode n2 = new TreeNode(-2147483648);
        n1.right = n2;
//        n1.left = n2;
        isValidBST(n1);
    }

    public static void main(String[] args) {
        new ValidateBinarySearchTree().test();
    }
}
