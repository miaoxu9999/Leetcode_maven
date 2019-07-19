package com.mx;

/**
 * @ClassName PopulatingNextRightPointersinEachNode
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/5/4 13:48
 * @Version 1.0
 **/
public class PopulatingNextRightPointersinEachNode {
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
        //root的左右节点连接
        Node left = node.left;
        Node right = node.right;
        if (left != null && right != null)
        {
            left.next = right;
            connectNodes(left);
            connectNodes(right);
            if (node.next != null)
            {
                connectBetween(node.right, node.next.left);
            }
//            connectBetween(left.right, right.left);
//            if (right.next != null)
//            {
//                connectBetween(right.right, right.next.left);
//            }

        }
    }

    public void connectBetween(Node node1, Node node2)
    {
        if (node1 == null)
        {
            return;
        }
        node1.next = node2;
    }

}
