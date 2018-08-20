package algorithms.binarytree;
/*
已知一棵完全二叉树，求其节点的个数
要求：时间复杂度低于O(N)，N为这棵树的节点个数
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getTreeNum(Node head){
        if(head == null)
            return  0;
        int left = getTreeNum(head.left);
        int right = getTreeNum(head.right);
        return 1 + left + right;
    }


    public static int nodeNum(Node head) {
        if(head == null)
            return 0;
        int h = mostLeftLevel(head,1);
        return bs(head,1,h);
    }

    private static int bs(Node head, int l, int h) {
        if(l == h)
            return 1;
        int len = mostLeftLevel(head.right,l + 1);
        if(len == h)
            return (1 << (h - l)) + bs(head.right,l + 1,h);
        else
            return (1 << (h - l - 1)) + bs(head.left,l + 1,h);

    }
    public static int mostLeftLevel(Node node, int level) {
        while (node != null){
            level ++;
            node = node.left;
        }
        return level - 1;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(getTreeNum(head));
        System.out.println(nodeNum(head));

    }


}
