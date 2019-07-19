package com.mx;

/**
 * @ClassName RemoveDuplicatesfromSortedListII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/28 11:21
 * @Version 1.0
 **/
public class RemoveDuplicatesfromSortedListII {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode deleteDuplicates(ListNode head) {
          if (head == null)
          {
              return head;
          }
          // 找到一个不重复的节点作为根节点，根节点为head节点
        head = findDistinct(head);

          //保存一个唯一的节点
        ListNode distinctNode = head.next;
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode != null)
        {
            curNode = findDistinct(curNode);

            preNode.next = curNode;
            preNode = curNode;
            if (curNode == null)
            {
                break;
            }
            curNode = curNode.next;
        }
        // 当前节点
        // 唯一节点和当前节点相同，将唯一节点回退到前一个唯一节点


        return head;

    }

    public ListNode findDistinct(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        int val = head.val;
        ListNode cur = head.next;
        while (cur != null)
        {
            if (cur.val != val)
            {
                return head;
            }
            else
            {
                //当前的head和cur值相同，都不能作为重复的
                // 做一个循环
                ListNode prev = cur;
                cur = cur.next;
                while (cur != null)
                {
                    if (prev.val == cur.val)
                    {
                        cur = cur.next;
                    }
                    else
                    {
                        break;
                    }
                }

                //确保当前的cur和head不一致
                head = findDistinct(cur);
                return head;
            }
        }

        return head;
    }

    public void test()
    {
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(1);
//        ListNode l3 = new ListNode(1);
//        ListNode l4 = new ListNode(2);
//        ListNode l5 = new ListNode(3);
//
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        deleteDuplicates(l1);
    }

    public static void main(String[] args) {
        new RemoveDuplicatesfromSortedListII().test();
    }
}
