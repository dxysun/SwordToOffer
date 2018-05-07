public class DeleteDuplication {

    /*
    题目描述
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
    返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

     */


    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)
            return null;
        while (pHead.next != null && pHead.val == pHead.next.val)
        {
            ListNode temp = pHead.next;
            while (temp != null && pHead.val == temp.val)
            {
                temp = temp.next;
            }
            pHead = temp;
            if(pHead == null)
                return null;
        }
        ListNode pFront = pHead;
        ListNode pTemp = pFront.next;
        ListNode pBehind = null;
        if(pTemp != null)
            pBehind = pTemp.next;
        else
            return pHead;

        while (pBehind != null)
        {
            boolean b = false;
          //  System.out.println(pBehind.val + "  ");
            while(pBehind != null && pTemp.val == pBehind.val)
            {
                b = true;
                pBehind = pBehind.next;
            }
            if(b)
            {
                pFront.next = pBehind;
                pTemp = pBehind;
            }
            else
            {
                pFront = pTemp;
                pTemp = pFront.next;
            }
            if(pTemp == null)
                break;
            pBehind = pTemp.next;
        }

        return pHead;

    }
    public static void main(String[] args)
    {
        int a[] = {1,1,2,3,3,4,5,5};
        ListNode pHead = new ListNode(a[0]);
        ListNode pNode = new ListNode(a[1]);
        pHead.next = pNode;
        for (int i = 2;i < a.length;i ++)
        {
            pNode.next = new ListNode(a[i]);
            pNode = pNode.next;
        }
    /*    pNode = pHead;
        while (pNode != null)
        {
            System.out.print(pNode.val + "  ");
            pNode = pNode.next;
        }*/
        pNode = deleteDuplication(pHead);
        while (pNode != null)
        {
            System.out.print(pNode.val + "  ");
            pNode = pNode.next;
        }

    }
}
