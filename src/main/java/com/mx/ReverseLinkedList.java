package com.mx;

/**
 * @ClassName ReverseLinkedList
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/12 9:34
 * @Version 1.0
 **/
public class ReverseLinkedList {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public ListNode reverseList(ListNode head) {
        if (head == null)
        {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!= null )
        {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null)
            next = next.next;
        }

        return cur;

    }
}
