package com.mx;

import java.util.Arrays;

/**
 * @ClassName TreefromInorderandPostorderTraversal
 * @Description
 * 根据中序遍历和后序遍历获得完整的二叉树
 * @Author miaoxu
 * @Date 2019/4/27 11:20
 * @Version 1.0
 **/
public class TreefromInorderandPostorderTraversal {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          if (inorder == null || inorder.length == 0)
          {
              return null;
          }
          return constructTree(inorder, postorder, 0, 0, inorder.length);
          // 后序遍历的最后一个节点是根节点
//        int root = findRootInPostorder(postorder, 0, postorder.length);
//        //找到根节点在inorder中的位置
//        int rootIndex = findRootInInorder(inorder, root);
//        // 将inorder中的节点按照根节点划分
//        TreeNode left = null;
//        TreeNode right = null;
//        //构造左子树
//        if (rootIndex > 0)
//        {
//            left = constructTree(inorder, postorder, rootIndex - 1,rootIndex -  1, rootIndex);
//        }
//        //构造右子树
//        if (rootIndex < inorder.length - 1)
//        {
//            right = constructTree(inorder, postorder, rootIndex + 1, rootIndex,inorder.length - (rootIndex + 1));
//        }
//
//        TreeNode res = new TreeNode(root);
//        res.left = left;
//        res.right = right;
//        return res;

    }

    /**
     * @Author miaoxu
     * @Description
     * 在后序遍历中查找指定范围的根节点
     * start 闭区间
     * end 开区间
     * @Date 11:29 2019/4/27
     * @Param [postorder, start, len]
     * @return int
     **/
    public int findRootInPostorder(int[] postorder, int start, int len)
    {
        return postorder[start + len - 1];
    }

    public int findRootInInorder(int[] inorder, int root)
    {
        for (int i = 0 ; i < inorder.length; i++)
        {
            if (inorder[i] == root)
            {
                return i;
            }
        }
        return -1;
    }

    public int findNodeInPostOrder(int[] postorder, int val)
    {
        for (int i = 0; i < postorder.length; i++)
        {
            if (postorder[i] == val)
            {
                return i;
            }
        }
        return  -1;
    }


    public TreeNode constructTree(int [] inorder, int[] postorder, int startIn, int startPost,int len)
    {
        if (len == 0)
        {
            return null;
        }
        if (len == 1)
        {
            return new TreeNode(inorder[startIn]);
        }

        //查找根节点
        int rootval = findRootInPostorder(postorder , startPost, len);
        int rootInPost = startPost + len - 1;
        TreeNode root = new TreeNode(rootval);
        TreeNode left = null;
        TreeNode right = null;
        //在inorder中查找root节点的位置
        int rootIndex =  findRootInInorder(inorder, rootval);
        //按照rootIndex 对当前的节点进行划分
        int leftlen = rootIndex - startIn;
        int rightLen = startIn + len - 1 - rootIndex;

        int leftInPostEnd = rootInPost - Math.max(rightLen, 0) - 1;
        if (leftlen > 0)
        {
            int leftStartInOrder = startIn;
            int leftStartPostOrder = leftInPostEnd - leftlen + 1;
            left = constructTree(inorder,postorder, leftStartInOrder, leftStartPostOrder, leftlen);
        }
        if (rightLen > 0)
        {
            int rightStartInOrder =  rootIndex + 1;
            int rightStartPostOrder = rootInPost  - rightLen;
            right = constructTree(inorder, postorder, rightStartInOrder, rightStartPostOrder, rightLen);
        }



        root.left = left;
        root.right = right;
        return root;

    }


//    public TreeNode constructTree(int [] inorder, int[] postorder, int startIn, int startPost,int len)
//    {
//        if (len == 0)
//        {
//            return null;
//        }
//        if (len == 1)
//        {
//            return new TreeNode(inorder[startIn]);
//        }
//        // 查找根节点
//        int rootval = findRootInPostorder(postorder , startPost, len);
//        TreeNode root = new TreeNode(rootval);
//
//        //在inorder中查找root节点的位置
//        int rootIndex =  findRootInInorder(inorder, rootval);
//
//        // 将左右子树分开
//        // 将inorder中的节点按照根节点划分
//        TreeNode left = null;
//        TreeNode right = null;
//        //构造左子树
//        if (rootIndex > startIn)
//        {
//            int leftPostIndex = findNodeInPostOrder(postorder, inorder[rootIndex - 1]);
//            left = constructTree(inorder, postorder, rootIndex - 1, leftPostIndex, rootIndex - startIn );
//        }
//        //构造右子树
//        if (rootIndex < startIn + len - 2)
//        {
//            int rightPostIndex = findNodeInPostOrder(postorder, inorder[rootIndex + 1]);
//            if (rightPostIndex )
//            right = constructTree(inorder, postorder, rootIndex + 1, rightPostIndex,len - (rootIndex - startIn + 1));
//        }
//
//        root.left = left;
//        root.right = right;
//        return root;
//    }

    public void test()
    {
//        int [] inorder = {9,3,15,20,7};
//        int [] postorder = {9,15,7,20,3};

//        int [] inorder = {1,2,3};
//        int [] postorder = {3,2,1};

//        int [] inorder = {1,2,3, 4};
//        int [] postorder = {4, 3,2,1};

//        int [] inorder = {1,2,3, 4};
//        int [] postorder = {3,2,4, 1};

        int [] inorder = {1,2,3, 4};
        int [] postorder = {3,2 ,1, 4};

//        int [] inorder = {9,3,15,20,7};
//        int [] postorder = {9,15,7,20,3};


        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }

    public static void main(String[] args) {
        new TreefromInorderandPostorderTraversal().test();
    }
}
