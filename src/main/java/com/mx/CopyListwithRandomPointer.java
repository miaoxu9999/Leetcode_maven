package com.mx;

/**
 * @ClassName CopyListwithRandomPointer
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/30 16:13
 * @Version 1.0
 **/
public class CopyListwithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if (head == null)
        {
            return null;
        }
        // 拷贝每个节点
        // 拷贝每个节点的随机节点
        Node newHead = new Node();

        newHead.val = head.val;
        Node cur = head;
        Node pre = head;
        Node curNew = newHead;
        Node preNew = newHead;
        while (cur != null)
        {
            Node temp = cur.next;
            if (temp == null)
            {
                break;
            }
            Node node = new Node();
            node.val = temp.val;
            preNew.next = node;
            preNew = node;
            cur = cur.next;
        }
        // 拷贝每个节点的随机节点
        cur = head;
        while (cur != null)
        {
            //找到random 节点和当前节点的步数
            Node random = cur.random;
            if (random == null && curNew != null)
            {
                curNew.random = null;
            }
            else
            {
                int step = findRandomNodeStep(cur, random, head);
                //根据步数查找random节点
                Node r = findNodeByStep(step, newHead);

                if (curNew != null)
                curNew.random = r;
            }
            if (curNew != null)
            curNew = curNew.next;
            cur = cur.next;
        }

        return newHead;
    }

    public int findRandomNodeStep(Node node, Node random,Node head)
    {
        int step = 0;
        Node cur = head;
        while (cur != null && !cur.equals(random))
        {
            step++;
            cur = cur.next;
        }
        return step;
    }

    public Node findNodeByStep(int step, Node head)
    {
        Node node = head;
        while (step != 0)
        {
            node = node.next;
            step--;
        }
        return node;
    }

    public void test()
    {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.random = n1;
        copyRandomList(n1);
    }

    public static void main(String[] args) {
        new CopyListwithRandomPointer().test();
    }
}
