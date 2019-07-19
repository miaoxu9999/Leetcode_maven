package com.mx;

/**
 * @ClassName PartitionList
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/19 12:22
 * @Version 1.0
 **/
public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null)
        {
            return head;
        }
        ListNode fithead = null;
        ListNode fircur = null;
        ListNode lastcur1= null;
        ListNode sechead = null;
        ListNode seccur = null;
        ListNode cur = head;
        while (cur!= null)
        {
            if (cur.val < x)
            {
                if (fithead == null)
                {
                    fithead = cur;
                    fircur = fithead;
                }
                else
                {
                    fircur.next = cur;
                    fircur = cur;
                }
            }
            else
            {
                if (sechead == null)
                {
                    sechead = cur;
                    seccur = sechead;
                }
                else
                {
                    seccur.next = cur;
                    seccur = cur;
                }
            }
            cur = cur.next;
        }
        if (fircur != null)
        {
            fircur.next = sechead;
            seccur.next = null;
            return fithead;
        }
        else
        {
            return sechead;
        }



    }


    public void test()
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        partition(n1, 0);

    }

    public static void main(String[] args) {
        new PartitionList().test();
    }
}
