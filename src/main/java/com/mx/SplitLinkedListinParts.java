package com.mx;

/**
 * @ClassName SplitLinkedListinParts
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/14 15:54
 * @Version 1.0
 **/
public class SplitLinkedListinParts {

     public class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }

     }

    public ListNode[] splitListToParts(ListNode root, int k) {
        //求解长度
        ListNode cur = root;
        int count = 0;
        while (cur != null)
        {
            count++;
            cur = cur.next;
        }
        // 数组长度
        int len = count / k;
        ListNode[] res = new ListNode[k];
        // 余数
        int remin = count % k;
        cur = root;
        for (int i = 0; i < k; i++)
        {
            int tem = len;
            ListNode ihead = cur;
            if (ihead == null)
            {
                res[i] = ihead;
                continue;
            }
            if (remin != 0)
            {
                tem += 1;
                remin--;
            }
            count = tem - 1;
            while (count > 0 && cur!= null)
            {
                count--;
                cur = cur.next;
            }
            res[i] = ihead;
            if (cur != null)
            {
                ListNode pre = cur;
                cur = cur.next;
                pre.next = null;
            }

        }

        return res;
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
        splitListToParts(l1, 5);
    }

    public static void main(String[] args) {
        new SplitLinkedListinParts().test();
    }
}
