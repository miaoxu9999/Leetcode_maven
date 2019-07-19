package com.mx;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReorderList
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/3 14:19
 * @Version 1.0
 **/
public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        //将所有的节点存储到list中

        if (head == null)
        {
            return ;
        }
        //将所有list的节点放入list中
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null)
        {
            list.add(cur.val);
            cur = cur.next;
        }
        if (list.size() == 1)
        {
            return;
        }
        //生成新的链表
        int count = -1;
        int len = list.size();
        ListNode pre = head;
        count++;
        ListNode next = new ListNode(list.get(len - (count + 1)));
        pre.next = next;
        pre = next;
        int end = (len % 2 == 0)?len / 2 -1: len / 2;
        while (count != end)
        {
            count++;
            ListNode node1 = new ListNode(list.get(count));

            ListNode node2 = new ListNode(list.get(len - (count + 1)));
            if (count == len - 1 - count)
            {
                node1.next = null;
            }
            else
            {
                node1.next = node2;
            }
            pre.next = node1;
            pre = node2;
        }

        return;

    }

    public void test()
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
        reorderList(l1);

    }

    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    public ListNode swap(ListNode node)
    {
        if (node == null)
        {
            return null;
        }
        ListNode next = node.next;
        if (next == null)
        {
            return node;
        }
        ListNode nextnext = next.next;
        next.next = node;
        node.next = swap(nextnext);
        return next;
    }

    public static void main(String[] args) {
        new ReorderList().test();
    }

}
