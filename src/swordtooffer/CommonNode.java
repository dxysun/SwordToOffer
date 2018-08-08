package swordtooffer;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class CommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null)
        {
            stack1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null)
        {
            stack2.push(p2);
            p2 = p2.next;
        }
        ListNode last = null;
        while (!stack1.isEmpty() && !stack2.isEmpty())
        {
            ListNode l1 = stack1.pop();
            ListNode l2 = stack2.pop();
            if(l1 != l2)
            {
                break;
            }
            else
            {
                last = l1;
            }
        }
        if (last == null)
        {
            return null;
        }
        else
            return last;

    }
    public static void main(String[] args)
    {

    }
}
