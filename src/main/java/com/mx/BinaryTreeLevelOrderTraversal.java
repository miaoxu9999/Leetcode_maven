package com.mx;

import java.util.*;

/**
 * @ClassName BinaryTreeLevelOrderTraversal
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/30 22:32
 * @Version 1.0
 **/
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
        {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //每一层进入队列，null，代表当前层结束
        queue.offer(root);
        TreeNode flag = new TreeNode(-1);
        queue.offer(flag);
        List<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.val != Integer.MAX_VALUE) {
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            else // 当前层结束
            {
                res.add(list);
                list = new ArrayList<>();
                if (queue.size() > 0)
                {
                    TreeNode node1 = new TreeNode(-1);
                    queue.offer(node1);
                }
            }
        }
        return res;
    }

    public void test()
    {
        Queue<TreeNode> queue = new PriorityQueue<>();
        TreeNode node = new TreeNode(-1);

        System.out.println(queue.size());
        levelOrder(node);
    }

    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal().test();

    }
}
