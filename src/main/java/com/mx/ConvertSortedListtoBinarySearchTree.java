package com.mx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ConvertSortedListtoBinarySearchTree
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/3 11:00
 * @Version 1.0
 **/

public class ConvertSortedListtoBinarySearchTree {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode sortedListToBST(ListNode head) {
          if (head == null)
          {
              return null;
          }
        //将所有list的节点放入list中
        List<Integer> list = new ArrayList<>();
        while (head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        TreeNode root = constructTree(list, 0, list.size());
       return root;
    }

    //start闭区间
    //end闭区间

    public TreeNode constructTree(List<Integer> list, int start, int end)
    {
        if (end - start == 1)
        {
            return new TreeNode(list.get(start));
        }
        if (end == start)
        {
            return null;
        }
        //查找根节点
        int len = end - start;
        int halfIndex = start + len / 2;
        int val = list.get(halfIndex);
        TreeNode node = new TreeNode(val);
        //构建左子树
        TreeNode left = constructTree(list, start, halfIndex);
        //构建右子树
        TreeNode right= constructTree(list, halfIndex + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }

    public void test()
    {
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        sortedListToBST(l1);

    }

    public static void main(String[] args) {
        new ConvertSortedListtoBinarySearchTree().test();
    }
}
