package algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
判断一棵树是否是搜索二叉树、判断一棵树是否是完全二叉树
搜索二叉树
若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
它的左、右子树也分别为搜索二叉树

完全二叉树
按一层一层的来看，空节点在最后，就是中间没有空的
完全二叉树是由满二叉树而引出来的。
对于深度为K的，有n个结点的二叉树，
当且仅当其每一个结点都与深度为K的满二叉树中编号从1至n的结点一一对应时称之为完全二叉树。

二叉树的深度为k
满二叉树的节点为2^k -1
一棵深度为k，且有2^k-1个节点的二叉树，称为满二叉树。

具有n个节点的完全二叉树的深度为log2(n+1)。
深度为k的完全二叉树，至少有2 ^ (k-1)个节点，至多有2 ^ k - 1个节点。
 */
public class IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST(Node head) {

        if(head == null)
            return true;

        boolean res = true;

        Node pre = null;
        Node cur = head;
        Node mostRight = null;

        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {
                    mostRight.right = null;
                }
            }

            if(pre != null && pre.value > cur.value)
                res = false;

            pre = cur;
            cur = cur.right;
        }
        return res;

    }

    public static boolean isCBT(Node head) {
        if(head == null)
            return false;

        Queue<Node>  queue = new LinkedList<>();
        queue.offer(head);
        boolean leaf = false;

        Node left = null;
        Node right = null;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            left = node.left;
            right = node.right;

            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }

            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
//        head.left.left = new Node(7);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }

}
