package com.mx;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MaximumDifferenceBetweenNodeandAncestor
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/14 11:07
 * @Version 1.0
 **/
public class MaximumDifferenceBetweenNodeandAncestor {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public int maxAncestorDiff(TreeNode root) {
         //查找所有叶子节点
        //对比所有节点和叶子节点的大小关系
        List<Integer> res = new ArrayList<Integer>();
        //查找当前节点的所有叶子节点，获取最大差距
        return sub_maxAncestorDiff(root);

    }

    public int sub_maxAncestorDiff(TreeNode node)
    {
        List<Integer> res = new ArrayList<Integer>();
        findAllLeaves(node, res);
//        findAllGuaidian(node, res);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res.size(); i++)
        {
            max = Math.max(Math.abs(res.get(i) - node.val), max);
        }
        if (notLeaf(node.left))
        {

            max = Math.max(sub_maxAncestorDiff(node.left), max);
            max = Math.max(Math.abs(node.left.val - node.val), max);
        }
        if (notLeaf(node.right))
        {
            max = Math.max(sub_maxAncestorDiff(node.right), max);
            max = Math.max(Math.abs(node.right.val - node.val), max);
        }

        return max;
    }

    public boolean notLeaf(TreeNode node)
    {
        if (node != null && !(node.left == null && node.right == null))
        {
            return true;
        }
        return false;
    }

    public void findAllLeaves(TreeNode node,  List<Integer> res)
    {
        if(node == null)
        {
            return;
        }
        if (node != null && (node.left == null && node.right == null))
        {
            res.add(node.val);
            return;
        }
        if (node != null && (node.left == null || node.right == null))
        {
            res.add(node.val);
        }
        //找到左子树的所有叶子节点
        findAllLeaves(node.left, res);
        //找到右子树的所有叶子节点
        findAllLeaves(node.right, res);
    }



    public void test()
    {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        node1.right  = node2;
        maxAncestorDiff(node1);
    }

    public static void main(String[] args) {
        new MaximumDifferenceBetweenNodeandAncestor().test();
    }
}
