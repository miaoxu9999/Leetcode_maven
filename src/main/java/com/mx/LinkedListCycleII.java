package com.mx;

import java.util.HashSet;

/**
 * @ClassName LinkedListCycleII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/2/20 16:34
 * @Version 1.0
 **/
public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode detectCycle(ListNode head) {

        //直接使用hashset
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null)
        {
            if (!set.contains(cur))
            {
                set.add(cur);
                cur = cur.next;
            }
            else
            {
                return cur;
            }
        }
        return null;

    }
}
