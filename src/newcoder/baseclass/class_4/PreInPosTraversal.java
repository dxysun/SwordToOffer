package newcoder.baseclass.class_4;

import java.util.Stack;

public class PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderPrint(Node head) {
        if (head == null)
            return;
        System.out.print(head.value + " ");
        preOrderPrint(head.left);
        preOrderPrint(head.right);
    }

    public static void inOrderPrint(Node head) {
        if (head == null)
            return;
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }

    public static void posOrderPrint(Node head) {
        if (head == null)
            return;
        posOrderPrint(head.left);
        posOrderPrint(head.right);
        System.out.print(head.value + " ");
    }


    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.value + " ");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head) {
        if (head != null) {
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
    }

    public static void posOrderUnRecur1(Node head) {
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(Node h) {

        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
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
        preOrderPrint(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderPrint(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderPrint(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order not recur: ");
        preOrderUnRecur(head);
        System.out.print("in-order not recur: ");
        inOrderUnRecur(head);
        System.out.print("pos-order not recur: ");
        posOrderUnRecur1(head);
        System.out.print("pos-order2 not recur: ");
        posOrderUnRecur2(head);
    }
}
