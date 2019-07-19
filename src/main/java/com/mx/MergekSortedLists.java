package com.mx;

/**
 * @ClassName MergekSortedLists
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/1/26 9:40
 * @Version 1.0
 **/
public class MergekSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        //两两合并
        ListNode res = null;
        for (int i = 0; i < lists.length ; i++)
        {
           res = merge(res, lists[i]);
        }
        return res;
    }


    public ListNode merge(ListNode res, ListNode l)
    {
        if (res == null)
        {
            return l;
        }
        if (l == null)
        {
            return res;
        }
        ListNode ltemp = l;
        ListNode rtemp = res;
        ListNode r = null;
        while (ltemp != null && rtemp != null)
        {
            if (ltemp.val < rtemp.val)
            {
                if (r == null)
                {
                    r = ltemp;
                    res = ltemp;
                }
                else
                {
                    r.next = ltemp;
                    r = ltemp;

                }
                ltemp = ltemp.next;
            }
            else
            {
                if (r == null)
                {
                    r = rtemp;
                    res = rtemp;
                }
                else
                {
                    r.next = rtemp;
                    r = rtemp;
                }
                rtemp = rtemp.next;
            }
        }

    if (ltemp == null)
    {
        if (rtemp != null)
        {
            r.next = rtemp;
        }
    }
    if (rtemp == null)
    {
        if (ltemp != null)
        {
            r.next = ltemp;
        }
    }
    return res;
    }

    public void test()
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = new ListNode(1);

        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;
        merge(n1, n4);

    }
    public static void main(String[] args) {
        new MergekSortedLists().test();
    }
}
