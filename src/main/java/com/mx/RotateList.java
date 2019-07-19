package com.mx;

/**
 * @ClassName RotateList
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/19 9:09
 * @Version 1.0
 **/
public class RotateList {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

//    public ListNode rotateRight(ListNode head, int k) {
//         if (head == null)
//         {
//             return null;
//         }
//         //使用双指针
//        ListNode cur = head;
//        ListNode p = head;
//        //移动k + 1步，
//        for (int i= 0; i < k + 1; i++)
//        {
//
//            p = p.next;
//            if (p == null)
//            {
//                p = head;
//            }
//
//
//
//        }
//        //当前的p是新的链表的起点
//        ListNode newstart = p;
//        cur = p;
//        //查找终点所在的位置
//        while (cur.next != null)
//        {
//            cur = cur.next;
//        }
//        ListNode tail = cur;
//        tail.next = head;
//        cur = head;
//        while (cur.next != newstart)
//        {
//            cur = cur.next;
//        }
//        cur.next = null;
//        return newstart;
//
//    }

    public ListNode rotateRight(ListNode head, int k)
    {

        if (head == null || k == 0)
        {
            return head;
        }
        //使用双指针
        ListNode cur = head;
        while (MoveK(cur, k, head) != null)
        {
            cur = cur.next;
        }
        ListNode newstart = cur;
        cur = head;

        //查找终点所在的位置
        while (cur.next != null)
        {
            cur = cur.next;
        }
        ListNode tail = cur;
        tail.next = head;
        cur = head;
        while (cur.next != newstart)
        {
            cur = cur.next;
        }
        cur.next = null;

        return newstart;
    }

    public ListNode MoveK(ListNode node, int k, ListNode head)
    {
        //从cur开始偏移，直到cur + k是head
        ListNode cur = node;
        for (int i = 0 ; i < k ;i++)
        {

            if (cur == null)
            {
                cur = head;
            }
            cur = cur.next;


        }
        return cur;
    }


    public ListNode partition(ListNode head, int x) {
         if (head == null)
         {
             return head;
         }
        ListNode fithead = null;
        ListNode fircur = null;
        ListNode sechead = null;
        ListNode seccur = null;
        ListNode cur = head;
        while (cur.next != null)
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
                }
            }
        }
        fircur.next = sechead;
        return fithead;


    }


    public void test()
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        ListNode n6 = new ListNode(4);

        rotateRight(n1, 4);
//        n4.next = n5;
//        n5.next = n6;

    }

    public static void main(String[] args) {
        new RotateList().test();
    }
}
