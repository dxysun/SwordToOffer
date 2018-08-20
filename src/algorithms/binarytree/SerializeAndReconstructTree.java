package algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;
/*
二叉树的序列化和反序列化
 */
public class SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialStr = "";

    public static String serialByPre(Node head) {
        if (head == null)
            return "#!";
        String str = head.value + "!";
        str += serialByPre(head.left);
        str += serialByPre(head.right);
        return str;
    }

    public static void serialByPre1(Node head) {
        if (head == null) {
            serialStr += "#!";
            return;
        }
        serialStr += head.value + "!";
        serialStr += serialByPre(head.left);
        serialStr += serialByPre(head.right);
    }

    public static Node reconByPreString(String preStr) {
        String[] strings = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String str : strings) {
            queue.offer(str);
        }
        return reconPreOrder(queue);

    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#"))
            return null;

        Node node = new Node(Integer.valueOf(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }

    public static String serialByLevel(Node head) {
        if (head == null)
            return "#!";
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();

        queue.offer(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                res += node.left.value + "!";
                queue.offer(node.left);
            } else
                res += "#!";

            if (node.right != null) {
                res += node.right.value + "!";
                queue.offer(node.right);
            } else
                res += "#!";
        }

        return res;
    }
    public static Node reconByLevelString(String levelStr) {
        String[] strings = levelStr.split("!");
        int index = 0;
        Node head = generateNode(strings[index ++]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            node.left = generateNode(strings[index ++]);
            node.right = generateNode(strings[index ++]);

            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);

        }
        return head;

    }

    private static Node generateNode(String string) {
        if("#".equals(string))
            return null;
        return new Node(Integer.valueOf(string));
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
        Node head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        String pre = serialByPre(head);
        serialByPre1(head);
        System.out.println("serialize tree by pre-order: " + pre);
        System.out.println("serialize tree by pre-order: " + serialStr);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println(level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

    }


}
