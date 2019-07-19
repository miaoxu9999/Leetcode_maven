package com.mx;

/**
 * @ClassName AddTwoNumbers
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/6/12 10:25
 * @Version 1.0
 **/
public class AddTwoNumbers {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位数字
        int jinwei = 0;
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        node1.next = l1;
        node2.next = l2;
        ListNode resHead = new ListNode(0);
        ListNode cur = resHead;
        int n1, n2, sum;
        while (node1 != null || node2!= null)
        {
            sum = jinwei;
            if (node1 !=null)
            {
                n1 = node1.val;
                sum += n1;
                node1 = node1.next;
            }
            if (node2 != null)
            {
                n2 = node2.val;
                sum += n2;
                node2 = node2.next;
            }
            if (sum >= 10)
            {
                jinwei = 1;
                sum -= 10;
            }
            else
            {
                jinwei = 0;
            }
            ListNode newNode = new ListNode(sum);
            cur.next = newNode;
            cur  = newNode;
        }
        if (jinwei != 0)
        {
            ListNode newNode = new ListNode(jinwei);
            cur.next = newNode;
            cur = newNode;
        }

        return resHead.next;



    }
}
