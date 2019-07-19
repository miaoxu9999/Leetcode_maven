package com.mx;

/**
 * @ClassName ReverseLinkedListII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/2 22:24
 * @Version 1.0
 **/
public class ReverseLinkedListII {
      public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public ListNode reverseBetween(ListNode head, int m, int n) {
          if (head == null)
          {
              return null;
          }
        //创建一个假的head
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        //寻找m - 1所在的位置
        ListNode mPrevious = findNode(fakeHead, m - 1);
        //寻找n所在的位置
        ListNode nNode = findNode(fakeHead, n);
        //将m - n 倒置
        reverse(mPrevious, nNode);
          return fakeHead.next;
    }

    public ListNode findNode(ListNode node, int step)
    {
        int count = 0;
        while (count != step)
        {
            count++;
            node = node.next;
        }
        return node;
    }


    public void reverse(ListNode mPrevious, ListNode nNode)
    {
        ListNode nNext = nNode.next;
        ListNode mNode = mPrevious.next;
        ListNode cur = mNode;
        ListNode node = cur.next;
        while (cur != null && cur != nNode)
        {
            //cur 是当前节点
            // node 是当前节点的下一个节点
            // nodenext 是当前节点的下一个节点的下一个节点
            ListNode nodeNext;
            if (node != null)
            {
                 nodeNext = node.next;
            }
            else
            {
                break;
            }
            node.next = cur;
            cur = node;
            node = nodeNext;

        }
        mPrevious.next = cur;
        mNode.next = nNext;

    }

    public void test()
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        reverseBetween(l1, 2, 4);

    }

    public static void main(String[] args) {
        new ReverseLinkedListII().test();
    }


}
