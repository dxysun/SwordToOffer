package algorithms.binarytree;


import java.util.Stack;
/*
二叉树的各种遍历，包括递归和非递归
 */
public class PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrder(Node head) {
        if (head == null)
            return;
        System.out.print(head.value + " ");
        preOrder(head.left);
        preOrder(head.right);

    }

    public static void inOrder(Node head) {
        if (head == null)
            return;

        inOrder(head.left);
        System.out.print(head.value + " ");
        inOrder(head.right);

    }

    public static void posOrder(Node head) {
        if (head == null)
            return;
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.value + " ");

    }

    public static void preOrderUnRecur(Node head) {
        if (head == null)
            return;
        Stack<Node> nodes = new Stack<>();
        nodes.push(head);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            System.out.print(node.value + " ");
            if (node.right != null)
                nodes.push(node.right);
            if (node.left != null)
                nodes.push(node.left);
        }
        System.out.println();
    }


    public static void inOrderUnRecur(Node head) {
        if (head == null)
            return;

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node head) {
        if (head == null)
            return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null)
                stack1.push(head.left);
            if (head.right != null)
                stack1.push(head.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println();

    }

    public static void posOrderUnRecur2(Node head) {
        if (head == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && head != cur.left && head != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && head != cur.right) {
                stack.push(cur.right);
            } else {
                System.out.print(stack.pop().value + " ");
                head = cur;
            }

        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrder(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrder(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrder(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);
        System.out.print("in-order: ");
        inOrderUnRecur(head);
        System.out.print("pos-order: ");
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }


}
