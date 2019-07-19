package com.mx.Alo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PrintLinkListFromTailToHead
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/20 14:53
 * @Version 1.0
 **/
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
public class PrintLinkListFromTailToHead {

        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null)
        {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (stack.isEmpty() == false)
        {
            res.add(stack.pop());
        }
        return res;

    }

    public void test()
    {
        ListNode l1 = new ListNode(67);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(24);
        ListNode l4 = new ListNode(58);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        printListFromTailToHead(l1);
    }

    public static void main(String[] args) {
        new PrintLinkListFromTailToHead().test();
    }
}
