package swordtooffer;

public class GetNextNode {


    /*
    题目描述
    给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        if(pNode == null)
            return null;
        TreeLinkNode pNext = null;
        if(pNode.right != null)
        {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
            {
                node = node.left;
            }
            pNext = node;
        }
        else
        {
            if(pNode.next != null)
            {
                TreeLinkNode pCur = pNode;
                TreeLinkNode pParent = pNode.next;
                while (pParent != null && pCur == pParent.right)
                {
                    pCur = pParent;
                    pParent = pCur.next;
                }
                pNext = pParent;
            }

        }
        return pNext;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
