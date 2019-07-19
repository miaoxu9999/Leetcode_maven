package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTreePreorderTraversal
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/30 15:39
 * @Version 1.0
 **/
public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        return res;

    }

    public TreeNode traverse(List<Integer> res, TreeNode node)
    {
        if (node != null)
        {
            res.add(node.val);
            //遍历左子树
            traverse(res, node.left);
            traverse(res, node.right);

        }
        return null;
    }

}
