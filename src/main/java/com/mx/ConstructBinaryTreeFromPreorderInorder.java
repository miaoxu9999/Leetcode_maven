package com.mx;

import java.util.Arrays;

/**
 * @ClassName ConstructBinaryTreeFromPreorderInorder
 * @Description TODO
 * 从二叉树的前序和中序遍历构造一个二叉树
 * @Author miaoxu
 * @Date 2018/12/13 16:30
 * @Version 1.0
 **/
public class ConstructBinaryTreeFromPreorderInorder
{
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

          return buildTreeByPreorderInorder(preorder, inorder, inorder.length);

    }

    public TreeNode buildTreeByPreorderInorder(int[] preorder, int[] inorder, int len)
    {
        if (len == 0)
            return null;
        if (len == 1)
        {
            return new TreeNode(preorder[0]);
        }
        int rootvalue = preorder[0];
        TreeNode treeNode = new TreeNode(rootvalue);
        int i = 0;
        while (inorder[i] != rootvalue)
        {
            //i - 1之前的都是root节点的左边节点
            i++;
        }

//        // 找到root的所有左子树的部分
//        int j = 0;
//        while ( i >= 1 && preorder[j] != inorder[i - 1])
//        {
//            // 1-j都是root节点的左子树
//            j++;
//        }
        TreeNode left = buildTreeByPreorderInorder(Arrays.copyOfRange(preorder, 1, 1 + i), Arrays.copyOfRange(inorder, 0, i), i);
        TreeNode right = buildTreeByPreorderInorder(Arrays.copyOfRange(preorder, i + 1, preorder.length ), Arrays.copyOfRange(inorder, i + 1, inorder.length), preorder.length - i - 1);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    public static void main(String[] args) {
        int [] data = {1,2,3,4,5,6,7,8,9};
        int [] newData;
        newData = Arrays.copyOfRange(data, 2, 3);
        for(int i:newData)
            System.out.print(i+" ");
    }
}
