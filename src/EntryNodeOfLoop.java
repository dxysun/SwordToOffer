
public class EntryNodeOfLoop {

    /*
    题目描述
    一个链表中包含环，请找出该链表的环的入口结点。
     */

    public ListNode MeetNode(ListNode pHead)
    {
        if(pHead == null)
            return null;

        ListNode pSlow = pHead;
        if(pHead.next == null)
            return null;
        else
            pSlow  = pHead.next;
        ListNode pFast = pSlow.next;
        while (pFast != pSlow)
        {
            if(pSlow.next != null)
                pSlow = pSlow.next;
            else
                return null;

            if( pFast.next != null)
            {
                pFast = pFast.next;
                if(pFast.next != null)
                    pFast = pFast.next;
                else
                    return null;
            }
            else
                return null;
        }
        return pFast;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meetNode = MeetNode(pHead);
        if(meetNode == null)
            return null;

        ListNode temp = meetNode.next;
        int lenOfNode = 1;
        while (temp != meetNode)
        {
            temp = temp.next;
            lenOfNode ++;
        }
        temp = pHead;
        while (lenOfNode-- > 0)
        {
            temp = temp.next;
        }
        ListNode pNode = pHead;
        while (pNode != temp)
        {
            temp = temp.next;
            pNode = pNode.next;
        }
        return pNode;


    }
}

