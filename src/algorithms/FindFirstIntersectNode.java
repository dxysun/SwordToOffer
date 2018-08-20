package algorithms;

import java.util.HashSet;
import java.util.Set;

/*
两个单链表相交的一系列问题
【题目】 在本题中，单链表可能有环，也可能无环。给定两个
单链表的头节点 head1和head2，这两个链表可能相交，也可能
不相交。请实现一个函数， 如果两个链表相交，请返回相交的
第一个节点；如果不相交，返回null 即可。 要求：如果链表1
的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
空间复杂度请达到O(1)。

 */
public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {

        if(head1 == null || head2 ==null)
            return null;

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if(loop1 == null && loop2 == null)
            return noLoop(head1,head2);
        if(loop1 != null && loop2 != null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }



    public static Node getLoopNode(Node head) {
        if(head == null || head.next == null || head.next.next == null)
            return null;
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast){
            if(fast.next == null || fast.next.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;

        }

        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

     /*  // 使用 set
        if (head == null)
            return null;
        Set<Node> set = new HashSet<>();
        Node node = head;
        while (node != null){
            if(set.contains(node)){
                return node;
            }
            else
                set.add(node);
            node = node.next;
        }
        return null;*/
    }

    public static Node noLoop(Node head1, Node head2) {

        if(head1 == null || head2 == null)
            return null;

        Node n1 = head1;
        int n = 0;
        while (n1.next != null){
            n1 = n1.next;
            n ++;
        }
        Node n2 = head2;
        while (n2.next != null){
            n2 = n2.next;
            n --;
        }
        if(n1 != n2)
            return null;

        n1 = n > 0 ? head1 : head2;
        n2 = n > 0 ? head2 : head1;
        n = Math.abs(n);
        while (n > 0){
            n1 = n1.next;
            n --;
        }
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node node1 = null;
        Node node2 = null;
        if(loop1 == loop2){
            node1 = head1;
            node2 = head2;
            int n = 0;
            while (node1.next != loop1){
                n ++;
                node1 = node1.next;
            }

            while (node2.next != loop1){
                node2 = node2.next;
                n --;
            }
            node1 = n > 0 ? head1 : head2;
            node2 = n > 0 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0 ){
                node1 = node1.next;
                n --;
            }
            while (node1 != node2){
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
        else {
            node1 = loop1.next;
            while (node1 != loop1){
                if(node1 == loop2)
                    return loop1;
                node1 = node1.next;
            }
            return null;
        }

    }
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
