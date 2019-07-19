package com.mx;

/**
 * @ClassName PopulatingNextRightPointersinEachNodeII
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/9 20:52
 * @Version 1.0
 **/
public class PopulatingNextRightPointersinEachNodeII {
     

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null)
        {
            return null;
        }
        if (root.left == null && root.right == null)
        {
            return root;
        }
        connectNodes(root);
        return root;
    }

    public void connectNodes(Node node)
    {
        if (node == null)
        {
            return;
        }
        Node left = node.left;
        Node right = node.right;

        if (left != null && right != null)
        {
            left.next = right;
        }
        else if (left != null)
        {
            Node next = findNextNodeHasChild(node.next);
            left.next = next;
        }
         if (right != null)
        {
            Node next = findNextNodeHasChild(node.next);
            right.next = next;
        }
        connectNodes(left);
        connectNodes(right);
    }
    public Node findNextNodeHasChild(Node node)
    {
        while (node != null )
        {
            if (node.left != null)
            {
                return node.left;
            }
            if (node.right != null)
            {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
