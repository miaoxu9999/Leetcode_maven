package com.mx.Alo;

/**
 * @ClassName ReConstructBinaryTree
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/20 15:19
 * @Version 1.0
 **/




public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length <1 || in.length < 1)
        {
            return null;
        }
        //根节点
        TreeNode root = reConstructTree(pre, 0, in, 0, in.length);
        //重构左子树
//        int inend = findRange(in, pre[0], 0);
//        int len = inend + 1; // len是开区间
//        TreeNode leftNode = reConstructTree(pre, 1, in, 0, len);
//        //重构右子树
//        TreeNode rightNode= reConstructTree(pre, len, in, len, in.length + 1 - len);
        //连接左右子树


        return root;

    }

    public int findRange(int[] arr, int target, int start)
    {
        int res;
        for (int i = start; i < arr.length; i++)
        {
            if (arr[i] == target)
            {
                return i;
            }
        }
       return -1;
    }

    public TreeNode reConstructTree(int[] pre, int prestart, int[] in ,int instart, int len)
    {
        if (len== 0)
        {
            return null;
        }
        if (len == 1)
        {
            return new TreeNode(pre[prestart]);
        }
        TreeNode node = new TreeNode(pre[prestart]);

        int end = findRange(in, node.val, instart);
        int len1 = end - instart;
//        if (len1 <= 0)
//        {
//            return new TreeNode(pre[prestart]);
//        }
        //按照end区分左右子树
        TreeNode leftNode = reConstructTree(pre, prestart + 1 , in, instart, len1);
        TreeNode rightNode = reConstructTree(pre, prestart + 1 + len1, in, end + 1, len - 1- len1);
        node.left = leftNode;
        node.right = rightNode;

        return node;



    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
    }

//    public TreeNode reConstructRightTree(int[] pre, int prestart, int[] in , int instart, int len)
//    {
//        TreeNode node = new TreeNode(pre[prestart]);
//
//        return node;
//    }
}
